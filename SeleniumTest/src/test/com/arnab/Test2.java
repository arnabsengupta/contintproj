package test.com.arnab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import test.com.arnab.SeleniumTest.BaseTest;

public class Test2 extends BaseTest{

	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void test(){
		
		driver.get("http://www.calculator.net/");
		driver.findElement(By.partialLinkText("Mortgage Calculator")).click();
		driver.findElement(By.cssSelector("input[type=\"image\"]:nth-child(2)")).click();
		
		
	}
	
	@After
	public void quit(){
		driver.quit();
	}
}
