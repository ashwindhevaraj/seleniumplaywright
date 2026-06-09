package com.qa.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightPagefactory {
	Playwright playwright;
	Browser browser;
	Page page;
	BrowserContext browsercontext;
	Properties prop;
	private static ThreadLocal<Browser> tlbrowser=new ThreadLocal<>();
	private static ThreadLocal<Page> tlpage=new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlbrowsercontext=new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlplaywright = new ThreadLocal<>();
	public Playwright getPlaywright() {
		return tlplaywright.get();
	}
	public BrowserContext getBrowsercontext() {
		return tlbrowsercontext.get();
	}
	public static Page getPage() {
		return tlpage.get();
	}
	public Browser getBrowser() {
		return tlbrowser.get();
	}
	
	
	public Page initbrowser(Properties prop) {
		String browsername=prop.getProperty("browser").trim();
		//playwright=Playwright.create();
		tlplaywright.set(Playwright.create());
		switch(browsername.toLowerCase()) {
		case "chromium":
			//browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlbrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(true)));
			break;
		case "firefox":
			//browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlbrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(true)));
			break;
		case "safari":
			//browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlbrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(true)));
			break;
		case "chrome":
			//browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			tlbrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(true)));
			break;
			
		default:
			System.out.println("Please select browser from chromium,firefox,chrome,safari alone");
			break;
		}
		//browsercontext=browser.newContext();
		tlbrowsercontext.set(getBrowser().newContext());
		//page=browsercontext.newPage();
		tlpage.set(getBrowsercontext().newPage());
		getPage().navigate(prop.getProperty("url").trim());
		return getPage();
	}
	public Properties init_prop() {
		try {
			FileInputStream f=new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			prop=new Properties();
			prop.load(f);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		return prop;
	}
	public static String takeScreenshot() {
		String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		return path;
	}

}
