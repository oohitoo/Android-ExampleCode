package com.example.a13110091.testweb;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseMessaging.getInstance().subscribeToTopic("news"); // news 라는 토픽을 구독함
        FirebaseInstanceId.getInstance().getToken();

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final Button loginButton = (Button) findViewById(R.id.loginButton);
        final TextView registerButton = (TextView) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() { //로그인 버튼 클릭 이벤트 처리
            @Override
            public void onClick(View view) {
                final String userID = idText.getText().toString();
                final String userPassword = passwordText.getText().toString();

                Log.d("TAG : ",   userID);
                Log.d("TAG : ", userPassword);

                Response.Listener<String> responseListener = new Response.Listener<String>() { //내부클래스 인터넷에 접속하며 Response를 가져오는것
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response); //response를 저장할수 있도록 한다
                            boolean success = jsonResponse.getBoolean("success"); //값을 찾으면 true로 변환
                            Log.d("성공 : ", success+"");
                            if(success){
                                String userID = jsonResponse.getString("userID");
                                String userPassword = jsonResponse.getString("userPassword");
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class); //로그인에 성공하면 메인엑티비티로 전환
                                intent.putExtra("userID", userID); //각각의 변수값을 저장
                                intent.putExtra("userPassword", userPassword);
                                LoginActivity.this.startActivity(intent); //로그인에서 새로운 엑티비티로 전환
                            }
                            else{//실패하면 넘어옴
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this); //Dialog
                                builder.setMessage("로그인에 실패하였습니다.").setNegativeButton("다시시도", null).create().show();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener); //response로 userid userpassword 를 받아옴
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
