package com.test.temp;

import com.aventstack.extentreports.AnalysisStrategy;
import com.setup.BasicSetup;
import com.setup.ExtentManager;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.URI;

import static com.setup.ExtentManager.extent;
import static com.setup.ExtentManager.test;
import static com.setup.HttpClientUtils.*;

public class HttpClient_POST extends BasicSetup {

    @BeforeClass
    public void startTest() throws Exception {
        extent = ExtentManager.GetExtent();
        test = extent.createTest("[REST/SOAP] TEST NAME", "DESCRIPTION");
        test.assignAuthor("YOUR NAME");
        test.assignCategory("HttpClient");
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);
    }

    @Test
    public void get(Method testMethod) throws Exception {
        url = new URIBuilder()
                .setScheme("http/https")
                .setHost("api.flypaythis.com")
                .setPath("/v2/auth/login")
                .build();

        JSONObject jsonPostData = new JSONObject();
        jsonPostData.put("key", "value");
        jsonPostData.put("key", "value");

        String requestData = jsonPostData.toString(4);
        String fileName = testMethod.getName() + ".json";

        httpPost(fileName, url, jsonPostData);

        test.info("<pre>"
                + "[ REQUEST  HEADERS ]"
                + "<br />"
                + "<br />"
                + "Method:  "  + requestMethod   +   "  "   + requestProtocol
                + "<br />"
                + "Scheme:  "    + requestScheme.toUpperCase()
                + "<br />"
                + "Host:    "      + requestHost
                + "<br />"
                + "Path:    "      + requestPath
                + "<br />"
                + "\n"
                + getPostRequestHeaders().replace(", ", "\n")
                + "<br />"
                + "<br />"
                + "<br />"
                + "[ REQUEST  BODY ]"
                + "<br />"
                + "<br />"
                + requestData.replace("    ", "&nbsp;&nbsp;")
                + "<br />"
                + "<br />"
                + "</pre>");
    }
}