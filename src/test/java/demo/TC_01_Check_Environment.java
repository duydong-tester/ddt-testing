package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TC_01_Check_Environment {
	WebDriver driver;

	@Test
	public void TC_01_Firefox() {
		driver = new FirefoxDriver();

		driver.get("https://www.facebook.com/");

		driver.quit();
	}

	@Test
	public void TC_02_Chrome() {
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.quit();
	}

	@Test
	public void TC_03_Edge() {
		driver = new EdgeDriver();

		driver.get("https://www.facebook.com/");

		driver.quit();
	}

}
