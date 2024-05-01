package ScreenShot_Concept;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Partial_Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Capture the WebElement Screenshot
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement name = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
		name.sendKeys("Naveen");
		
		File src = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\Automation Screenshots\\name"));
		
		//Get Height & Width of the WebElements
		
		System.out.println(name.getRect().getDimension());
		System.out.println(name.getRect().getDimension().getWidth());
		System.out.println(name.getRect().getDimension().getHeight());
		

	}

}
