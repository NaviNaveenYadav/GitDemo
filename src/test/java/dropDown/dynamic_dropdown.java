package dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamic_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//input[contains(@id,'originStation1_CTXT')]")).click();
		
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(2000);
		
		//Using index to handle the dropdown
//		driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		
		//Using Parent - Child relation to handle the dropdown
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation1_CTNR')]//a[@value='HYD']")).click();
		
	}

}
