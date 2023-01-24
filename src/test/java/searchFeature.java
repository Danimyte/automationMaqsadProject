import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;

public class searchFeature {
    static AppiumDriver<MobileElement> driver;


    @Test
    public static void main(String[] args) {
        try {
            searchResults();
        }
        catch (Exception exp)
        {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }
    @Test
    public static void searchResults() throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","adb-07472371AP002184-AoCydz._adb-tls-connect._tcp");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11");

        cap.setCapability("appPackage","io.maqsad");
        cap.setCapability("appActivity","io.maqsad.activities.SplashScreenActivity");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);


        Thread.sleep(1000);

        MobileElement getStarted = driver.findElement(By.id("io.maqsad:id/getStartedButton"));
        getStarted.click();

        Thread.sleep(3000);

        MobileElement phoneNo = driver.findElement(By.id("io.maqsad:id/phoneNumberField"));
        phoneNo.sendKeys("3012692034");

        MobileElement submitPhone =driver.findElement(By.id("io.maqsad:id/signInButton"));
        submitPhone.click();

        /*
        MobileElement otpEnter = driver.findElement(By.className("android.widget.EditText"));
        // Manually enter OTP and wait for OTP verification PART

        MobileElement maqsadLayaBanner = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
//        maqsadLayaBanner.click();

//        MobileElement maqsadWheel = driver.findElement(By.id("io.maqsad.dev:id/lottieAnimation"));
//        maqsadWheel.click();

        // Wheel load time wait
//        Thread.sleep(5000);
//
//        MobileElement wheelAcceptance = driver.findElement(By.id("io.maqsad.dev:id/cameraOnBoardingTextView1"));
        wheelAcceptance.click();
*/

        Thread.sleep(15000);

        MobileElement lecturesTab = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Lectures\"]/android.widget.FrameLayout/android.widget.ImageView"));
        lecturesTab.click();

        Thread.sleep(2000);

        MobileElement searchIcon = driver.findElement(By.id("io.maqsad:id/searchIcon"));
        searchIcon.click();

        Thread.sleep(2000);
        MobileElement searchNow = driver.findElement(By.id("io.maqsad:id/searchEditText"));
        searchNow.sendKeys("biology");

        Thread.sleep(3500);

        String pageSource = driver.getPageSource();

        Assert.assertTrue(pageSource.contains("physics"));

    }

}
