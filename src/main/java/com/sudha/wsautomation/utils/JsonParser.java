package com.sudha.wsautomation.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sudha.wsautomation.model.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> T parseJsonString(String input, Class<T> classType){
        T clazz = gson.fromJson(input, classType);
        return clazz;
    }

    public static  <T> T parseJsonFile(String filePath, Class<T> classType) throws IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        return parseJsonString(fileContent, classType);

    }

    public static Test parseJsonFile(String filePath) throws IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        Test clazz = gson.fromJson(fileContent, Test.class);
        return clazz;
    }

    public static String parseToJson(JsonObject jsonObject){
        return gson.toJson(jsonObject);
    }

}
