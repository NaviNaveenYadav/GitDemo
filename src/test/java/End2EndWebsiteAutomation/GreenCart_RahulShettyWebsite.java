package End2EndWebsiteAutomation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCart_RahulShettyWebsite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] itemsNeeded = {"Cucumber", "Cauliflower","Tomato","Beans","Apple","Water Melon","Cashews"};
		addProducts(driver, itemsNeeded);
		
		WebElement addToCartIcon =driver.findElement(By.xpath("//div[@class='cart']//a[@class='cart-icon']/img"));
		addToCartIcon.click();
		
		WebElement checkoutCTA = driver.findElement(By.cssSelector("div[class*='cart-preview'] button"));
		checkoutCTA.click();
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		Wait<WebDriver> wt = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		
		String couponMsg = driver.findElement(By.cssSelector(".promoInfo")).getText();
		System.out.println(couponMsg);
		
		
		
		
		
	}
	
	public static void addProducts(WebDriver driver, String[] itemsNeeded) {
		
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		int count = 0;
		for(int i=0;i<products.size();i++) {
			String name = products.get(i).getText().split("-")[0].trim();
			ArrayList<String> itemsNeededList = new ArrayList<String>(Arrays.asList(itemsNeeded));
			if(itemsNeededList.contains(name)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();	
				System.out.println(name);
				count++;
			}
			if(count == itemsNeeded.length) {
				break;
			}			
		}		
	}

}
