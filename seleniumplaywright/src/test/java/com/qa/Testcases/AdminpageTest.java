package com.qa.Testcases;

import org.testng.annotations.Test;

import com.qa.Basetest.Baseclass;

public class AdminpageTest extends Baseclass {
	@Test
	public void adminpagetest() {
		dashpage=hmpage.login(prop.getProperty("username"),prop.getProperty("password"));
		admpage=dashpage.clickAdmin();
		admpage.setUsername();
	}

}
