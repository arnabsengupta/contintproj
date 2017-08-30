package test.com.arnab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import test.com.arnab.SeleniumTest.BaseTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

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
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
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
