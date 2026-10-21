package com.academy.testUtils;

import com.academy.pageObjects.android.FormPage;
import com.academy.utils.AppiumUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils {

    public AndroidDriver driver;
    public FormPage formPage;

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\academy\\resources\\data.properties");
        props.load(fis);
        String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : props.getProperty("ipAddress");
        String port = props.getProperty("port");

        service= startAppiumServer(ipAddress, Integer.parseInt(port));

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(props.getProperty("AndroidDeviceName"));
        options.setCapability("enforceXPath1", true);
//        options.setDeviceName("Android Device"); //real device
        options.setChromedriverExecutable("C:\\webdriver\\chromedriver-win64\\chromedriver.exe");
//        options.setApp(System.getProperty("user.dir")+"\\src\test\java\com\academy\resources\\ApiDemos-debug.apk");
        options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\com\\academy\\resources\\General-Store.apk");

        //Set the app
        driver = new AndroidDriver(service.getUrl(), options);
        formPage = new FormPage(driver);
        //set timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void longPressAction(WebElement element){
        driver.executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration",2000));

    }

    public void scrollToEndAction(){

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        } while(canScrollMore);
    }


    public void swipeAction(WebElement ele, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(), //casting to remotewebelement
                "direction", direction,
                "percent", 0.75
        ));

    }


    @AfterClass
    public void tearDown(){

        //Close app and connection Appium server
        driver.quit();
        service.stop();
    }
}
