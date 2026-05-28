package seleniumcheck;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;

public class First {
	public static void main(String args[]) {
		/*Playwright playwright= Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setChannel("msedge");
		lp.setHeadless(false);
		Browser browser=playwright.chromium().launch(lp);
		Page pageref=browser.newPage();
		pageref.pause();
		pageref.navigate("https://www.gmail.com");
		String title=pageref.title();
		System.out.println(title);
		String pageurl=pageref.url();
		System.out.println(pageurl);
		browser.close();
		playwright.close();*/
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      // place this lines before starting script to get trace of screenshots
		      context.tracing().start(new Tracing.StartOptions()
		    		  .setScreenshots(true)
		    		  .setSnapshots(true)
		    		  .setSources(true));
		      Page page = context.newPage();
		      page.navigate("https://academy.naveenautomationlabs.com/s/store/courses?query=checking");
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("logo")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("checking");
		      page.getByRole(AriaRole.BUTTON).filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Selenium Quiz - 1 cover")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
		      page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Name")).click();
		      page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Name")).fill("aswin");
		      page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Name")).press("Tab");
		      page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Email address")).fill("testing");
		      page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Email address")).press("Tab");
		      page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Password")).fill("testing");
		      page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Enter your number")).click();
		      page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Enter your number")).fill("+91 88888-88888");
		      page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
		      page.locator("#microfe-popup-login").contentFrame().locator("#loginPopupCloseBtn svg").click();
		      //placing this line will get closing screenshot scope upto this point
		      // go trace.playwright.dev - you will find the way to upload file- upload this trace.zip under workspace
		      context.tracing().stop(new Tracing.StopOptions()
		    		  .setPath(Paths.get("trace.zip")));
		      
		      // writing another browser context
		      BrowserContext context1 = browser.newContext();
		      Page p2= context1.newPage();
		      p2.navigate("https://opensource-demo.orangehrmlive.com/");
		      p2.locator("//input[@name='username']").fill("Aswin");
		      //p2.close();
		      p2.navigate("https://www.amazon.com");
		      Locator v1=p2.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
		      v1.allInnerTexts().forEach(e->System.out.println(e));
		      //p2.close();
		      //context1.close();
		      //browser context closed
		      //browser.close();
		      //playwright.close();
		      
		      BrowserContext store1= browser.newContext();
		      Page p3=store1.newPage();
		      p3.navigate("https://www.automationpractice.com");
		      p3.pause();
		    }
	}

}
