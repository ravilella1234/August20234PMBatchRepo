package launchings;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectOption("amazondropbox_id","Books");
		
		typeText("amazonserachtext_id","Harry Potter");
		
		clickElement("amazonsearchbutton_xpath");
					
		
		/*WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		loc.sendKeys("Books");
		
		driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();*/
	}

	

}
