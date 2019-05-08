package com.stackwizards.custom.jsonqeue;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonObjectParser implements RequestHandler {
    private Type collectionType;

    public <T> JsonObjectParser(Class<T> myType){
        this.collectionType = TypeToken.getParameterized(List.class, myType).getType();
    }


    @Override
    public <T> List<T> fromJSonList(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, collectionType);
    }


//    @Override
//    public <T> List<T> parseJsonArray(String json, Class<T> clazz) {
//
//        Object[] array = (Object[]) java.lang.reflect.Array.newInstance(clazz, 0);
//        Gson gson = new Gson();
//        array = gson.fromJson(json, array.getClass());
//        List<T> list = new ArrayList<T>();
//        for (int i = 0; i < array.length; i++)
//            list.add(clazz.cast(array[i]));
//        return list;
//    }

}
