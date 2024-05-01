package Streams_Selenium;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Pagination_Using_Stream {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Step 1: Click on the column
		// Step 2: Capture all the elements in the list
		// Step 3: Capture the text of all web Elements into the new list
		// Step 4: Sort the new list of Step 3 --> Sorted List
		// step 5: Compare the sorted list with the step 3 list

		driver.findElement(By.cssSelector(".table-bordered thead th:nth-child(1)")).click();
		List<WebElement> products;
		products = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')]//tbody//td[1]"));

		List<String> originalList = products.stream().map(S -> S.getText()).collect(Collectors.toList());

		List<String> sortedProducts = originalList.stream().sorted().collect(Collectors.toList());

		boolean flag = sortedProducts.equals(originalList);
		System.out.println(flag);
		Assert.assertTrue(flag);

		// Scan the name column with getText --> Beans --> Print the price of the
		// product
		String product = "Almond";
		List<String> price;
		price = products.stream().filter(S -> S.getText().contains(product)).map(S -> getVeggiePrice(S))
				.collect(Collectors.toList());
		System.out.println(price.size());
		while (price.size() == 0) {
			driver.findElement(By.xpath("//ul[contains(@class,'pagination')]//a[@aria-label='Next']")).click();

			products = driver.findElements(By.xpath("//table[contains(@class,'table-bordered')]//tbody//td[1]"));
			price = products.stream().filter(S -> S.getText().contains(product)).map(S -> getVeggiePrice(S))
					.collect(Collectors.toList());
			WebElement termination = driver
					.findElement(By.xpath("//ul[contains(@class,'pagination')]//a[@aria-label='Next']"));
			if (termination.getAttribute("aria-disabled").equalsIgnoreCase("true")) {
				break;
			}
		}

		if (price.size() > 0) {
			System.out.println("The price of the \"" + product + "\" is: " + price.get(0));
		} else {
			System.out.println("The \"" + product + "\" is not present in the list");
		}
		driver.close();

	}

	public static String getVeggiePrice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
