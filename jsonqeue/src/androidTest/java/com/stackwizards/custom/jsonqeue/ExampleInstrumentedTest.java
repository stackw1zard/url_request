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
public class ExampleInstrumentedTest {

    class TestParser implements RequestHandler{
        String result;

        @Override
        public <T> List<T> fromJSonList(String json) {
            System.out.println(json);
            Log.i("XXXXXX", json);


            result = json;
            return null;
        }
    }

    class ABC {
        public String strA;
        public String strB;
    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        UrlRequest request = new UrlRequest(appContext);

        TestParser parser = new TestParser();

        request.jsonParseURL("http://www.stackwizards.org/json/test5.json",parser);

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("AAAA", parser.result);

//        assertEquals("com.stackwizards.custom.jsonqeue.test", appContext.getPackageName());
    }
}
