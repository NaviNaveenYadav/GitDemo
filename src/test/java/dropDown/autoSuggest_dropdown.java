package dropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggest_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String country = "Canada";
		String shortcutCountry = "ca";
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys(shortcutCountry);
		
		Thread.sleep(2000);
		
		List<WebElement> autoSuggest =driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		for(WebElement dropdown : autoSuggest) {
			String val = dropdown.getText();
			if(val.equalsIgnoreCase(country)) {
				dropdown.click();
				break;
			}
		}
		
		
	}

}
