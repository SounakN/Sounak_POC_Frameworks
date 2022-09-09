package com.Automation.utilities;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;

public class ApiActionMethods{

 /*   public static Object DeserializeJSONtoClass(String filenameOfJSON, Object a) throws IOException {
        BaseReaderModelJSON readerModel = new BaseReaderModelJSON();
        Object deserializedjson =null;
        readerModel.filename=filenameOfJSON;
        Reader json =readerModel.ReadFile();
        Gson gson = new Gson();
        deserializedjson = gson.fromJson(json, (Type) a);
        return deserializedjson;
    }*/

    public static Object DeserializeJSONBODYtoClass(String JSONBody, Object a) throws IOException {
        Object deserializedjson =null;
        Gson gson = new Gson();
        deserializedjson = gson.fromJson(JSONBody, (Type) a);
        return deserializedjson;
    }
    public static String SerializeClasstoJSON(Object a)
    {
        String jsonString;
        Gson gson = new Gson();
        jsonString = gson.toJson(a);
        return jsonString;
    }

    public static String getDataFromJson(String path) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            Object obj = parser.parse(new FileReader(path));

            jsonObject = (JSONObject) obj;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
        }
        return jsonObject.toJSONString();
    }

    public static HashMap getTheValueAsMap(String path) {
        HashMap<String, String> map = new HashMap<String, String>();
        String value = getDataFromJson(path);
        String[] keyValuePairs = value.split(",");              //split the string to creat key-value pairs
        for (String pair : keyValuePairs)                        //iterate over the pairs
        {
            String[] entry = pair.split(":");                   //split the pairs to get key and value
            map.put(entry[0].replace("{","").replace("\"","").replace("\\","").trim(), entry[1].replace("\"","").replace("\\","").replace("}","").trim());
        }
        return map;

    }

    public RequestSpecification addEndPoint(RequestSpecification requestSpecification, String url) {
        requestSpecification.basePath(url);
        return requestSpecification;
    }

    public Response getRequest(RequestSpecification requestspecification)
    {
        Response response = null;
        response = requestspecification.get();
        //Checking whether response is not NULL
        Assert.assertNotNull(response);
        return response;
    }

    public Response postRequest(RequestSpecification requestspecification, String JSONBody)
    {
        Response response = null;
        requestspecification.contentType(ContentType.JSON);
        requestspecification.body(JSONBody);
        response = requestspecification.post();
                //Checking whether response is not NULL
        Assert.assertNotNull(response);
        return response;
    }

}
