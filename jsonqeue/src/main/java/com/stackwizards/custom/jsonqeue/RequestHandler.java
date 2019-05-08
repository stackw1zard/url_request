package com.stackwizards.custom.jsonqeue;

import org.json.JSONArray;

import java.util.List;

public interface RequestHandler {
//    public <T> List<T> parseJsonArray(String json, Class<T> clazz);

    public <T> List<T> fromJSonList(String json);

}
