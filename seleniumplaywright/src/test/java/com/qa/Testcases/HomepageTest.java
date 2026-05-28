package com.qa.Testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.Basetest.Baseclass;
import com.qa.constants.Appconstant;

public class HomepageTest extends Baseclass {
	@Test
	public void firsttest() {
		String title=hmpage.getTitle();
		Assert.assertEquals(title,Appconstant.ORANGE_HRM_TITLE);
	}
	@Test
	public void secondtest() {
		String url=hmpage.getUrl();
		System.out.println(url);
		Assert.assertEquals(true,true);
	}
	@Test
	public void thirdtest() {
		hmpage.login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(true, true);
	}
}
