package com.qa.Testcases;

import org.testng.annotations.Test;

import com.qa.Basetest.Baseclass;

public class Dashboardtest extends Baseclass {
	@Test
	public void dashboardtest1() {
		dashpage=hmpage.login(prop.getProperty("username"),prop.getProperty("password"));
		dashpage.clickrecruitment();
	}

}
