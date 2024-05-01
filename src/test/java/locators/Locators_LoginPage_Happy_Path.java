package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators_LoginPage_Happy_Path {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Naveen";
		Locators_LoginPage_Happy_Path obj = new Locators_LoginPage_Happy_Path();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		
		String password = obj.getPassword(driver);
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*=pass]")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();		
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		
		Thread.sleep(2000);
		String suc = driver.findElement(By.cssSelector("div[class='login-container'] p")).getText();	
		System.out.println(suc);
		
		Assert.assertEquals(suc, "You are successfully logged in.");
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(), "Hello "+name+",");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.close();
		
	}
	
	
	public String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(1000);
		String tempPwdMsg = driver.findElement(By.cssSelector("form p")).getText();
		
		String tempPwd = tempPwdMsg.split("'")[1];
		
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		return tempPwd;	
	} 
	

}
