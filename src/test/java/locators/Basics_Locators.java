package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics_Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		
		//ID Locator
		driver.findElement(By.id("inputUsername")).sendKeys("NaveenYadav@gmail.com");
		
		//name Locator
		driver.findElement(By.name("inputPassword")).sendKeys("NaveenYadav");
		
		//class Locator
		driver.findElement(By.className("signInBtn")).click();
		
		//cssSelector Locator
		String credentialsError = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(credentialsError);
		
		//linkText Locator
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//xpath Locator
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("NaveenYadav");
		
		//cssSelector Locator
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("NaveenYadav@gmail.com");		
		
		//xpath Locator
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("naveenyadav@gmail.com");
		
		//cssSelector Locator
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("naveenvaddarapu@gmail.com");
		
		//xpath - Parent to child
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
		
		//cssSelector Locator
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//cssSelector - Parent to child
		String tempPwdMsg = driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(tempPwdMsg);
		
		//csSelector
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Naveen");
		driver.findElement(By.cssSelector("input[type*=pass]")).sendKeys("rahulshettyacademy");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//id Locator
		driver.findElement(By.id("chkboxOne")).click();
		
		//xpath
		driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();		
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
