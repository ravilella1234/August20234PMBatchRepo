package launchings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{

		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		/*driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Philips");
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("field-keywords")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("nav-input")).sendKeys("Samsung");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Sony");*/
		
		//driver.findElement(By.linkText("Customer Service")).click();
		
		//driver.findElement(By.partialLinkText("Customer Serv")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				String link = links.get(i).getText();
				System.out.println(link);
			}
		}
	}

}
