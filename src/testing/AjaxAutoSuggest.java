package testing;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AjaxAutoSuggest {
 
	WebDriver d1 = new FirefoxDriver();
	// went fly..............
	@BeforeTest public void setup() throws Exception { 
		//d1.manage().window().maximize(); 
		d1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		d1.get("http://www.google.com"); } 
	@Test
	public void f() {
		//d1.findElement(By.xpath(".//*[@id='sb_ifc0']")).clear(); 
		d1.findElement(By.xpath(".//*[@id='sb_ifc0']")).sendKeys("webdriver");
		int i=1;
		
		
		for(i=0; i<4;i++)
		{
			String suggestion = d1.findElement(By.xpath(".//*[@id='sbse"+i+"']/div[2]")).getText();
			System.out.println(suggestion);
		}
  }
}
