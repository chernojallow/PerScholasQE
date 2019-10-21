package com.perscholas.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestClassOne.class, TestClassTwo.class, TestClassThree.class})
public class TestSuiteClass {
	
}
