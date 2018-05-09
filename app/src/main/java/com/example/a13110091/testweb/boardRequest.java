package com.example.a13110091.testweb;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 13110091 on 2018-05-03.
 */

public class boardRequest extends StringRequest{

    final static private String URL = "http://210.119.85.215/boardwrite.php";
    private Map<String, String> parameters;

    public boardRequest(String name, String title, String content, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("title", title);
        parameters.put("content", content);
//        Log
    }

    public Map<String, String> getParams(){
        return parameters;
    }
}
