package com.setup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.setup.HttpClientUtils.objectResponse;
import static com.setup.HttpClientUtils.responseMsg;


public class OkHttpClientUtils extends BasicSetup {

    public static String responseOkClientHeaders;
    public static String requestOkClientHeaders;
    public static int okHttpResponseCode;
    public static String responseProtocol;
    public static String requestURL;
    public static String requestURLHost;
    public static String requestURLPath;
    public static String requestURLScheme;
    public static String requestMethod;
    public static Request request;

    public static OkHttpClient okHttpClient = new OkHttpClient();
    public static Response okServerResponse;

    public static File createJsonFile(Response okServerResponse, String fileName) throws Exception {
        File file = new File(filePath + "/" + "report/JSON/" + fileName);
        FileWriter fw = new FileWriter(file);
        fw.write(objectResponse.toString());
        fw.flush();
        fw.close();

        return file;
    }

    public static OkHttpClient postRequest(String fileName, Request request) throws Exception {

        okServerResponse = okHttpClient.newCall(request).execute();

        requestMethod = request.method();
        requestURLPath = request.url().uri().getPath();
        requestURLHost = request.url().uri().getHost();
        requestURLScheme = request.url().uri().getScheme();

        // Get request headers
        //getRequestOkClientHeaders();

        // Get response headers
        getResponseOkClientHeaders();

        // Get response code
        getOkHttpResponseCode(okServerResponse);

        // Parse the response to json
        try {
            String responseBody = okServerResponse.body().string();
            objectResponse = new JSONObject(responseBody);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            response = gson.toJson(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }

        responseProtocol = okServerResponse.protocol().toString().toUpperCase();
        responseMsg = okServerResponse.message();

        createJsonFile(okServerResponse, fileName);

        return okHttpClient;
    }

    public static String requestBodyToString(RequestBody requestBody) throws IOException, IOException {
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readUtf8();
    }

    public static int getOkHttpResponseCode(Response okServerResponse) throws Exception {
        try {
            okHttpResponseCode = okServerResponse.code();
            } catch (Exception e) {
            e.printStackTrace();
        }
            return okHttpResponseCode;
    }


    public static String getResponseOkClientHeaders() throws Exception {
        try {
            responseOkClientHeaders = okServerResponse.headers().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseOkClientHeaders;
    }

    public static String getRequestOkClientHeaders() throws Exception {
        try {
            requestOkClientHeaders = request.headers().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestOkClientHeaders;
    }
}