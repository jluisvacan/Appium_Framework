package com.academy.pageObjects.android;

import com.academy.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CartPage extends AndroidActions {

    AndroidDriver driver;
    Double displayFormattedPrice;
    Double totalPrice;

    public CartPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement terms;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkbox;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceed;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement acceptButton;

    public List<WebElement> getProductPrices(){
        return productList;
    }

    public double getProductsSum(){
        int count = productList.size();
        totalPrice = 0.0;
        for (int i =0; i < count; i++){
            String amountString = productList.get(i).getText();
            Double price = getFormattedAmount(amountString);
            totalPrice = totalPrice + price;
        }
        return totalPrice;

    }

    public Double getTotalAmountDisplayed(){
        return getFormattedAmount(totalAmount.getText());
    }


    public void acceptTermsConditions() throws InterruptedException {
        longPressAction(terms);
        Thread.sleep(2000);
        acceptButton.click();
    }


    public void submitOrder() throws InterruptedException {
        checkbox.click();
        proceed.click();
    }




}
