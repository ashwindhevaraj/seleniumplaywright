package com.qa.Basetest;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.factory.PlaywrightPagefactory;
import com.qa.pages.Dashboardpage;
import com.qa.pages.Homepage;

public class Baseclass {
	PlaywrightPagefactory pf;
	Page page;
	protected Homepage hmpage;
	protected Properties prop;
	protected Dashboardpage dashpage;
	@BeforeTest
	public void setup() {
		pf=new PlaywrightPagefactory();
		prop=pf.init_prop();
		page=pf.initbrowser(prop);
		hmpage=new Homepage(page);
	}
	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}

}
