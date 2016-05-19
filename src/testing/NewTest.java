package testing;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest {
	WebDriver d1 = new FirefoxDriver();
	

	@BeforeTest
	public void perform_login() 
	{
		//d1.manage().window().maximize();
		d1.get("http://demosite.center/wordpress/wp-login.php");
		d1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority=0)
	public void login() 
	{
		d1.findElement(By.xpath(".//label[contains(text(),'Username')]/input[1]")).sendKeys("admin"); //Using XPath find the nth ele of type ------1
		d1.findElement(By.xpath(".//label[contains(text(),'Username')]/input[1]//following::input[1]")).sendKeys("demo123"); //Using XPath find the nth ele of type 1
		d1.findElement(By.xpath(".//input[@class='button-primary' and @id='wp-submit']")).click();    // using css class attribute in css selectors ------2 
		Assert.assertEquals("Dashboard",d1.findElement(By.xpath("//*[starts-with(@id,'wpbody-content')]/div[4]/h2")).getText()); //partial matches on attributes--- 3
		
	}
	@Test(priority=1)
	public void dynamic()
	{
		for(int i=1;i<5;i++)
		{
			String text=d1.findElement(By.xpath("//*[starts-with(@id,'dashboard_')]/div[2]/div[1]/table/tbody/tr["+i+"]/td[2]/a")).getText(); //dynamic element in selenium 4
			System.out.println("Test is="+text);
		}

	}
	@Test(priority=2)
	public void window_handle()
	{
		d1.findElement(By.xpath(".//*[@id='menu-posts']/a")).click(); // page navigation 5
		d1.navigate().back();
		d1.navigate().forward();
		
	}
	@Test(priority=3)
	public void windowHandle() // 5
	{
		Actions ac=new Actions(d1);
		WebElement we=d1.findElement(By.xpath(".//*[@id='post-63']/td[1]/strong"+ "/a"));
		ac.contextClick(we).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		Set<String>win=d1.getWindowHandles();		//7
		String window1_parent= (String) win.toArray()[0];
		String window2_child = (String) win.toArray()[1];
		d1.switchTo().window(window1_parent);
		
		System.out.println("On New Window");
		d1.switchTo().window(window2_child);
	
		System.out.println("On previous window");
	}
	@AfterTest
	public void tearDown()
	{
		//d1.quit();
	}

}
