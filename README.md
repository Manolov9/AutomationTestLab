# DXCTestLab_TestNG

[![N|Solid](https://www.gamblingsites.org/news/wp-content/uploads/pokerstars-logo.png)](https://nodesource.com/products/nsolid)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger) ![Editor](https://img.shields.io/github/release/pandao/editor.md.svg) [![License badge](https://img.shields.io/badge/license-Apache2-green.svg)](http://www.apache.org/licenses/LICENSE-2.0) ![Maven Central](https://img.shields.io/maven-central/v/io.github.bonigarcia/selenium-jupiter.svg)

### Description
<p align="justify">
Automation testing environment that can be used for writing functional and non-functional tests. The project is based on Java, TestNG and Maven.
It is also flexible and can be quickly refactored to work with desktop or mobile devices. 
</p>
Framework advantages:

* Code for UI and API tests can be in one project.

It is also flexible and can be quickly refactored to work with desktop or mobile devices. 
</p>

### Requirements 

- [JDK](https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html) - my suggestion is to use JDK 8
- [Maven](https://maven.apache.org/download.cgi) - latest version
- [Appium](http://appium.io/) - in case to write tests for mobile devices
- [Node.js](https://nodejs.org/) - latest stable version
- [npm](https://www.npmjs.com/get-npm) - latest version
- [WebDriver](https://www.seleniumhq.org/docs/03_webdriver.jsp)
- [TestNG](https://mvnrepository.com/artifact/org.testng/testng)


*****

### Links
- [x] [JSON Formatter](http://www.tutorialspoint.com/online_json_formatter.htm) //** Online JSON Formatter **//
- [x] [JSON Editor](http://www.tutorialspoint.com/online_json_editor.htm)       //** Online JSON Editor **//
- [x] [XML Editor](http://www.tutorialspoint.com/online_xml_editor.htm)         //** Online XML Editor **//
- [x] [Ping Test](http://www.tutorialspoint.com/online_ping_test.htm)           //** Ping Test a Server for Network Connectivity **//
- [x] [Port Scanner](http://www.tutorialspoint.com/open_port_scan.htm)          //** Find out what are the open ports on your web server **//
- [x] [Host IP Lookup](http://www.tutorialspoint.com/host_ip_lookup.htm)        //** Get IP address for a given host name, domain name **//
- [x] [DNS Lookup](http://www.tutorialspoint.com/dns_lookup.htm)                //** Displays complete DNS Record for a Website **//
- [x] [Trace Route](http://www.tutorialspoint.com/online_trace_route.htm)       //** Traces the route of packets to destination host from our server **//
 


### Project Structure & Process

At this moment we don't have the full project structure because there are features that will made some changes. 


| Package | Class | Description |
| ------- | ----- | ----------- |
| com.setup | GetImageCompare  | Class that contains method for image comparing |
| com.setup | BasicSetup | Methods for starting web browser, taking screenshots and results reporting |
| com.setup | ConsoleRunner | Main class for TestNG |
| com.setup | ExtentManager | HTML report configuration |
| com.setup | TestNGListener | Additional result reporting configuration |
| com.setup | URLConnection | HTTP connection for requests and response reading configuration |
| com.setup | HttpClientUtils | Utility class that contains configuration methods for HttpClient library |
| com.setup | OkHttpClientUtils | Utility class that contains configuration methods for OkHttpClient library |
| com.test.temp || Templates that can be used for faster test creation |
| com.test | | All tests will be here |


<p align="justify">
All in one means that the code for all tests is in one project. Combination between different tests and creating test 
compilations is possible by creating a new XML files witch should contains wanted test classes and test methods. Those 
XML must be stored in <code>src/main/resource/xml_file</code>. Specific test suite can be executed by changing the 
property value in <code>src/main/resource/config.properties</code>.
</p>

Run specific test suite:
1. Create XML file that must contains specific test methods.
2. Open _config.properties_ file and set the name of the XML file without any file extensions.
3. Save the configuration file and run following command via cmd `java -jar JAVA_FRAMEWORK-1.0-jar-with-dependencies.jar`


*****

### Automation Report

<p align="justify">
Most important part for every automation is the report. By using ExtentReport and Log4j libraries we have very detailed 
report that contains only important information. All report files  generated from the different listeners are generated 
in <a href = https://github.dxc.com/ppopov6/DXCTestLab_DEV/tree/master/report>report</a> folder. Configuration methods 
are in <code>ExtentManager.class</code>.  Basically  there  is  one  general  file 
<a href = https://github.dxc.com/ppopov6/DXCTestLab_DEV/blob/master/report/TestReport.html>TestReport.html</a> that can 
be found in <i>report</i> folder. There is only one method to care of test results. That method can be found in 
<i>BasicSetup.class</i>. Every API test creates a file with JSON extension and store into it response from the server. 
This decision makes tests faster and separate reports for front-end from the back-end tests. More information about 
library can be found <a href = http://extentreports.com/docs/versions/3/java/#email-example>here</a>. Log events can be 
created by using <code>test</code> keyword.
</p>

Example:
```
//*** Create log event ***//
test.pass("Text");
``` 
</p>


#### <i>Report Functionality</i>
- [x]   REST/SOAP API request method, header and body details
        ([view](https://github.dxc.com/storage/user/52163/files/8a62a980-6386-11e9-9467-1561653f7117))
- [x]   REST/SOAP API response body, header and error messages details
        ([view](https://github.dxc.com/storage/user/52163/files/f9d99880-6388-11e9-89fd-c049052911ed))
- [x]   Stack trace and screenshots of the failed screens in case of exceptions
        ([view](https://github.dxc.com/storage/user/52163/files/4329e800-6389-11e9-8ac7-963abe443808))
- [x]   Views (
        [test,](https://github.dxc.com/storage/user/52163/files/a588e580-6395-11e9-8b44-9c2adc9afc83)
        [category,](https://github.dxc.com/storage/user/52163/files/e54fcd00-6395-11e9-8ee6-1bea201c4e90)
        [exception,](https://github.dxc.com/storage/user/52163/files/f13b8f00-6395-11e9-9876-5b1a2aa4f549)
        [dashboard](https://github.dxc.com/storage/user/52163/files/fdbfe780-6395-11e9-853e-24f7e20b975f))
- [x]   Assign test category and author
- [x]   Adding system info on the dashboard


*****


### [HttpClient](https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/index.html)
<p align="justify">
Http client is a transfer library. It resides on the client side, sends and receives Http messages. 
It provides up to date, feature-rich, and an efficient implementation which meets the recent HTTP standards.
An HTTP client is one of the easiest clients to create. It’s very handy because it 
allows for the calling, not only of the internal methods as the native protocol does, 
but also of third- party calls implemented in plugins that can be only called via HTTP.
I have chosen the Apache HttpComponents that is one of the most widely used libraries 
for executing HTTP calls. This library is available in the main Maven repository search.maven.org. 
To enable the compilation in your Maven pom.xml project just add the following code:
<code>org.apache.httpcomponentshttpclient4.5.2</code>
</p>

#### <i>Features</i>
- [x] HttpClient library implements all the available HTTP methods.
- [x] HttpClient library provides APIs to secure the requests using the Secure Socket Layer protocol.
- [x] Using HttpClient, you can establish connections using proxies.
- [x] You can authenticate connections using authentication schemes such as Basic, Digest, NTLMv1, NTLMv2, NTLM2 Session etc.
- [x] HttpClient library supports sending requests through multiple threads. It manages multiple connections established 
      from various threads using ClientConnectionPoolManager.
- [x] Using Apache HttpClient library, you can set connection timeouts.


#### <i>Development Steps</i>

<p align="justify">
The first step is to initialize the HTTP client object. This is done via the following code:
<code>HttpClient client = HttpClientBuilder.create().build();</code>
</p>

<p align="justify">
Custom headers allow for passing extra information to the server for executing a call. Some 
examples could be API keys, or hints about supported formats. A typical example is using gzip 
data compression over HTTP to reduce bandwidth usage. To do that, we can add a custom header to 
the call informing the server that our client accepts encoding: Accept-Encoding, gzip:
<code>post.addHeader("Accept-Encoding", "gzip");</code>
</p>

<p style = "line-height: 1.1">
After configuring the call with all the parameters, we can fire up the request:
<code>HttpResponse response = client.execute(post);</code>
</p>

<p style = "line-height: 1.1">
We can read the answer from the server:
</p>

```
HttpEntity entity = response.getEntity();
String responseEntity = EntityUtils.toString(entity, "UTF-8");
```

<p style = "line-height: 1.1">

More documentation about
- [x] [Request Sending](https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/fundamentals.html#d5e49)
- [x] [Response Receiving](https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/fundamentals.html#d5e74)
- [x] [Entity](https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/fundamentals.html#d5e95)
- [x] [Exception Handling](https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/fundamentals.html#d5e279)
</p>

<br>


### [OkHttpClient](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)
<p align="justify">
After latest implementations the project supports both libraries. Using OkHttp is easy. Its request/response API is 
designed with fluent builders and immutability. It supports both synchronous blocking calls and async calls with callbacks. 
OkHttp performs best when you create a single OkHttpClient instance and reuse it for all of your HTTP calls. This is 
because each client holds its own connection pool and thread pools. Reusing connections and threads reduces latency and 
saves memory. Conversely, creating a client for each request wastes resources on idle pools.
</p>

OkHttp is an HTTP client that’s efficient by default:

- [x] HTTP/2 support allows all requests to the same host to share a socket.
- [x] Connection pooling reduces request latency (if HTTP/2 isn’t available).
- [x] Transparent GZIP shrinks download sizes.
- [x] Response caching avoids the network completely for repeat requests.
- [x] Supports Android 5.0+ (API level 21+) and Java 8+.

#### <i>How To Generate JSON</i>

<p align="justify">
My recommendation is to use GSON Java JSON API from Google and JSON.org API.
<a href = https://github.com/google/gson> [GSON] </a>  is reasonably flexible and easy to use. 
<a href = https://github.com/stleary/JSON-java> [JSON.org] </a> was one of the first Java JSON APIs available out there. 
It is reasonably easy to use, but not as flexible or fast as the other JSON APIs.
</p>

<br>
<br>

[ GSON ]
```jshelllanguage
Example_1
JSONObject jsonPostData = new JSONObject();
        jsonPostData.put("deviceToken", "07304e56c452be73ad2b51a4647d0300");
        jsonPostData.put("platform", "Android");
        jsonPostData.put("platformVersion", "6.0");
        jsonPostData.put("appId", 1);
        jsonPostData.put("frameworkVersion", "1.0.0");
        jsonPostData.put("model", "LG Nexus 5X");
        jsonPostData.put("appVersion", "1.0.0");
        
        
Result:
{
  "appVersion": "1.0.0",
  "frameworkVersion": "1.0.0",
  "platformVersion": "6.0",
  "appId": 1,
  "model": "LG Nexus 5X",
  "platform": "Android",
  "deviceToken": "07304e56c452be73ad2b51a4647d0300"
}




Example_2
JSONObject uuid = new JSONObject();
        uuid.put("uuid", itemID);

        JSONArray items = new JSONArray();
        items.put(uuid);

        JSONObject jsonPostData = new JSONObject();
        jsonPostData.put("locationId", id);
        jsonPostData.put("items", items);

                
Result:        
{
  "locationId": 141,
  "items": [
          {
              "uuid": "28436bdc-374d-5d61-94a7-039f01ec9615"
          }
     ]
}




Example_3
JSONObject dataset = new JSONObject();
        dataset.put("genre_id", 1);
        dataset.put("genre_parent_id", JSONObject.NULL);
        dataset.put("genre_title", "International");
        // use the accumulate function to add to an existing value. The value
        // will now be converted to a list
        dataset.accumulate("genre_title", "Pop");
        // append to the key
        dataset.append("genre_title", "slow");
        dataset.put("genre_handle", "International");
        dataset.put("genre_color", "#CC3300");
 
        // get the json array for a string
        System.out.println(dataset.getJSONArray("genre_title"));
        // prints ["International","Pop","slow"]
 
        // increment a number by 1
        dataset.increment("genre_id");
 
        // quote a string allowing the json to be delivered within html
        System.out.println(JSONObject.quote(dataset.toString()));
        // prints
        // "{\"genre_color\":\"#CC3300\",\"genre_title\":[\"International\",\"Pop\",\"slow\"],
        // \"genre_handle\":\"International\",\"genre_parent_id\":null,\"genre_id\":2}"
    }
 
}

Result:
"{\"genre_color\":\"#CC3300\",\"genre_title\":[\"International\",\"Pop\",\"slow\"],\"genre_handle\":\"International\",\"genre_parent_id\":null,\"genre_id\":2}"
```
</p>

*****


### Selenium
Environment allows to write automated tests that drive in a way similar to how a user would. At
this moment configuration supports parallel tests execution only on <i>Chrome</i> and <i>Firefox</i> browsers.
Browser configuration for now can is into `testng.xml` file.
<br>
Useful code snippets:
<br>

```
//*** Take screenshot ***//
takeScreenshot(driver, "FileName");
```

```
//*** Compare image from data base with actual screenshot ***//
long start = System.currentTimeMillis();
int q = 0;
File file1 = new File(filePath + "/" + "Screenshots/BufferedWriter_Article.txt");

FileWriter fw = new FileWriter(file1.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);

// Image from data base
File fileA = new File(filePath + "/" + "Screenshots/Expected/Article_Expected.png");
BufferedImage image = ImageIO.read(fileA);
int width = image.getWidth(null);
int height = image.getHeight(null);
int[][] clr = new int[width][height];
    
// Actual screenshot
File fileB = new File(filePath + "/" + "Screenshots/Actual/Article_Actual.png");
BufferedImage images = ImageIO.read(fileB);
int widthe = images.getWidth(null);
int heighte = images.getHeight(null);
int[][] clre = new int[widthe][heighte];
int smw = 0;
int smh = 0;
int p = 0;

    if (width > widthe) {
        smw = widthe;
    } else {
        smw = width;
    }
    if (height > heighte) {
        smh = heighte;
    } else {
        smh = height;
    }

for (int a = 0; a < smw; a++) {
    for (int b = 0; b < smh; b++) {
    clre[a][b] = images.getRGB(a, b);
    clr[a][b] = image.getRGB(a, b);

if (clr[a][b] == clre[a][b]) {
    p = p + 1;
    bw.write("\t");
    bw.write(Integer.toString(a));
    bw.write("\t");
    bw.write(Integer.toString(b));
    bw.write("\n");
} else
    q = q + 1;
    }
}

float w, h = 0;
    if (width > widthe) {
        w = width;
    } else {
        w = widthe;
    }
    if (height > heighte) {
        h = height;
    } else {
        h = heighte;
    }
float s = (smw * smh);
float x = (100 * p) / s;

long stop = System.currentTimeMillis();

// Test will passed when percentage of sameness is more than 95%
    if (x > 95) {
        test.pass(MarkupHelper.createLabel("Compare actual screenshot with screenshot from the data base", ExtentColor.GREEN));
        test.pass("<pre>"
                    + "Success rate = " + x + "%" + "\n"
                    + "Time(ms) for visualization check = " + (stop - start) + "\n"
                    + "Number of pixels gets varied = " + q + "\n"
                    + "Number of pixels gets matched = " + p + "\n"
                    + "</pre>");
        test.pass("[ ACTUAL PAGE VIEW ]", MediaEntityBuilder.createScreenCaptureFromPath("../Screenshots/Actual/Article_Actual.png").build());
        test.pass("[ EXPECTED PAGE VIEW ]", MediaEntityBuilder.createScreenCaptureFromPath("../Screenshots/Expected/Article_Expected.png").build());
    }
        
// Test will generate warning when percentage of sameness is equal to 95%
    if (x == 95) {
        test.warning(MarkupHelper.createLabel("Compare actual screenshot with screenshot from the data base", ExtentColor.ORANGE));
        test.warning("<pre>"
                    + "Success rate = " + x + "%" + "\n"
                    + "Time(ms) for visualization check = " + (stop - start) + "\n"
                    + "Number of pixels gets varied = " + q + "\n"
                    + "Number of pixels gets matched = " + p + "\n"
                    + "</pre>");
        test.warning("[ ACTUAL PAGE VIEW ]", MediaEntityBuilder.createScreenCaptureFromPath("../Screenshots/Actual/Article_Actual.png").build());
        test.warning("[ EXPECTED PAGE VIEW ]", MediaEntityBuilder.createScreenCaptureFromPath("../Screenshots/Expected/Article_Expected.png").build());
    }
        
// Test will failed when percentage of sameness is less than 95%
    if (x < 95) {
        test.fail(MarkupHelper.createLabel("Compare actual screenshot with screenshot from the data base has failed", ExtentColor.RED));
        test.fail("<pre>"
                    + "Success rate = " + x + "%" + "\n"
                    + "Time(ms) for visualization check = " + (stop - start) + "\n"
                    + "Number of pixels gets varied = " + q + "\n"
                    + "Number of pixels gets matched = " + p + "\n"
                    + "</pre>");
        test.fail("[ ACTUAL PAGE VIEW ]", MediaEntityBuilder.createScreenCaptureFromPath("../Screenshots/Actual/Article_Actual.png").build());
        test.fail("[ EXPECTED PAGE VIEW ]", MediaEntityBuilder.createScreenCaptureFromPath("../Screenshots/Expected/Article_Expected.png").build());
```

<br>

### Build and Run from Command Line
* Build: Navigate to the project directory then execute <code>mvn clean package -Dmaven.test.skip=true</code> in case that debug 
is needed just execute <code>mvn clean package -Dmaven.test.skip=true -X</code>
* Run: Open <i>target</i> folder and execute <code>java -jar JAVA_FRAMEWORK-1.0-jar-with-dependencies.jar testng.xml</code>
 
