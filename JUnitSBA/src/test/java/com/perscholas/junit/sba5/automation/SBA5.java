package com.perscholas.junit.sba5.automation;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringStartsWith.startsWith;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

import com.perscholas.junit.sba5.InvalidPasswordException;
import com.perscholas.junit.sba5.ListMapClass;
import com.perscholas.junit.sba5.User;

public class SBA5 {
	private static ListMapClass lmc;
	
	@BeforeClass
	public static void setup() {
		lmc = new ListMapClass();
	}
	
	@Test
	public void citiesTest() {
		assertThat(lmc.cities().get(0), is("Dallas"));
		assertThat(lmc.cities().get(2), anyOf(containsString("oston"), startsWith("B")));
		assertThat(lmc.cities().get(4), not("Detriot"));
	}
	
	@Test
	public void getUserListTest() throws InvalidPasswordException {
		List<User> user = lmc.getUserList();
		assertThat(user.get(0).getName(), is("John"));
		assertThat(user.get(1).getUserId(), not("joan1234"));
		assertThat(user.size(),is(3));
	}
	
	@Test
	public void getCoursesMapTest() {
		Map<String, String> lmc1 = lmc.getCoursesMap();
		assertThat(lmc1, hasEntry("ASM", "Application Support Management"));
		assertThat(lmc1, hasKey("DE"));
		assertThat(lmc1, hasValue("Java Developer"));
	}
	
	
	@Test
	public void getUserMapTest() throws InvalidPasswordException {
		Map<Integer, User> um = lmc.getUserMap();
		assertThat(um, hasEntry(10, um.get(10)));
		assertThat(um, hasValue(um.get(12)));
		assertThat(um.get(12).getName(),is("Jaclyn"));

	}
	
	
}
