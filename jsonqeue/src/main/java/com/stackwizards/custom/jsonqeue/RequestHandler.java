package com.stackwizards.custom.jsonqeue;

import org.json.JSONArray;

import java.util.List;

public interface RequestHandler {

    public <T> List<T> fromJSonList(String json);

    public void processString(String jsonString);

    public void requestWentWrong(String errorMsg);

}
