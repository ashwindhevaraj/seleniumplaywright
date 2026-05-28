package com.qa.pages;

import com.microsoft.playwright.Page;

public class Homepage {
	private Page page;
	private String username="input[name='username']";
	private String password = "input[name='password']";
	private String loginbtn = "button[type='submit']";
	public Homepage(Page page) {
		this.page=page;
	}
	public String getTitle() {
		return page.title();
	}
	public String getUrl() {
		return page.url();
	}
	public Dashboardpage login(String uname,String pword) {
		page.fill(username,uname);
		page.fill(password,pword);
		page.click(loginbtn);
		return new Dashboardpage(page);
	}

}
