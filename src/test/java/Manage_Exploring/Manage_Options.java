package Manage_Exploring;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Manage_Options {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ChromeOptions options = new ChromeOptions();
//		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("Naveen");
		
		//This will log out from the session and navigates to the Home Screen / Login screen
		driver.manage().deleteCookieNamed("sessionKey");
		//Click on any link then navigate to the Login Page.
		
		driver.get("https://www.google.com/");

	}

}
