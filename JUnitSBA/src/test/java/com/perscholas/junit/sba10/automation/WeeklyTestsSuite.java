package com.perscholas.junit.sba10.automation;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({WeeklyTest.class})
@Suite.SuiteClasses({InstructorTests.class, StudentTests.class, SchoolTests.class})
public class WeeklyTestsSuite {

}
