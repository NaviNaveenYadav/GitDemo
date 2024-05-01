package RealTimeExercises;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope_Of_WebDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Give me the count of the links in the page
		int linksCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linksCount);
		
		//Give me the count of the link for the footer section only
		WebElement footerSec = driver.findElement(By.id("gf-BIG")); //Limiting the WebDriver scope		
		int footerSecCountLinks = footerSec.findElements(By.tagName("a")).size();
		System.out.println(footerSecCountLinks);
		
		//Give me the 1st column links count in Footer Section
		WebElement firstColumn = footerSec.findElement(By.xpath("(//td//ul)[1]"));
		int firstColumnCount = firstColumn.findElements(By.tagName("a")).size();
		System.out.println(firstColumnCount);
		
		String[] firstColumnLinksTitles = {"REST API Tutorial","The World's Most Popular API Testing Tool | SoapUI","Appium Mobile Automation Testing from Scratch + Frameworks Tutorial | Udemy","Apache JMeter - Apache JMeter™"};
		for(int i=1;i<firstColumnCount;i++) {
			String keyAction = Keys.chord(Keys.CONTROL,Keys.ENTER);		
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(keyAction);
		}
		
		ArrayList<String> windows =  new ArrayList<String>(driver.getWindowHandles());
		
		Set<String> windowsHandle = driver.getWindowHandles();
		Iterator<String> it = windowsHandle.iterator();
		String parentWindow = driver.getWindowHandle();
		while(it.hasNext()) {
			driver.switchTo().window(it.next()).getTitle();
			System.out.println(driver.getTitle());
		}
		
		
		
		//Give me the count of the headings present in the Page
//		System.out.println("h1 count : " + driver.findElements(By.tagName("h1")).size());
//		System.out.println("h2 count : " + driver.findElements(By.tagName("h2")).size());
//		System.out.println("h3 count : " + driver.findElements(By.tagName("h3")).size());
//		System.out.println("h4 count : " + driver.findElements(By.tagName("h4")).size());
//		System.out.println("h5 count : " + driver.findElements(By.tagName("h5")).size());
//		System.out.println("h6 count : " + driver.findElements(By.tagName("h6")).size());
		
		//Short cut to get the count of the headings present in the Page
//		int headingsCount = 0;
//		for(int i=1;i<=6;i++) {
//			System.out.println("h"+String.valueOf(i) + " : " + (driver.findElements(By.tagName("h"+String.valueOf(i))).size()));
//			headingsCount = headingsCount + driver.findElements(By.tagName("h"+String.valueOf(i))).size();
//		}
//		System.out.println("The total count of the heading tags : " + headingsCount);
		
//		driver.quit();
	}

}
