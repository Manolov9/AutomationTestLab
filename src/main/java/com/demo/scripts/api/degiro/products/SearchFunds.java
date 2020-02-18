package com.demo.scripts.api.degiro.products;

import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import static com.demo.config.ReporterConfig.startTestReport;
import static com.demo.config.ReporterConfig.test;
import static com.demo.properties.Environments.*;
import static com.demo.properties.TestData.intAccount;
import static com.demo.properties.TestData.sessionID;
import static com.demo.utilities.FileUtility.createLogFile;
import static com.demo.utilities.FileUtility.getFormattedJson;
import static com.demo.utilities.web_services.HttpClientConfig.*;
import static com.demo.utilities.web_services.HttpClientUtils.get;
import static com.demo.utilities.web_services.HttpClientUtils.getClosableHttpClientResponseDetails;

public class SearchFunds {


    private static String scheme;
    private static String host;
    private static String path;


    static final Logger LOG = LogManager.getLogger(SearchFunds.class);

    private static void report() throws Exception {
        String testName        = "<b>[GET] Investment SearchFunds List</b>";
        String testCategory    = "API";
        String testDescription = "The purpose of this test is to verify that the login functionality is working as expected"              +
                "<br><br><b>*****   D E S C R I P T I O N   *****</b><br><br>"                                                       +
                "[1] Check that the login page can be opened and displayed with correct title.<br>"                      +
                "[2] Check the visualization of the login form element by image comparing based on RGB color model.<br>" +
                "[3] Check login with valid credentials.";

        startTestReport(testName, testDescription, testCategory);
    }




    public static void getFunds(String fileName, int limit, boolean requireTotal) throws Exception {
        report();

        scheme = "https";
        host   = INT_TEST_HOST;
        path   = INT_TEST_FUNDS;

        url = new URIBuilder()
                .setScheme(scheme)
                .setHost(host)
                .setPath(path)
                .addParameter("intAccount", String.valueOf(intAccount))
                .addParameter("sessionId", sessionID)
                .addParameter("offset", "0")
                .addParameter("limit", String.valueOf(limit))
                .addParameter("sortColumns", "name")
                .addParameter("sortTypes", "asc")
                .addParameter("requireTotal", String.valueOf(requireTotal))
                .build();


        response = closeableHttpClient().execute(get(url));
        getClosableHttpClientResponseDetails(response);


        test.info("<pre>"
                + "<br/>"
                + "<center><b>* * * * * * * *    R E Q U E S T    * * * * * * * *</b></center>"
                + "<br />"
                + "<br />"
                + "Method:   " + requestMethod
                + "<br />"
                + "Host:     " + scheme + "://" + host
                + "<br />"
                + "Path:     " + path + "/" + url.getQuery()
                + "<br/>"
                + "<br/>"
                + "<br/>"
                + "</pre>");

        createLogFile(fileName, getFormattedJson(responseBody));

        Assert.assertTrue(responseCode > 199 && responseCode < 300);
    }

}