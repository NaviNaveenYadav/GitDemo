package calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar_Current_Date {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("(//div[@class='picker-first2'])[1]/button[@class='ui-datepicker-trigger']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("The Return date field is Enabled");
		}
		else {
			System.out.println("The Return date field is Disabled");
		}
		
//		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		driver.findElement(By.cssSelector("input[id*='rbtnl_Trip_1']")).click();
//		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		
	}

}
