import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.testng.annotations.Test;


public class otpVerify {
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {
            try {
                appLogin();
            }
            catch (Exception exp)
        {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

    @Test
    public static void appLogin() throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","emulator-5554");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","13");
        cap.setCapability("appPackage","io.maqsad.dev");
        cap.setCapability("appActivity","io.maqsad.activities.SplashScreenActivity");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        Thread.sleep(1000);
        MobileElement getStarted = driver.findElement(By.id("io.maqsad.dev:id/getStartedButton"));
        getStarted.click();

        Thread.sleep(2000);

        MobileElement phoneNo = driver.findElement(By.id("io.maqsad.dev:id/phoneNumberField"));
        phoneNo.sendKeys("3012692034");

        MobileElement submitPhone =driver.findElement(By.id("io.maqsad.dev:id/signInButton"));
        submitPhone.click();

        MobileElement otpEnter = driver.findElement(By.className("android.widget.EditText"));
    // Manually enter OTP and wait for OTP verification PART

        Thread.sleep(30000);

        MobileElement maqsadLayaBanner = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        maqsadLayaBanner.click();

        MobileElement maqsadWheel = driver.findElement(By.id("io.maqsad.dev:id/lottieAnimation"));
        maqsadWheel.click();

        // Wheel load time wait
        Thread.sleep(5000);

        MobileElement wheelAcceptance = driver.findElement(By.id("io.maqsad.dev:id/cameraOnBoardingTextView1"));
        wheelAcceptance.click();

    }

}