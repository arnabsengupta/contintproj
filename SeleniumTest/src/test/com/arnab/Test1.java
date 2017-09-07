package test.com.arnab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import test.com.arnab.SeleniumTest.BaseTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test1 extends BaseTest{


public String SEL_PROP = "selenium.properties";
	
	private String getprop(String prop) throws FileNotFoundException, IOException{
		Properties p = new Properties();
		p.load(new FileInputStream(SEL_PROP));
		String message = p.getProperty(prop);
		return message;
	}
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.firefox.driver", "/home/tamajit/firefox/firefox");
		//System.setProperty("webdriver.chrome.driver", "/home/tamajit/Downloads/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\mavenworkspace\\SeleniumTest\\chromedriver.exe");
		//driver = new ChromeDriver();
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		//capability.setCapability(ChromeOptions.CAPABILITY, 0);
	
		try {
			driver = new RemoteWebDriver(new URL("http://9.184.214.122:5558/wd/hub"), DesiredCapabilities.chrome());
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
		driver.findElement(By.partialLinkText("Mortgage Calculator")).click();
		driver.findElement(By.cssSelector("input[type=\"image\"]:nth-child(2)")).click();
		
		
	}
	
	@After
	public void quit(){
		driver.quit();
	}
}
