package com.perscholas.junit.sba6.automation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.junit.sba6.InvalidPasswordException;
import com.perscholas.junit.sba6.User;

import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

@RunWith(Parameterized.class)
public class ParameterizedTest {
	// Declare attributes
	private Integer userId;
	private String name;
	private String password;
	private Double javaScore;
	private Double sqlScore;
	
	public ParameterizedTest(Integer userId, String name, String password, Double javaScore, Double sqlScore) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.javaScore = javaScore;
		this.sqlScore = sqlScore;
	}
	
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                		{1, "ChenLi", "chenmingli", 80.2, 80.9},
                		{2, "GouthamBuvanendiran", "adityagoutham", 85.4, 85.7},
                		{3, "ChernoJallow", "zikacherno", 60.1, 60.8},
                		{4, "LinXiao", "xiaolin996", 70.0, 70.6} });
    }
    
    @Test
    public void contraintTest() throws InvalidPasswordException {
    	User u = new User();
    	u.setUserId(userId);
    	u.setName(name);
    	u.setPassword(password);
    	u.setJavaScore(javaScore);
    	u.setSqlScore(sqlScore);
    	
    	assertThat(u.toString(), not(emptyOrNullString()));
    }
    
    @Test
    public void calculateCreditsTest() throws InvalidPasswordException {
    	User u = new User();
    	u.setUserId(userId);
    	u.setName(name);
    	u.setPassword(password);
    	u.setJavaScore(javaScore);
    	u.setSqlScore(sqlScore);
    	
    	assertThat(u.toString(), not(emptyOrNullString()));
    	
    	if (u.getJavaScore() >= 70 && u.getSqlScore() >= 70)
    		assertThat(u.calculateCredits(), is(2));
    	else if (u.getJavaScore() >= 70 || u.getSqlScore() >= 70)
    		assertThat(u.calculateCredits(), is(1));
    	else assertThat(u.calculateCredits(), is(0));
    }
    
}
