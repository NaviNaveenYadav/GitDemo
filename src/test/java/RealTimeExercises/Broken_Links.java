package RealTimeExercises;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Broken_Links {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement footerSection = driver.findElement(By.id("gf-BIG"));
		
		
		//Broken Link means Broken URL
		//Java Methods will call the URL's and gets you the status code
		
		//Step 1 : is to get all the URL's tied up to the links using Selenium
		//step 2 : Use the Java methods for the URLs
		//Step 3 : if status code >400 then the link is broken
		
		List<WebElement> href = footerSection.findElements(By.cssSelector("td ul li>a"));
		
		//Soft Assertion
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : href) {
			String url = link.getAttribute("href");
			
			HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int statusCode = con.getResponseCode();
//			if(statusCode > 400) {
//				System.out.println("\"" +link.getText() +"\"" + " link is broken and status code is : " + statusCode);
//				
//			}
			
			//soft Assertion implementation
			a.assertTrue(statusCode < 400, "The \"" + link.getText() +"\" link is broken with status code " + statusCode);			
		}
		
		a.assertAll();
//		driver.quit();
	}

}
