package com.perscholas.qeb_selenium_lesson.automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/perscholas/qeb_selenium_lession/features/SignupTest.feature", 
		glue = "src/test/java/com/perscholas/qeb_selenium_lession/step_definitions")
public class SignupTestRunner {

}