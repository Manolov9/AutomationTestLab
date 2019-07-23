package com.test.uat.TC_01_Bet;

import com.aventstack.extentreports.AnalysisStrategy;
import com.setup.BasicSetup;
import com.setup.ExtentManager;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

import static com.constants.Accounts.*;
import static com.setup.ExtentManager.extent;
import static com.setup.ExtentManager.test;
import static com.setup.HttpClientUtils.*;

public class ID_01_LogIn extends BasicSetup {

    public static String externalToken;
    public static String signature;
    public static String webId;
    public static int lsrc;
    public static int site;

    @BeforeClass
    public void startTest() throws Exception {
        extent = ExtentManager.GetExtent();
        test = extent.createTest("[ID_01] Log in", "");
        test.assignAuthor("Pavel Popov");
        test.assignCategory("POST");
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);
    }

    @Test
    public void loginRam(Method testMethod) throws Exception {
        url = new URIBuilder()
                .setScheme("https")
                .setHost("ram.uat.pyr")
                .setPath("/ram/login")
                .build();

        JSONObject jsonPostData = new JSONObject();
        jsonPostData.put("username", uat1_username);
        jsonPostData.put("password", uat1_password);
        jsonPostData.put("signature", uat1_signature);
        jsonPostData.put("devIx", uat1_devIx);

        String requestData = jsonPostData.toString(4);
        String fileName = testMethod.getName() + ".json";

        httpPost(fileName, url, jsonPostData).addHeader("Origin", "https://walletapi.uat.pyr");

        test.info("<pre>"
                + "[ REQUEST  HEADERS ]"
                + "<br />"
                + "<br />"
                + "Method:  " + requestMethod + "  " + requestProtocol
                + "<br />"
                + "Scheme:  " + requestScheme.toUpperCase()
                + "<br />"
                + "Host:    " + requestHost
                + "<br />"
                + "Path:    " + requestPath
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


        List<org.apache.http.cookie.Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("SBTK")) {
                    externalToken = cookie.getValue();
                }
                 else if (cookie.getName().equalsIgnoreCase("SBSG")) {
                    signature = cookie.getValue();
                }
                 else if (cookie.getName().equalsIgnoreCase("WBID")) {
                     webId = cookie.getValue();
                 }
                 else if (cookie.getName().equalsIgnoreCase("LSRC")) {
                     lsrc = Integer.parseInt(cookie.getValue());
                }
                 else if (cookie.getName().equalsIgnoreCase("SITE")) {
                     site = Integer.parseInt(cookie.getValue());
                }
        }

        /*** Add key values that we take from the response. ***/
        test.pass("<pre>"
                + "[ KEYS ]"
                + "<br />"
                + "\n externalToken = " + externalToken
                + "\n signature = " + signature
                + "\n webId = " + webId
                + "\n lsrc = " + lsrc
                + "\n site = " + site
                + "<br />"
                + "<br />"
                + "</pre>");
    }
}