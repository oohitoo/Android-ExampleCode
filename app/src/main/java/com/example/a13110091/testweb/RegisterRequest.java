package com.example.a13110091.testweb;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 13110091 on 2018-03-19.
 */

public class RegisterRequest extends StringRequest {
    final static private String URL = "http://210.119.85.215/Register.php"; //나의 web서버 주소
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userName, int userAge, /*String userSex, int userWeight, int userHeight,*/ Response.Listener<String> listener){
        super(Method.POST, URL, listener, null); //post방식으로 전송

        parameters = new HashMap<>(); //HashMap을 이용 하여 초기화
        parameters.put("userID", userID); //POST로 가져온 userID를 가져옴
        parameters.put("userPassword", userPassword); //POST로 가져온 userpassword를 가져옴
        parameters.put("userName", userName); //POST로 가져온 userName를 가져옴
        parameters.put("userAge", userAge+""); //POST로 가져온 userAge를 가져옴 문자열로 받아야 함
//        parameters.put("userSex", userSex);
//        parameters.put("userWeight", userWeight+"");
//        parameters.put("userHeight", userHeight+"");
    }

    public Map<String, String> getParams(){
        return parameters; //리턴시킴
    }
}
