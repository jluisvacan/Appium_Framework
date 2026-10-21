package com.academy.testUtils;

import com.academy.pageObjects.ios.HomePage;
import com.academy.utils.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

public class IOSBaseTest extends AppiumUtils {

    public IOSDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void ConfigureAppium() throws URISyntaxException, IOException {

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\academy\\resources\\data.properties");
        props.load(fis);
        String ipAddress = props.getProperty("ipAddress");
        String port = props.getProperty("port");

        service= startAppiumServer(ipAddress, Integer.parseInt(port));

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 13 Pro");
//        options.setApp(System.getProperty("user.dir")+"\\src\test\java\com\academy\resources\\UIKitCatalog.app");
        options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\com\\academy\\resources\\TestApp 3.app");
        options.setPlatformVersion("15.5");
        options.setWdaLaunchTimeout(Duration.ofSeconds(10));

        driver = new IOSDriver(service.getUrl(), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);

    }



    @AfterClass
    public void tearDown(){

        //Close app and connection Appium server
        driver.quit();
        service.stop();
    }
}
