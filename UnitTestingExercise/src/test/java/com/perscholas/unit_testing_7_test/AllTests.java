package com.perscholas.unit_testing_7_test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@SuppressWarnings("unused")
@RunWith(Suite.class)
@Suite.SuiteClasses({ ProductTests.class, ShoppingCartTests.class, PaymentTests.class })
//@RunWith(Categories.class)
//@Categories.IncludeCategory({ ProductionEnv.class, TestEnv.class })

public class AllTests {

}
