package com.perscholas.junit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsMapContaining.*;
import static org.hamcrest.text.IsEmptyString.*;
import java.util.*;
import org.junit.Test;

public class SimpleClassTest {
	SimpleClass sc = new SimpleClass();
	
	@Test
	public void returnTrueTest() {
		assertTrue(sc.returnTrue());
	}
	
	@Test
	public void returnFalseTest() {
		assertFalse(sc.returnFalse());
	}
	
	@Test
	public void returnNullTest() {
		Object actual = sc.returnNull();
		assertNull(actual);
	}
	
	@Test
	public void returnNotNullTest() {
		assertNotNull(sc.returnNotNull());
	}
	
	@Test
	public void returnOneTest() {
		int actual = sc.returnOne();
		int expected = 1;
		assertSame(actual, expected);
	}

	@Test
	public void returnListTest() {
		String[] expected = {"red", "green", "blue"};
		Object actual = sc.returnList();
		assertThat(expected[0], not(emptyOrNullString()));
		assertEquals(actual, Arrays.asList(expected));
	}
	
	@Test
	public void returnHashMapTest() {
		Object actual = sc.returnHashMap();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("president", "Jane");
		expected.put("vice president", "James");
		expected.put("secretary", "Jennifer");
		expected.put("treasurer", "John");
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void collectionMatchersTest() {
		List<String> colors = sc.returnList();
		Map<String, String> officers = sc.returnHashMap();
		// allOf test
		assertThat(colors, allOf(hasItems("red","blue"), not(hasItems("orange"))));
		// anyOf test
		assertThat(colors, anyOf(hasItems("red", "blue"), hasItems("yellow", "cyan")));
		// both test
		assertThat(colors, both(hasItems("red")).and(hasItems("green")).and(hasItems("blue")));
		// everyItem test
		assertThat( colors, everyItem( is(not("orange")) ) );
		// Map hasEntry test
		assertThat(officers, hasEntry("president", "Jane"));
		// Map hasKey test
		assertThat(officers, hasKey("treasurer"));
		// Map hasValue test
		assertThat(officers, hasValue("James"));
	}
	
}
