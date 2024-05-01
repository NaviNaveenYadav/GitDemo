package alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts_Handling {

	public static void main(String[] args) {

		String name = "Naveen";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		driver.switchTo().alert().accept();

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.cssSelector("#confirmbtn")).click();
		String alertConfirmMsg = driver.switchTo().alert().getText();
		System.out.println(alertConfirmMsg);
		driver.switchTo().alert().dismiss();

	}

}
