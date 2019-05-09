package com.stackwizards.custom.jsonqeue;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

/**
 * The type Url request.
 */
public class UrlRequest {

    private RequestQueue mQueue;

    /**
     * Instantiates a new Url request.
     *
     * @param context the context
     */
    public UrlRequest(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    /**
     * Json parse url.
     *
     * @param url            the url
     * @param requestHandler the request handler
     */
    public void jsonParseURL(final String url, final RequestHandler requestHandler) {
//        insertPoint.setVisibility(View.GONE);
//        final String[] result = {""};

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        System.out.println(response.toString());
//                        handler.fromJSonList(response.toString());
                        requestHandler.processString(response.toString());
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
                requestHandler.requestWentWrong(error.toString());
            }
        });

        mQueue.add(request);

    }

}
