package launchings;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

public class TC_007 extends BaseTest
{
	private static Logger log = Logger.getLogger(TC_007.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.createTest("TC_007");
		test.log(Status.INFO, "init all the properties files...");		
		
		launch("chromebrowser");
		test.log(Status.PASS, "Opening browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.PASS, "Navigating to url : " + childprop.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		test.log(Status.PASS, "Selected the option Books By using the locator : " + orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonserachtext_id","Harry Potter");
		test.log(Status.PASS, "Selected the option Books By using the locator : " + orprop.getProperty("amazondropbox_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.FAIL, "Clicked on Element By USing locator : " + orprop.getProperty("amazonsearchbutton_xpath"));
		
		report.flush();
	}
}
