package SSL_Certificate;

import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//SSL Certificate - Create ChromeOptions and provide the setAcceptInsecureCerts and then give to ChromeDriver
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		//Proxy concept
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipAddress:8080");
		
		
		options.setCapability("proxy", proxy);
		
		WebDriver driver = new ChromeDriver(options);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		

	}

}
