package test.com.arnab;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import test.com.arnab.SeleniumTest.BaseTest;

public class Test3 extends BaseTest{
	

	@Before
	public void setUp(){
	System.setProperty("webdriver.firefox.driver", "/home/tamajit/firefox/firefox");
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//	driver = new FirefoxDriver();
	//DesiredCapabilities capability = DesiredCapabilities.firefox();
	//capability.setCapability(ChromeOptions.CAPABILITY, 0);

	try {
		driver = new RemoteWebDriver(new URL("http://9.120.20.56:5558/wd/hub"), DesiredCapabilities.firefox());
		//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	@Test
	public void test(){
		driver.manage().window().maximize();
		driver.get("http://www.calculator.net/");
		driver.findElement(By.partialLinkText("House Affordability Calculator")).click();
		driver.findElement(By.cssSelector("input[type=\"image\"]:nth-child(2)")).click();
		
		
	}
	
	@After
	public void quit(){
		driver.quit();
	}
}
