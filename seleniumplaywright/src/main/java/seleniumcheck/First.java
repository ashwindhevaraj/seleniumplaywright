package seleniumcheck;

import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
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
		      //BrowserContext context = browser.newContext();
		      //Page page = context.newPage();
		      /*page.navigate("https://academy.naveenautomationlabs.com/s/store/courses?query=checking");
		      page.pause();
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
		      */
		      
		      // writing another browser context
		      BrowserContext context1 = browser.newContext();
		      Page p2= context1.newPage();
		   // place this lines before starting script to get trace of screenshots
		      context1.tracing().start(new Tracing.StartOptions()
		    		  .setScreenshots(true)
		    		  .setSnapshots(true)
		    		  .setSources(true));
		      // class 1 alert handled
		      /*p2.onDialog(dialog->{
		      System.out.println(dialog.message());
		      dialog.dismiss();
		      });
		      p2.navigate("https://opensource-demo.orangehrmlive.com/");
		      p2.locator("//input[@name='username']").fill("Admin");
		      p2.locator("//input[@placeholder='Password']").fill("admin123");
		      p2.locator("//button").click();
		      p2.locator("//span[text()='My Info']").click();
		      p2.locator("//form/div[4]/button").click();
		      p2.locator("//span[text()='My Info']").click();*/
		      // class 2 broken image validation in playwright
		      /*p2.navigate("https://the-internet.herokuapp.com/broken_images");
		      Locator image=p2.locator("img");
		      int n=image.count();
		      for(int i=0;i<n;i++) {
		    	  Locator imageexact=image.nth(i);
		    	  boolean loaded = (boolean) p2.evaluate("img=> img.complete && img.naturalWidth > 0", imageexact.elementHandle());
		    	  String src=imageexact.getAttribute("src");
		    	  if(loaded)
		    		  System.out.println("valid image "+src);
		    	  else
		    		  System.out.println("Invalid image"+src);
		      }*/
		      //class 3- getting element from table
		      /*p2.navigate("https://the-internet.herokuapp.com/challenging_dom");
		      Locator tablerow = p2.locator("xpath=//table//tr");
		      int rowcount = tablerow.count();
		      for(int i=0;i<rowcount;i++) {
		    	  Locator column= tablerow.nth(i).locator("xpath=./th|./td");
		    	  for(int j=0;j<column.count();j++) {
		    		  System.out.print(column.nth(j).innerText()+"  ");
		    	  }
		    	  System.out.println();
		      }*/
		      //class 4= context click
		      /*p2.navigate("https://the-internet.herokuapp.com/context_menu");
		      p2.locator("xpath=//div[@id='hot-spot']").click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));*/
		      //class 5 = drag and drop
		      
		      /*p2.navigate("https://the-internet.herokuapp.com/drag_and_drop");
		      p2.dragAndDrop("#column-a","#column-b");*/
		      
		      //class 6 handling frame
		      /*p2.navigate("https://the-internet.herokuapp.com/frames");
		      p2.locator("text=iFrame").click();
		      System.out.println(p2.frameLocator("#mce_0_ifr").locator("#tinymce>p").innerText());
		      p2.goBack();
		      p2.locator("text=Nested Frames").click();
		      System.out.println(p2.frameLocator("xpath=//frame[@name='frame-top']").frameLocator("xpath=//frame[@name='frame-middle']").locator("#content").innerText());*/
		      
		      //class 7 dropdown 
		      /*p2.navigate("https://the-internet.herokuapp.com/dropdown");
		      p2.locator("#dropdown").selectOption(new SelectOption().setLabel("Option 1"));
		      System.out.println(p2.locator("#dropdown").inputValue());*/
		      
		      //class 8 dynamic content in web application
		      /*p2.navigate("https://the-internet.herokuapp.com/dynamic_content");
		      Locator l1=p2.locator("//div[@id='content' and contains(@class,'large-10')]//div[@class='large-10 columns']");
		      for(int i=0;i<l1.count();i++) {
		    	  System.out.println(l1.nth(i).textContent());
		      }*/
		      //class 9 - blocking ads in page
		      p2.route("**/*", route -> {

		    	    String url = route.request().url();
		    	    if (url.contains("cookie") ||
		    	        url.contains("banner") ||
		    	        url.contains("newsletter")) {

		    	        route.abort();

		    	    } else {

		    	        route.resume();
		    	    }

		    	});
		      //class 10 mouse hover
		      /*p2.navigate("https://the-internet.herokuapp.com/hovers");
		      Locator l2=p2.locator("xpath=//img[@alt='User Avatar']");
		      for(int i=0;i<l2.count();i++) {
		    	  l2.nth(i).hover();
		    	  System.out.println(l2.nth(i).innerText());
		      }*/
		      
		      //class 11 window handler in playwright
		      /*p2.navigate("https://the-internet.herokuapp.com/windows");
		      Page p3=context1.waitForPage(()->{
		    	  p2.locator("xpath=//a[text()='Click Here']").click();
		      });
		      String k=p3.locator("xpath=//div[@class='example']").innerText();
		      System.out.println(k);*/
		      
		      //class 12 table learned part 2- getting values of column amet
		      /*p2.navigate("https://the-internet.herokuapp.com/challenging_dom");
		      List<String> headerdata= p2.locator("table thead th").allTextContents();
		      int checkheader = headerdata.indexOf("Amet");
		      System.out.println(checkheader); //4
		      Locator rows= p2.locator("table tbody tr");
		      boolean found=false;
		      for(int i=0;i<rows.count();i++) {
		    	  String contactdata = rows.nth(i).locator("td:nth-child("+(checkheader+1)+")").textContent().trim();
		    	  if(contactdata.equals("Consequuntur1")) {
		    		  found=true;
		    		  System.out.println("found at row "+(i+1));
		    		  break;
		    	  }
		      }*/
		      //class 13 storage of login and reusing
		      p2.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		      p2.locator("[placeholder='Username']").fill("Admin");
		      p2.locator("[placeholder='Password']").fill("admin123");
		      p2.locator("[type='submit']").click();
		      context1.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
		      
		      BrowserContext newcontext2=browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));
		      Page p3= newcontext2.newPage();
		      p3.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		      p3.locator("[href='/web/index.php/leave/viewLeaveModule']").click();
		      
		    //placing this line will get closing screenshot scope upto this point
		      // go trace.playwright.dev - you will find the way to upload file- upload this trace.zip under workspace
		      context1.tracing().stop(new Tracing.StopOptions()
		    		  .setPath(Paths.get("trace.zip")));
		      
		      
		      //p2.navigate("https://www.amazon.com");
		      //Locator v1=p2.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
		      //v1.allInnerTexts().forEach(e->System.out.println(e));
		      //p2.close();
		      p2.close();
		      context1.close();
		      //browser context closed
		      //browser.close();
		      //playwright.close();
		      
		      /*BrowserContext store1= browser.newContext();
		      Page p3=store1.newPage();
		      p3.navigate("https://www.automationpractice.com");
		      p3.pause();*/
		    }
	}

}
