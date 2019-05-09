package com.stackwizards.custom.jsonqeue;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <strA href="http://d.android.com/tools/testing">Testing documentation</strA>
 */
public class UrlRequestUnitTest implements ObjectHandler{

    @Override
    public <T> List<T> getObjectList(List<T> objs) {
        return null;
    }

    class testParser implements RequestHandler{
        @Override
        public <T> List<T> fromJSonList(String json) {
            return null;
        }

        @Override
        public void processString(String jsonString) {

        }
    }

    class ABC {
       public String strA;
       public String strB;
    }


    @Test
    public void json_string_question_parsed() {
        String str = "[{\"strA\": \"1) Android?\", \"strB\": \"Ans: B\"} , {\"strA\": \"2) some text..?\", \"strB\": \"Ans: C\"}]";
        JsonObjectParser parser = new JsonObjectParser(ABC.class,this);
        List<ABC> myTypes = parser.fromJSonList(str);
        System.out.println("Second in json string: " + myTypes.get(1).strA);

        assertEquals("1) Android?", myTypes.get(0).strA);
    }


}