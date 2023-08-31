package launchings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

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
	public static String projectpath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainprop;
	public static Properties childprop;
	
	public static void init() throws Exception
	{
		//FileInputStream fis = new FileInputStream("D:\\April2022WD\\August20234PMSeleniumProject\\src\\test\\resources\\data.properties");
		System.out.println(projectpath);
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\environment.properties");
		mainprop = new Properties();
		mainprop.load(fis);
		String e = mainprop.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\"+e+".properties");
		childprop = new Properties();
		childprop.load(fis);
		String val = childprop.getProperty("amazonurl");
		System.out.println(val);
	}
	
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		}else if(p.getProperty(browser).equals("firefox")) {
			FirefoxOptions option2 = new FirefoxOptions();
			option2.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(p.getProperty(browser).equals("edge")) {
			EdgeOptions option1 = new EdgeOptions();
			option1.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(option1);
		}
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(childprop.getProperty(url));
		//driver.navigate().to(url);
	}

}
