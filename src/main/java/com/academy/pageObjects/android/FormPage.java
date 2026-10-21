package com.academy.pageObjects.android;

import com.academy.utils.AndroidActions;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import static io.appium.java_client.CommandExecutionHelper.executeScript;

public class FormPage extends AndroidActions {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this); //initialize page object
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;

    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
    private WebElement maleOption;

    @AndroidFindBy(id="android:id/text1")
    private WebElement countrySelection;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;


    public void setNameField(String name){
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender){
        if (gender.contains("female")){
            femaleOption.click();
        } else {
            maleOption.click();
        }
    }

    public void setCountrySelection(String countryName){
        countrySelection.click();
        scrollToText("Australia");
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();

    }


    public ProductCataloguePage submitForm() throws InterruptedException {
        shopButton.click();
        Thread.sleep(3000);
        return new ProductCataloguePage(driver);
    }

    public void setActivity() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"
        ));
        Thread.sleep(2000);
    }

}
