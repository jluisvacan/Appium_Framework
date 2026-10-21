package com.academy.android.tests;

import com.academy.testUtils.AndroidBaseTest;
import com.academy.pageObjects.android.CartPage;
import com.academy.pageObjects.android.ProductCataloguePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class tc_3_E2E extends AndroidBaseTest {

    @BeforeMethod(alwaysRun = true)
    public void preSetup() throws InterruptedException {
        formPage.setActivity();
    }

    @Test(dataProvider = "getData", groups = {"Smoke"})
    public void HybridAppTest(HashMap<String,String> input) throws InterruptedException {

        //login
        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));
        formPage.setCountrySelection(input.get("country"));
        ProductCataloguePage productCatalogue = formPage.submitForm();


        //product catalog
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);
        CartPage cartPage = productCatalogue.goToCartPage();


        //Cart page
        double totalSum =  cartPage.getProductsSum();
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(totalSum,displayFormattedSum);

        cartPage.acceptTermsConditions();
        cartPage.submitOrder();

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "\\src\\test\\java\\com\\academy\\testData\\eCommerce.json");
        return new Object[][] { {data.get(0)}, {data.get(1)} };
    }

}
