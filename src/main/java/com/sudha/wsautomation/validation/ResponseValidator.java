package com.sudha.wsautomation.validation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sudha.wsautomation.model.Field;
import com.sudha.wsautomation.model.Header;
import com.sudha.wsautomation.model.MatchType;
import com.sudha.wsautomation.model.Test;
import com.sudha.wsautomation.utils.MatchTypeValidator;
import org.apache.http.HttpResponse;

public class ResponseValidator {

    public static void validateResponse(String responseJson, Test test){

        JsonParser parser = new JsonParser();
        JsonElement jsonElementOrig = parser.parse(responseJson);

        if(jsonElementOrig.isJsonObject()){

            for (Field field: test.getOutput().getFields()){
                JsonElement jsonElement = jsonElementOrig;
                String finalObject = null;
                String [] nodeList = field.getKey().split("/");
                //int i=0;

                for( String node : nodeList){
                    if(jsonElement!= null && jsonElement.isJsonObject() && jsonElement.getAsJsonObject().has(node)){
                       jsonElement = jsonElement.getAsJsonObject().get(node);
                    }
                }

                if(jsonElement.isJsonPrimitive()){
                    finalObject = jsonElement.getAsString();
                }else{
                    finalObject = com.sudha.wsautomation.utils.JsonParser.parseToJson(jsonElement.getAsJsonObject());
                }


                if(MatchTypeValidator.validate(field.getValue(), finalObject, MatchType.valueOf(field.getMatchType()))){
                    field.setResult(true);
                }
                else {
                    field.setResult(false);
                    field.setDescription("Expected = " + field.getValue() + ", Actual = " + finalObject);

                }
            }

        }else if (jsonElementOrig.isJsonArray()){
            jsonElementOrig = jsonElementOrig.getAsJsonArray().get(0);
            for (Field field: test.getOutput().getFields()){
                JsonElement jsonElement = jsonElementOrig;
                String finalObject = null;
                String [] nodeList = field.getKey().split("/");
                //int i=0;

                for( String node : nodeList){
                    if(jsonElement!= null && jsonElement.isJsonObject() && jsonElement.getAsJsonObject().has(node)){
                        jsonElement = jsonElement.getAsJsonObject().get(node);
                    }
                }

                if(jsonElement.isJsonPrimitive()){
                    finalObject = jsonElement.getAsString();
                }else{
                    finalObject = com.sudha.wsautomation.utils.JsonParser.parseToJson(jsonElement.getAsJsonObject());
                }


                if(MatchTypeValidator.validate(field.getValue(), finalObject, MatchType.valueOf(field.getMatchType()))){
                    field.setResult(true);
                }
                else {
                    field.setResult(false);
                    field.setDescription("Expected = " + field.getValue() + ", Actual = " + finalObject);

                }
            }
        }else{
            throw new RuntimeException("Invalid Json Response body: " + responseJson);
        }

    }

    public static boolean validateResponseCode(HttpResponse response, Test test){

        return test.getOutput().getResponseCode()==response.getStatusLine().getStatusCode();
    }


    public static void validateResponseHeaders(HttpResponse response, Test test){
        for (Header header: test.getOutput().getHeaders()){
            org.apache.http.Header respHeader = response.getFirstHeader(header.getHeader());

            if(MatchTypeValidator.validate(header.getValue(), respHeader.getValue(), MatchType.valueOf(header.getMatchType()))){
                header.setResult(true);
            }
            else {
                header.setResult(false);
                header.setDescription("Expected = " + header.getValue() + ", Actual = " + respHeader.getValue());

            }
        }

    }



}


