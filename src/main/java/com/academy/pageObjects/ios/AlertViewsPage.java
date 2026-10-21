package com.academy.pageObjects.ios;


import com.academy.utils.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViewsPage extends IOSActions {

    IOSDriver driver;

    public AlertViewsPage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this); //initialize page object
    }


    //driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name=='Text Entry'`]")).click();
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name=='Text Entry'`]")
    private WebElement textEntryMenu;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm']")
    private WebElement confirmMenuItem;

    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
    private WebElement confirmMessage;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement submit;



    public void fillText(String name){

        textEntryMenu.click();
        textBox.sendKeys(name);
        acceptButton.click();
    }

    public String getConfirmMessage(){
        confirmMenuItem.click();
        return confirmMenuItem.getText();
    }



}
