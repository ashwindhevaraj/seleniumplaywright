package com.qa.pages;

import com.microsoft.playwright.Page;

public class Dashboardpage {
	private Page page;
	private String recruitment = "a[href='/web/index.php/recruitment/viewRecruitmentModule']";
	private String Admin = "//span[text()='Admin']";
	public Dashboardpage(Page page) {
		this.page=page;
	}
	/*public void searchdashboard(String searchtext) {
		page.fill(search, searchtext);
	}*/
	public void clickrecruitment() {
		page.click(recruitment);
	}
	public Adminpage clickAdmin() {
		page.click(Admin);
		return new Adminpage(page);
	}

}
