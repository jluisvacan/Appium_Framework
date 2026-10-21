package com.academy.pageObjects.ios;


import com.academy.utils.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends IOSActions {

    IOSDriver driver;

    public HomePage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this); //initialize page object
    }


    //driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertViews;

    public AlertViewsPage selectAlertviews(){
        alertViews.click();
        return new AlertViewsPage(driver);
    }
}
