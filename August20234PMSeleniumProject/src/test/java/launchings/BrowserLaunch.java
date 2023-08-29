package launchings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		WebDriver driver;

		ChromeOptions option = new ChromeOptions();
		option.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:/Users/ravi/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		 driver = new ChromeDriver(option);
		 driver.get("https://www.amazon.in");
		
		 EdgeOptions option1 = new EdgeOptions();
		 option1.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver(option1);
		 driver.get("https://www.bestbuy.com");
		
		 
		 FirefoxOptions option2 = new FirefoxOptions();
		 option2.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com");
	
		
	}

}
