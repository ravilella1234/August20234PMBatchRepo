package verificationReportings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Customer Service")));
		
		//String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		String expectedLink = "customer service";
		
		System.out.println("Actual Link : " +  actualLink);
		System.out.println("Expected Link : " +  expectedLink);
		
		//if(actualLink.equals(expectedLink))
		if(actualLink.equalsIgnoreCase(expectedLink))
			System.out.println("Both links are equal..");
		else
			System.out.println("Both links are not equal..");
			
	}

}
