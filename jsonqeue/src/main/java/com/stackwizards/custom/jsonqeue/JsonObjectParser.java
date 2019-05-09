package com.stackwizards.custom.jsonqeue;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author zero
 * The type Json object parser.
 * A Class for parsing json string to objects
 */
public class JsonObjectParser implements RequestHandler {
    private Type collectionType;
    private  ObjectHandler handler;

    /**
     * Instantiates a new Json object parser.
     *
     * @param myType  the my custom type
     * @param handler the handler that will be called when the parsed objects are ready
     */
    public <T> JsonObjectParser(Class<T> myType, ObjectHandler handler){
        this.collectionType = TypeToken.getParameterized(List.class, myType).getType();
        this.handler = handler;
    }


    /**
     *
     * @param json
     * @param <T>
     * @return a list of objects converted from a json string
     */
    @Override
    public <T> List<T> fromJSonList(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, collectionType);
    }


    /**
     *
     * @param jsonString
     *  return a list of json parsed objects to the handler
     */
    @Override
    public void processString(String jsonString) {
           handler.getObjectList(fromJSonList(jsonString)) ;
    }

    /**
     *  Message got back if volley url request went wrong
     * @param errorMsg
     */
    @Override
    public void requestWentWrong(String errorMsg) {
        Log.i("JSON_QEUE", errorMsg);
        System.out.println(errorMsg);
    }


}
