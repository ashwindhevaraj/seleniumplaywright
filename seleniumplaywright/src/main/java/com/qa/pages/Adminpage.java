package com.qa.pages;

import com.microsoft.playwright.Page;

public class Adminpage {
	private Page page;
	private String username="//label[contains(text(),'Username')]//parent::div//following-sibling::div//input";
	private String password = "input[name='password']";
	private String loginbtn = "button[type='submit']";
	public Adminpage(Page page) {
		this.page=page;
	}
	public String getTitle() {
		return page.title();
	}
	public String getUrl() {
		return page.url();
	}
	public void setUsername() {
		page.fill(username,"aswindevaraj");
		}
}
