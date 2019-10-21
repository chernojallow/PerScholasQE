package com.perscholas.unit_testing_exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex2 {
	Random rand = new Random();
	Integer[] n = {rand.nextInt(10), rand.nextInt(10), rand.nextInt(10)};
	Float n1 = rand.nextFloat();
	
	public Integer[] getN() {
		return n;
	}
	
	public Float getN1() {
		return n1;
	}
	
	public Integer returnAddNbr() {
		Integer i1 = rand.nextInt(n.length-1), i2 = null;
		do {
			i2 = rand.nextInt(n.length-1);
		} while(i2 == i1);
		
		return n[i1] + n[i2];
	}
	
	public Integer returnMultiplyNbr() {
		Integer i1 = rand.nextInt(n.length-1), i2 = null;
		
		do {
			i2 = rand.nextInt(n.length-1);
		} while(i2 == i1);
		
		return n[i1] * n[i2];
	}
	
	public Integer returnPowerNbr() {
		Integer i1 = rand.nextInt(n.length-1), i2 = null;
		
		do {
			i2 = rand.nextInt(n.length-1);
		} while(i2 == i1);
		
		return (int) Math.pow(n[i1], n[i2]);
	}
	
	public Integer returnRoundNbr() {
		return Math.round(n1);
	}
	
	public List<String> returnList() {
		List<String> students = new ArrayList<String>();
		students.add("Cherno");
		students.add("Goutham");
		students.add("Chen");
		
		return students;
	}
	
}
