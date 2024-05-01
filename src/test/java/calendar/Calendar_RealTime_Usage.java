package calendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar_RealTime_Usage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String monthNum = "6";
		String date = "9";
		String year = "2027";
		
		String[] expectedList = {monthNum,date,year};
		
		WebElement calendarPicker = driver.findElement(By.xpath("//button[contains(@class,'calendar-button')]"));
		calendarPicker.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(@class,'calendar__navigation__label')]")).click();
		Thread.sleep(2000);
		
		String initYear = driver.findElement(By.xpath("//span[contains(@class,'calendar__navigation__label')]")).getText();
		int initialYear = Integer.parseInt(initYear);
		
		int yearDiff = initialYear - Integer.parseInt(year);
		int temp1 = yearDiff;
		int temp2 = yearDiff;
		if(temp1 < 0) {
			for(int i=yearDiff; i<0;i++) {
				driver.findElement(By.xpath("//button[contains(@class,'navigation__next-button')]")).click();
			}
			temp1++;
		}		
		else if(temp2 >0) {
			for(int i=0;i<yearDiff;i++) {
				driver.findElement(By.cssSelector("button[class*='navigation__prev-button']")).click();
			}
			temp2--;
		}
		
		List<WebElement> months = driver.findElements(By.cssSelector("button[class*='year-view__months__month'] abbr"));
		months.get(Integer.parseInt(monthNum)-1).click();
		
		driver.findElements(By.xpath("//div[contains(@class,'month-view__days')] //button[not(contains(@class,'day--neighboringMonth'))]/abbr")).get(Integer.parseInt(date)-1).click();
		
		List<WebElement> ls = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i=0;i<ls.size();i++) {
			System.out.println(ls.get(i).getAttribute("value"));
			Assert.assertEquals(ls.get(i).getAttribute("value"), expectedList[i]);
		}
		
//		driver.close();
	}

}
