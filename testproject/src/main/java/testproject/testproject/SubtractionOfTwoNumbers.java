package testproject.testproject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Hello world!
 *
 */
public class SubtractionOfTwoNumbers 
{
    public static void main( String[] args ) throws MalformedURLException, InterruptedException
    {
        System.out.println( "Hello World!" );
        File f=new File("src");
		File fs=new File(f,"Pixel Calculator_v1.0.1.7_apkpure.com.apk");
		
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_API_28"); // Android Emulator
    	dc.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator"); // This is Launcher activity of your app
                                                                                // (you can get it from apk info app)

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, dc);

        
        Thread.sleep(5000);

        // locate the Text on the calculator by using By.name()
        WebElement seven = driver.findElementById("com.android.calculator2:id/digit_7");
        seven.click();
        WebElement plus = driver.findElementById("com.android.calculator2:id/op_sub");
        plus.click();
        WebElement three = driver.findElementById("com.android.calculator2:id/digit_3");
        three.click();
        WebElement equalTo = driver.findElementById("com.android.calculator2:id/eq");
        equalTo.click();

        // locate the edit box
        String results = driver.findElementById("com.android.calculator2:id/result").getText();
        System.out.println("Results is...."+results);
        
        if(results.equals("4"))
        {
            System.out.println("Test Passed...");
        }
        else
        {
        	
        	System.out.println("Test Failed");
        }
        

    }
    
    
}
