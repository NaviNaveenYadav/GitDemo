package Scrolling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling_JavaScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=400");
		
		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//td[4]"));
		
		int total = 0;
		
		for(WebElement value : values) {
			int amount = Integer.parseInt(value.getText());
			total = total + amount;
		}
		
		String totalAmount = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		int actualAmount = Integer.parseInt(totalAmount);
		
		System.out.println("Expected Amount : " + actualAmount);
		System.out.println("Actual Amount : " + total);
		Assert.assertEquals(actualAmount, total);
	}

}
