package com.perscholas.unit_testing_7_test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({ ProductionEnv.class })
@Suite.SuiteClasses({ ProductTests.class, ShoppingCartTests.class, PaymentTests.class })
public class ProductionEnvOnly {
	
}
