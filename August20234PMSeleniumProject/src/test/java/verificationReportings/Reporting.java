package verificationReportings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import launchings.BaseTest;

public class Reporting extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.createTest("Reporting");
		test.log(Status.INFO, "init all the properties files...");		
		
		launch("chromebrowser");
		test.log(Status.PASS, "Opening browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.PASS, "Navigating to url : " + childprop.getProperty("amazonurl"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Customer Service")));
		
		String expectedLink = "Customer service";
		
		if(!isLinksEqual(expectedLink))
			reportFailure("Links are not equal...");
		else
			reportSuccess("Links are equal..");
		
		report.flush();
			
	}
}
