package Streams_Selenium;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String product = "Pine";
		int expectedCount = 1;
		
		driver.findElement(By.id("search-field")).sendKeys(product);
		
		Thread.sleep(2000);
		List<WebElement> veggies = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')]//tbody//tr"));
		
		List<String> filteredList = veggies.stream().map(S->S.getText().toLowerCase())
				.filter(S->S.contains(product.toLowerCase())).collect(Collectors.toList());
		
		if(expectedCount == 0) {
			Assert.assertEquals(0,veggies.size()-1);
		}
		else 
		Assert.assertEquals(veggies.size(), filteredList.size());
		

	}

}
