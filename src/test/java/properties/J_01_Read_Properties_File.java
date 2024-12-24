package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class J_01_Read_Properties_File {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/testData/data.properties");
		Properties properties = new Properties();
		properties.load(file);

		String appUrl = properties.getProperty("appUrl");
		String email = properties.getProperty("email");
		String password = properties.getProperty("password");
		String fullname = properties.getProperty("fullname");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(appUrl);

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@title='Login']")).click();

		driver.switchTo().alert().accept();

		Thread.sleep(Duration.ofSeconds(5));

		String message = driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText();

		if (message.equals("Hello, " + fullname + "!")) {
			System.out.println("Passed!");
		} else {
			System.out.println("Failed!");
		}

		driver.quit();
	}

}
