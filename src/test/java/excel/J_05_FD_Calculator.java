package excel;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class J_05_FD_Calculator {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		driver.findElement(By.xpath("//button[text()='No thanks']")).click();

		String dataFilePath = System.getProperty("user.dir") + "/testData/calData.xlsx";

		int rows = ExcelUtils.getLastRowIndex(dataFilePath, "Data");

		for (int r = 1; r <= rows; r++) {
			String principle = ExcelUtils.getCellData(dataFilePath, "Data", r, 0);
			String interest = ExcelUtils.getCellData(dataFilePath, "Data", r, 1);
			String per1 = ExcelUtils.getCellData(dataFilePath, "Data", r, 2);
			String per2 = ExcelUtils.getCellData(dataFilePath, "Data", r, 3);
			String frequency = ExcelUtils.getCellData(dataFilePath, "Data", r, 4);
			String expMValue = ExcelUtils.getCellData(dataFilePath, "Data", r, 5);

			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(interest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']"))).selectByVisibleText(per2);
			new Select(driver.findElement(By.xpath("//select[@id='frequency']"))).selectByVisibleText(frequency);

			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

			String result = driver.findElement(By.xpath("//span[text()='Maturity Value Rs.']/parent::div//strong")).getText();

			if (Double.parseDouble(result) == Double.parseDouble(expMValue)) {
				System.out.println(r + " Passed!");
				ExcelUtils.setCellData(dataFilePath, "Data", r, 7, "Passed");
				ExcelUtils.fillGreenColor(dataFilePath, "Data", r, 7);
			} else {
				System.out.println(r + " Failed!");
				ExcelUtils.setCellData(dataFilePath, "Data", r, 7, "Failed");
				ExcelUtils.fillRedColor(dataFilePath, "Data", r, 7);
			}

			driver.findElement(By.xpath("//div[@class='cal_div']//a[2]")).click();
		}

		driver.quit();
	}

}
