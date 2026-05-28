package com.qa.listener;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import static com.qa.factory.PlaywrightPagefactory.takeScreenshot;;

public class Extendreportlistener implements ITestListener{
	private static final String OUTPUT_FOLDER = "./build/";
	private static final String FILE_NAME = "TestExecutionReport.html";
	
	private static ExtentReports extent = init();
	private static ExtentReports extentreports;
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	private static ExtentReports init() {
		Path path=Paths.get(OUTPUT_FOLDER);
		if(!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		extentreports= new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		reporter.config().setReportName("Orange HRM report creation by Ash");
		extentreports.attachReporter(reporter);
		extentreports.setSystemInfo("SYSTEM","ASHTEST");
		extentreports.setSystemInfo("AUTHOR","ASWINDEVARAJ");
		extentreports.setSystemInfo("BUILD","1.1");
		extentreports.setSystemInfo("TEAM","ASHTEAMANDCO");
		return extentreports;
	}
	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println("Test suite started");
	}
	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println("Test suite ended");
		extent.flush();
		test.remove();
	}
	@Override
	public synchronized void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		String qualifiedname = result.getMethod().getQualifiedName();
		int last=qualifiedname.lastIndexOf(".");
		int mid=qualifiedname.substring(0,last).lastIndexOf(".");
		String classname=qualifiedname.substring(mid+1,last);
		
		System.out.println(methodname+" method started");
		ExtentTest extentest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
		extentest.assignCategory(result.getTestContext().getSuite().getName());
		extentest.assignCategory(classname);
		test.set(extentest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
	}
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Passed");
		test.get().pass("Test Passed");
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}
	public synchronized void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" Failed!");
		test.get().fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());	
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}
	private Date getTime(long mills) {
		Calendar calendar= Calendar.getInstance();
		calendar.setTimeInMillis(mills);
		return calendar.getTime();
	}
}
