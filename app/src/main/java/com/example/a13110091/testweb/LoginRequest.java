package com.example.a13110091.testweb;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 13110091 on 2018-03-19.
 */

public class LoginRequest extends StringRequest {
    final static private String URL = "http://210.119.85.215/Login1.php"; //
    private Map<String, String> parameters;

    public LoginRequest(String userID, String userPassword, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();//로그인에 필요한건 아이디와 패스워드라 두개만 있으면된다
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword); //결과값을 LoginActivity로 전달
    }

    public Map<String, String> getParams(){
        return parameters;
    }
}