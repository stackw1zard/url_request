package com.stackwizards.custom.jsonrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stackwizards.custom.jsonqeue.JsonObjectParser;
import com.stackwizards.custom.jsonqeue.UrlRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        UrlRequest request = new UrlRequest(getApplicationContext());
//          Type collectionType = TypeToken.getParameterized(List.class, myType).getType();

//        JsonObjectParser parser = new JsonObjectParser(Question.class);

//        parser.fromJSonList("",Question.class);

//        List<Question> myTypes = parser.fromJSonList(str, Question.class);

//        Log.i("PARSER", myTypes.get(0).getQuestion_text() );

//        request.jsonParseURL("http://www.stackwizards.org/json/test5.json", parser);

    }
}
