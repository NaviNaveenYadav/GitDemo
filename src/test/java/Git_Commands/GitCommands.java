package Git_Commands;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitCommands {
	
//	1) Initialize the folder as Git repository - git init
	
//	2) Add the files to staging - git add *
	// Here the "*" means to add all the files to the staging
	
//	3) Commit the files (which are added to the staging) to the Git - git commit -m "Message"
	
//	4)Connect your local repository to the remote server. use the below command if it is for the first time
	// git remote add origin <server url>
	
//	push the code to the Github Repository -  git push origin master.
	
//	The below link is the confluence page for the GIT Commands
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html"); //Git Commands Confluence Page
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
