package com.academy.ios.tests;

import com.academy.testUtils.IOSBaseTest;
import com.academy.pageObjects.ios.AlertViewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {

    AlertViewsPage alertViewsPage;

    @Test
    public void IOSBasicsTest(){
        //Alert View menu
        alertViewsPage = homePage.selectAlertviews();
        alertViewsPage.fillText("Hello");
        String actualMessage = alertViewsPage.getConfirmMessage();
        Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");

    }
}
