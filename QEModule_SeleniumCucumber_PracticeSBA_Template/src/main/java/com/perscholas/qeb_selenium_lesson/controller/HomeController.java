package com.perscholas.qeb_selenium_lesson.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.perscholas.qeb_selenium_lesson.models.Book;

@SessionAttributes
@Controller
public class HomeController {
	
	private List<Book> bookCart;
	private Book book;
	private Double cartTotal;
	
	public HomeController() {
		bookCart = new ArrayList<>();
		cartTotal = 0.0;
	}
	
	@RequestMapping("/")
	public String showSignUpPage() {
		return "SignUpPage";
	}
	
	@RequestMapping("signUp")
	public String signUp(@RequestParam Map<String,String> allParams) {
		return "forward:/successPage";
	}
	
	@RequestMapping("/successPage")
	public String showSuccessPage(@RequestParam Map<String,String> allParams, Model model) {
		for (Map.Entry<String, String> entry: allParams.entrySet()) {
			System.out.println(entry.getValue());
		}
		model.addAttribute("allParams", allParams);
		return "SuccessPage";
	}
	
	@RequestMapping("/bookstore")
	public String showBookstore() {
		return "BookstorePage";
	}
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	public String addToCart(@RequestParam Map<String, String> allParams, HttpSession session) {
		DecimalFormat df = new DecimalFormat("#.##");
		book = new Book();
		book.setTitle(allParams.get("title"));
		book.setPrice(Double.parseDouble(allParams.get("price")));
		cartTotal += book.getPrice();
		String cartTotalString = df.format(cartTotal);
		bookCart.add(book);
		session.setAttribute("bookCart", bookCart);
		session.setAttribute("cartTotal", cartTotalString);
		return "forward:/bookstore";
	}
	
	@RequestMapping(value="/clearShoppingCart", method=RequestMethod.POST)
	public String clearShoppingCart(HttpSession session) {
		bookCart.clear();
		cartTotal = 0.0;
		session.setAttribute("bookCart", bookCart);
		session.setAttribute("cartTotal", cartTotal);
		return "forward:/bookstore";
	}
	
	@RequestMapping(value="/placeOrder", method=RequestMethod.POST)
	public String placeOrder(HttpSession session) {
		bookCart.clear();
		cartTotal = 0.0;
		session.setAttribute("bookCart", bookCart);
		session.setAttribute("cartTotal", cartTotal);
		return "redirect:/orderPlaced";
	}
	
	@RequestMapping("/orderPlaced")
	public String orderPlaced() {
		return "OrderPlaced";
	}
	
	@RequestMapping("/iFramesPage")
	public String showInternalFramesPage() {
		return "InternalFramesPage";
	}
	
	@RequestMapping("/showFirstFrame")
	public String showFirstFrame() {
		return "FirstFrame";
	}
	
	@RequestMapping("/showSecondFrame")
	public String showSecondFrame() {
		return "SecondFrame";
	}
	
	@RequestMapping("/showAlertPage")
	public String showAlertPage() {
		return "AlertPage";
	}
}
