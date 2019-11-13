package com.perscholas.springmvc_jdbctemplate.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.springmvc_jdbctemplate.model.Student;
import com.perscholas.springmvc_jdbctemplate.repositories.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping(value = { "/", "/allStudents" })
	public String getAllStudents(Model model) throws ClassNotFoundException, IOException, SQLException {
		List<Student> allStudents = studentRepository.getAllStudents();
		model.addAttribute("allStudents", allStudents);
		return "Students";
	}

	@GetMapping("/studentForm")
	public String displayStudentForm(Model model) {
		model.addAttribute("student", new Student());
		System.out.println("Chen is the best! I love Chen");
		return "StudentForm";
	}

	@PostMapping("/createStudent")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "StudentForm";
		}
		Integer studentId = studentRepository.createStudent(student);
		if (studentId == -1) {
			model.addAttribute("errorMessage", "Create student failed.");
			return "StudentForm";
		}
		System.out.println("Student ID: " + studentId);
		return "redirect:allStudents";
	}

	@GetMapping("/studentById/{id}")
	public String getStudentById(@PathVariable Integer id, Model model) throws SQLException {
		Student student = studentRepository.getStudentById(id);
		if (student == null) {
			model.addAttribute("errorMessage", "Student not found.");
		} else {
			model.addAttribute("student", student);
		}
		return "StudentPage";
	}

	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		Boolean result = studentRepository.deleteStudent(id);
		System.out.println(result);
		return "forward:/allStudents";
	}

	@GetMapping("/updateStudentForm/{id}")
	public String updateForm(@PathVariable Integer id, Model model) throws SQLException {
		Student student = studentRepository.getStudentById(id);
		model.addAttribute("student", student);
		return "UpdateStudentForm";
	}

	@PostMapping("/updateStudent")
	public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "UpdateStudentForm";
		}
		Boolean updateResult = studentRepository.updateStudent(student);
		if (!updateResult) {
			model.addAttribute("errorMessage", "Edit student failed.");
			return "UpdateStudentForm";
		}
		System.out.println(updateResult);
		return "redirect:/studentById/" + student.getStudentId();
	}
}