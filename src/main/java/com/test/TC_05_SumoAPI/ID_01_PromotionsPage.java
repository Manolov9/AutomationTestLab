package com.test.TC_05_SumoAPI;

import com.aventstack.extentreports.AnalysisStrategy;
import com.setup.BasicSetup;
import com.setup.ExtentManager;
import okhttp3.Request;
import org.apache.http.client.utils.URIBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.setup.ExtentManager.extent;
import static com.setup.ExtentManager.test;
import static com.setup.HttpClientUtils.responseMsg;
import static com.setup.HttpClientUtils.url;
import static com.setup.OkHttpClientUtils.*;
import static com.test.TC_02_Example_HttpClient.Fly.ID_01_AccessToken.accessToken;

public class ID_01_PromotionsPage extends BasicSetup {

    @BeforeClass
    public void startTest() throws Exception {
        extent = ExtentManager.GetExtent();
        test = extent.createTest("[ID_01] Promotions Page", "Get Promotion page configuration");
        test.assignAuthor("AUTHOR NAME");
        test.assignCategory("OkHttpClient");
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);
    }

    @Test
    public void getPromotionConfigurations(Method testMethod) throws Exception {

        String fileName = testMethod.getName() + ".json";

        // Create url address
        url = new URIBuilder()
                .setScheme("https")
                .setHost("sumo-qa.pokerstarsdev.com")
                .setPath("/sportsbook/v1/api/getPromotionConfigurations")
                .addParameter("segment", "gb")
                .build();

        request = new Request.Builder()
                .url(url.toURL())
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=ISO-8859-1")
                .addHeader("Accept", "*/*")
                .get()
                .build();

        postRequest(fileName, request);


        // Add request data to the report
        test.info("<pre>"
                + "[ REQUEST  HEADERS ]"
                + "<br />"
                + "<br />"
                + "Method:   "    + requestMethod
                + "<br />"
                + "Protocol: "    + requestURLScheme.toUpperCase()
                + "<br />"
                + "Host:     "    + requestURLHost
                + "<br />"
                + "Path:     "    + requestURLPath
                + "<br />"
                + "<br />"
                + getRequestOkClientHeaders()
                + "<br />"
                + "<br />"
                + "[ REQUEST  BODY ]"
                + "<br />"
                + "<br />"
                + "</pre>");

        Assert.assertEquals(responseMsg, "OK");
    }
}