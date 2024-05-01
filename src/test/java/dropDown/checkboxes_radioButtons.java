package dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkboxes_radioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("label[for*='chk_friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='chk_IndArm']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='chk_IndArm']")).isSelected());
		

	}

}
