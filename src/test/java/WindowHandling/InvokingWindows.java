package WindowHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class InvokingWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		String parentWindow = driver.getWindowHandle();		

//		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentWin = it.next();
		String childWin = it.next();
		
		Assert.assertEquals(parentWindow, parentWin);	
		
		driver.switchTo().window(childWin);
		driver.get("https://rahulshettyacademy.com/#/index");
		System.out.println(driver.getTitle());
		
		String courseName = driver.findElement(By.xpath("(//div[@id='courses-block']//div[@class='upper-box']//a)[1]")).getText();
		
		driver.switchTo().window(parentWin);
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys(courseName);
		
		driver.quit();

	}

}
