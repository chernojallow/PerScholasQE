package com.perscholas.junit.sba4.automation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.perscholas.junit.sba1.automation.SBA1;
import com.perscholas.junit.sba2.automation.SBA2;
import com.perscholas.junit.sba3.automation.SBA3;

@RunWith(Suite.class)
@SuiteClasses({ SBA1.class, SBA2.class, SBA3.class })
public class SBA1_2_3Suite {
	

}
