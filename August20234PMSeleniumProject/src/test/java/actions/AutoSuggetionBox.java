package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggetionBox 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("hadoop tutorial");
		String var = driver.findElement(By.id("APjFqb")).getAttribute("value");
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='Alh6id']//descendant::ul//li/descendant::div[8]/span"));
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getText().equals(var))
			{
				list.get(i).click();
				return;
			}
		}
	}

}
