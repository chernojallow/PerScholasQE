package com.perscholas.selenium_cucumber_sba.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/perscholas/selenium_cucumber_sba/features/PopularSessionRequirement.feature", 
		glue = "com/perscholas/selenium_cucumber_sba/step_definitions")
public class PopularSessionRunner {

}