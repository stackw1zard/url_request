package com.stackwizards.custom.jsonqeue;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest implements ObjectHandler {

    @Override
    public <T> List<T> getObjectList(List<T> objs) {
        List<Question> myTypes = (List<Question>) objs;
        Log.i("ABC", myTypes.get(0).getQuestion_text());
        return null;
    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        UrlRequest request = new UrlRequest(appContext);

        JsonObjectParser parser = new JsonObjectParser(Question.class,this);

        request.jsonParseURL("http://www.stackwizards.org/json/test5.json",parser);

    }
}
