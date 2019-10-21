package com.perscholas.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.*;
import org.junit.rules.TestName;

public class TestFixtures {
		// The @BeforeClass method will run once before all tests
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			System.out.println("Setting up BeforeAfterTest test class @ " + LocalTime.now());
		}

		// The @AfterClass method will run once after all tests
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			System.out.println("Completing BeforeAfterTest test class @ " + LocalTime.now());
		}

		// The @Before method will run prior to each test method
		@Before
		public void setUp() throws Exception {
			System.out.println("Setting up test method @ " + LocalTime.now());
		}

		// The @After method will run after each test method
		@After
		public void tearDown() throws Exception {
			System.out.println("Tearing down test method @ " + LocalTime.now());
		}
		
		/* Here we see an example of the use of a rule to instantiate a TestName
		 * object which will allow us to return each test method name using the getMethodName()
		 * method. Rules will be discussed more in another section.
		 */
		@Rule public TestName name = new TestName();

		@Test
		public void testOne() {
			System.out.println(name.getMethodName());
			assertTrue(Math.sqrt(25) == 5);
		}
		
		@Test
		public void testTwo() {
			System.out.println(name.getMethodName());
			assertFalse(Math.pow(2, 2) == 5);
		}											
}
