package com.stackwizards.custom.jsonqeue;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class UrlRequest {

    private RequestQueue mQueue;

    public UrlRequest(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public void jsonParseURL(final String url, final RequestHandler handler) {
//        insertPoint.setVisibility(View.GONE);
//        final String[] result = {""};

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Log.i("XXXXXZZ", response.toString());
//                        System.out.println(response.toString());
                        handler.fromJSonList(response.toString());
//                    handler.parseJsonArray(response.toString(), handler);
//                        result[0] = response.toString();
//                        Gson gson = new Gson();
//
//                        Question[] qs = gson.fromJson(response.toString(), Question[].class);
//                        questions.clear();
//                        for (int qw = 0; qw < qs.length; qw++) {
//                            Log.d("Counting", "counting questions: " + qs[qw].getAnswer());
//                            Log.d("Counting", "answers questions: " + qs[qw].getAnswer_options().toString());
//
//                            String ans = qs[qw].getAnswer().replace("Ans:", "").trim();
//                            for (int cn = 0; cn < qs[qw].getAnswer_options().size(); cn++) {
//                                if (ans.length() == 1 && qs[qw].getAnswer_options().get(cn).substring(0, 3).contains(ans)) {
//                                    qs[qw].setAnswer(qs[qw].getAnswer_options().get(cn));
//                                }
//                            }
//
//
//                            questions.add(qs[qw]);
//                        }
//                        Collections.shuffle(questions);

////
//                        timerUtil.resetTime();
//                        timerUtil.start();
//                        mcqHeaderDetails.setVisibility(View.VISIBLE);
//                        pointScore = 0;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);

    }

}
