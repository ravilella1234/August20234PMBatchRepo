package launchings;

import org.apache.log4j.Logger;

public class TC_006 extends BaseTest
{
	private static Logger log = Logger.getLogger(TC_006.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("init all the properties files...");
		
		launch("chromebrowser");
		log.info("Opening browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigating to url : " + childprop.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		log.info("Sselected the option Books By using the locator : " + orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonserachtext_id","Harry Potter");
		log.info("Entered the text Harry Potter By Using Locator : " + orprop.getProperty("amazonserachtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Element By USing locator : " + orprop.getProperty("amazonsearchbutton_xpath"));
	}
}
