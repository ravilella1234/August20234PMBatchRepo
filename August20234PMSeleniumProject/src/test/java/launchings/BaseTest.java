package launchings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	
	public static WebDriver driver;
	
	public static void launch(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		}else if(browser.equals("firefox")) {
			FirefoxOptions option2 = new FirefoxOptions();
			option2.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equals("edge")) {
			EdgeOptions option1 = new EdgeOptions();
			option1.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(option1);
		}
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(url);
	}

}
