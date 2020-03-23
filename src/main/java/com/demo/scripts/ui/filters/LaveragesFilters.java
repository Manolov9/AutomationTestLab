package com.demo.scripts.ui.filters;

import com.demo.config.BasicTestConfig;
import com.demo.objects.General;
import com.demo.objects.activity.ActivityBasic;
import com.demo.objects.products.LeveragedPage;
import com.demo.objects.products.ProductsBasic;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.demo.config.ReporterConfig.startTestReport;
import static com.demo.properties.Environments.*;

public class LaveragesFilters extends BasicTestConfig {

    private static General general = PageFactory.initElements(driver, General.class);
    private static ActivityBasic activityBasic = PageFactory.initElements(driver, ActivityBasic.class);
    private static ProductsBasic productsBasic = PageFactory.initElements(driver, ProductsBasic.class);
    private static LeveragedPage leveragedPage = PageFactory.initElements(driver, LeveragedPage.class);


    private static void report() throws Exception {
        String testName = "<b>Check leverages filters</b>";
        String testCategory = "Frontend";
        String testDescription = "The purpose of this test is to verify that the user orders history is displayed properly." +
                "<br><br><br>* * *  STEPS DESCRIPTION  * * *</b><br><br>" +
                "[1] Check that the login page can be opened and displayed with correct title.<br>" +
                "[2] Check the visualization of the login form element by image comparing based on RGB color model.<br>" +
                "[3] Check login with valid credentials.";

        startTestReport(testName, testDescription, testCategory);
    }


    public static void leveragesFilters() throws Exception {
        report();
        wait = new WebDriverWait(driver, 10);

        String url = getLeveragesPage(200, -1, -1, -1);
        driver.navigate().to("https://" + HOST + url);
        System.out.println(driver.getCurrentUrl());


    }
}
