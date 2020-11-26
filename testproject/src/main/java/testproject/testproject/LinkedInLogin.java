package testproject.testproject;



	
	import java.net.MalformedURLException;
	import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;
	 
	public class LinkedInLogin {
	 
		public static void main(String[] args) throws InterruptedException {
			
			//Set the Desired Capabilities
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Pixel_2_API_28");
			//caps.setCapability("udid", "ENUL6303030010"); //Give Device ID of your mobile phone
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "9.0");
			caps.setCapability("browserName", "Chrome");
			caps.setCapability("noReset", true);
			
			//Set ChromeDriver location
			System.setProperty("webdriver.chrome.driver","E:\\Workspace\\Project1\\src\\chromedriver.exe");
			
			//Instantiate Appium Driver
			AppiumDriver<MobileElement> driver = null;
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
			//Open URL in Chrome Browser
			driver.get("https://www.linkedin.com/login");
			
			driver.findElement(By.xpath("//input[@id='username']")).click();
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rashika.kowtikwar@gmail.com");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@id='password']")).click();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Advaith@123");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
		}
}
