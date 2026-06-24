package com.qa.Basetest;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.factory.PlaywrightPagefactory;
import com.qa.pages.Adminpage;
import com.qa.pages.Dashboardpage;
import com.qa.pages.Homepage;
import org.testng.annotations.Parameters;

public class Baseclass {
	PlaywrightPagefactory pf;
	Page page;
	protected Homepage hmpage;
	protected Properties prop;
	protected Dashboardpage dashpage;
	protected Adminpage admpage;
	
	
	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browsername) {
		pf=new PlaywrightPagefactory();
		prop=pf.init_prop();
		if(browsername!=null) {
			prop.setProperty("browser", browsername);
		}
		page=pf.initbrowser(prop);
		hmpage=new Homepage(page);
	}
	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}

}
