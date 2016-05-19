package testing;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cache {
	WebDriver d1 =  new FirefoxDriver();

	// @Test
	// public void WhenCookieIsNotSet()
	// {
	// System.out.println("here.........");
	// d1.findElement(By.xpath(".//*[@id='Email']")).sendKeys("");
	// d1.findElement(By.xpath(".//*[@id='next']")).click();
	// d1.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("");
	// d1.findElement(By.xpath(".//*[@id='signIn']")).click();
	//
	// }
	@Test(priority = 1)
	public void whenCookieIsSet() {

		Set<Cookie> c = getAllCookies();
		System.out.println(c);
		d1.manage().deleteAllCookies();

		// Cookie name=new Cookie("firfox","123456789123");
		// d1.manage().addCookie(name);
		//
		// d1.manage().deleteCookieNamed("firefox");
		// public static void retrieveValuesFromListMethod1(Set set)
		// {
		// Iterator itr = set.iterator();
		// while(itr.hasNext())
		// {
		// System.out.println(itr.next());
		// }
		// }
	}

	public Set<Cookie> getAllCookies() {
		return d1.manage().getCookies();
	}

	@BeforeTest
	public void navigate() {
		d1.get("https://gmail.com");
		d1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
