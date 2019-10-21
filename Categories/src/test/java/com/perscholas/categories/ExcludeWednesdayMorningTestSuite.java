package com.perscholas.categories;

import org.junit.runner.RunWith;
import org.junit.experimental.categories.*;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory(WednesdayMorningTests.class)
@Suite.SuiteClasses({CoffeeTests.class, EspressoTests.class, CappuccinoTests.class})
public class ExcludeWednesdayMorningTestSuite {

}
