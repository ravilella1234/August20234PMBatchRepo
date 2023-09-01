package browseroptions;

import java.util.Collections;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsDemo 
{

	public static void main(String[] args) 
	{
		ChromeOptions option = new ChromeOptions();
		option.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		option.addArguments("--start-maximized");
		//option.addArguments("--headless");
		option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		option.addArguments("--disable-notifications");
		//option.addArguments("--incognito");
		//option.addArguments("--proxy-server=//192.168.10.1:1947");
		option.addArguments("--ignore-certificate-errors"); // https://expired.badssl.com/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		//driver.get("https://www.amazon.in");
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
