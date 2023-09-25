package testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import launchings.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_003 extends BaseTest
{
	
  @BeforeMethod
  @Parameters("browser")
  public void startProcess(String btype) throws Exception 
  {
	  System.out.println("BeforeMethod");
	    init();
		test = report.createTest("TNG_003");
		test.log(Status.INFO, "init all the properties files...");		
		
		launch(btype);
		test.log(Status.PASS, "Opening browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.PASS, "Navigating to url : " + childprop.getProperty("amazonurl"));
  }
  
  @Test
  public void amazon() 
  {
	  System.out.println("F method");
	    selectOption("amazondropbox_id","Books");
		test.log(Status.PASS, "Selected the option Books By using the locator : " + orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonserachtext_id","Harry Potter");
		test.log(Status.PASS, "Selected the option Books By using the locator : " + orprop.getProperty("amazondropbox_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.FAIL, "Clicked on Element By USing locator : " + orprop.getProperty("amazonsearchbutton_xpath"));
  }

  @AfterMethod
  public void endProcess() 
  {
	  System.out.println("After Method");
	  driver.quit();
	  report.flush();
  }

}
