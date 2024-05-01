package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_Tranverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//xpath - Traverse from sibling to Sibling level
		String txt1 = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(txt1);
		
		//xpath - Traverse from child to parent level
		String txt2 = driver.findElement(By.xpath("//header/div/button[1]/parent::div//button[1]")).getText();
		System.out.println(txt2);
		
		
	}

}
