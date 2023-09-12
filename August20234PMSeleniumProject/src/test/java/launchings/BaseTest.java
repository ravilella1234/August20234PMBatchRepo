package launchings;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	
	public static WebDriver driver;
	public static String projectpath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainprop;
	public static Properties childprop;
	public static Properties orprop;
	public static ExtentReports report;
	public static ExtentTest test;
	
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
		
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\or.properties");
		orprop = new Properties();
		orprop.load(fis);
		
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report  = ExtentManager.getInsatnce();
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
		driver.manage().window().maximize();
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(childprop.getProperty(url));
		//driver.navigate().to(url);
	}
	
	public static void clickElement(String locatorkey) 
	{
		//driver.findElement(By.xpath(orprop.getProperty(locatorkey))).click();
		getElement(locatorkey).click();
	}

	public static void typeText(String locatorkey, String text) 
	{
		//driver.findElement(By.name(orprop.getProperty(locatorkey))).sendKeys(text);
		getElement(locatorkey).sendKeys(text);
	}

	public static void selectOption(String locatorkey, String option) 
	{
		//driver.findElement(By.id(orprop.getProperty(locatorkey))).sendKeys(option);
		getElement(locatorkey).sendKeys(option);
	}
	
	public static WebElement getElement(String locatorkey) 
	{
		WebElement element = null;
		
		if(!isElementPresent(locatorkey))
			// report a failure
				System.out.println("Element is not present with locator : " + locatorkey);
		
		element = driver.findElement(getLocator(locatorkey));
		
		/*if(locatorkey.endsWith("_id")) {
			element = driver.findElement(By.id(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_name")) {
			element = driver.findElement(By.name(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_classname")) {
			element = driver.findElement(By.className(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_linktexttext")) {
			element = driver.findElement(By.partialLinkText(orprop.getProperty(locatorkey)));
		}*/
		return element;
	}


	public static boolean isElementPresent(String locatorkey) 
	{
		System.out.println("Checking the Eleemnt present : " + locatorkey);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
		
		/*if(locatorkey.endsWith("_id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orprop.getProperty(locatorkey))));
		}else if(locatorkey.endsWith("_name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orprop.getProperty(locatorkey))));
		}else if(locatorkey.endsWith("_classname")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orprop.getProperty(locatorkey))));
		}else if(locatorkey.endsWith("_xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orprop.getProperty(locatorkey))));
		}else if(locatorkey.endsWith("_css")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orprop.getProperty(locatorkey))));
		}else if(locatorkey.endsWith("_linktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orprop.getProperty(locatorkey))));
		}else if(locatorkey.endsWith("_partiallinktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orprop.getProperty(locatorkey))));
		}*/
		return true;
	}
	
	public static By getLocator(String locatorkey) 
	{	
		By by = null;
		
		if(locatorkey.endsWith("_id")) {
			by = By.id(orprop.getProperty(locatorkey));
		}else if(locatorkey.endsWith("_name")) {
			by = By.name(orprop.getProperty(locatorkey));
		}else if(locatorkey.endsWith("_classsname")) {
			by = By.className(orprop.getProperty(locatorkey));
		}else if(locatorkey.endsWith("_linktext")) {
			by = By.linkText(orprop.getProperty(locatorkey));
		}else if(locatorkey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orprop.getProperty(locatorkey));
		}else if(locatorkey.endsWith("_xpath")) {
			by = By.xpath(orprop.getProperty(locatorkey));
		}else if(locatorkey.endsWith("_css")) {
			by = By.cssSelector(orprop.getProperty(locatorkey));
		}
		
		return by;
		
	}

}
