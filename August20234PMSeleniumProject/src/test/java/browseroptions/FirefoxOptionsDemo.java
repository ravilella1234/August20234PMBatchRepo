package browseroptions;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxOptionsDemo 
{

	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();

		FirefoxOptions option = new FirefoxOptions();
		option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//option.addArguments("--headless");
		option.addArguments("--private");
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		ProfilesIni allprofile = new ProfilesIni();
		FirefoxProfile profile = allprofile.getProfile("September2023FF");
		
		//disable webnotifications
		profile.setPreference("dom.webnotifications.enabled", false);
		
		//to ignore Certificate errors
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		
		//Working with proxy Settings
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "192.168.0.1");
		profile.setPreference("network.proxy.socks_port", 1981);
		option.setProfile(profile);
		
		WebDriver driver = new FirefoxDriver(option);
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		
		driver.get("https://www.amazon.in");
		System.out.println(driver.getTitle());
	}

}
