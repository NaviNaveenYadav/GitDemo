package FramesHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://jqueryui.com/droppable/");
		
		Actions act = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		WebElement draggable = driver.findElement(By.cssSelector("#draggable p"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		System.out.println(draggable.getText());
		System.out.println(droppable.getText());
		
		act.dragAndDrop(draggable, droppable).build().perform();
		
		driver.switchTo().defaultContent();
		
		System.out.println(driver.findElement(By.cssSelector(".demo-list ul li.active a")).getText());
		
	}

}
