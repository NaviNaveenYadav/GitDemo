package dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class updated_dropdown_NoSelectTag {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		Thread.sleep(2000);
		
		String adultCountString = driver.findElement(By.xpath("//span[@id='spanAudlt']")).getText();
		int adultCount = Integer.parseInt(adultCountString);
		
		for(int i=adultCount;i<=4;i++) {
			driver.findElement(By.xpath("//div[@id='divAdult']//span[@id='hrefIncAdt']")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
