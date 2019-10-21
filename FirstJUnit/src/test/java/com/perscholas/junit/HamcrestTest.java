package com.perscholas.junit;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.Test;

public class HamcrestTest {
	SimpleClass sc = new SimpleClass();
	
	@Test
	public void returnTrueTest() {
		assertThat(sc.returnTrue(), not(sc.returnFalse()));
		
		assertThat(sc.returnTrue(), is(true));
		assertThat(sc.returnTrue(), is(not(false)));
		
		assertThat(sc.returnTrue(), equalTo(true));
		assertThat(sc.returnTrue(), not(equalTo(false)));
		
		assertThat(sc.returnTrue(), sameInstance(true));
		assertThat(sc.returnTrue(), not(sameInstance(false)));
	}
	
	@Test
	public void returnFalseTest() {
		assertThat(sc.returnFalse(), not(sc.returnTrue()));
		
		assertThat(sc.returnFalse(), is(false));
		assertThat(sc.returnFalse(), is(not(true)));
		
		assertThat(sc.returnFalse(), equalTo(false));
		assertThat(sc.returnFalse(), not(equalTo(true)));
		
		assertThat(sc.returnFalse(), sameInstance(false));
		assertThat(sc.returnFalse(), not(sameInstance(true)));
		
	}
	
	@Test
	public void returnNullTest() {
		assertThat(sc.returnNull(), not(sc.returnNotNull()));
		
		assertThat(sc.returnNull(), allOf(not(true), not(false)));
		
		assertThat(sc.returnNull(), is(sameInstance(null)));
		
		assertThat(sc.returnNull(), equalTo(null));
		
		assertThat(sc.returnNull(), is(nullValue()));
		assertThat(sc.returnNull(), is(not(notNullValue())));
		
	}
	
	@Test
	public void returnListTest() {
		List<String> colors = sc.returnList();
		
		assertThat(colors, allOf(hasItems("red","blue"), not(hasItems("orange"))));
		assertThat(colors, anyOf(hasItems("red", "blue"), hasItems("yellow", "cyan")));
		assertThat(colors, both(hasItems("red")).and(hasItems("green")).and(hasItems("blue")));
		assertThat(colors, everyItem(is(not("orange"))));
	}
	
	public void returnHashMapTest() {
		Map<String, String> officers = sc.returnHashMap();
		
		assertThat(officers, hasEntry("president", "Jane"));
		assertThat(officers, hasKey("vice president"));
		assertThat(officers, hasValue("John"));
		
		assertThat(officers, anyOf(hasValue("James"), hasValue("president"), not(hasValue("balblabla"))));
		assertThat(officers, allOf(hasValue("president"), hasValue("Jennifer")));
		
	}
	
}
