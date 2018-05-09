package com.example.a13110091.testweb;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    //RegisterRequest를 가져옴
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText idText = (EditText)findViewById(R.id.idText);
        final EditText passwordText = (EditText)findViewById(R.id.passwordText);
        final EditText nameText = (EditText)findViewById(R.id.nameText);
        final EditText ageText = (EditText)findViewById(R.id.ageText);
//        final EditText sexText = (EditText)findViewById(R.id.sexText);
//        final EditText weight = (EditText)findViewById(R.id.weightText);
//        final EditText height = (EditText)findViewById(R.id.weightText);

        Button registerButton = (Button)findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString(); // userID에 저장 시킴
                String userPassword = passwordText.getText().toString();
                String userName= nameText.getText().toString();
                int userAge= Integer.parseInt(ageText.getText().toString());
//                String userSex = sexText.getText().toString();
//                int userWeight = Integer.parseInt(weight.getText().toString());
//                int userHeight = Integer.parseInt(height.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() { //Listner에서 특정 값을 가져 올수 있음

                    @Override
                    public void onResponse(String response) { //레스폰스 받아 진입
                        try{
                            JSONObject jsonResponse = new JSONObject(response); //특정 앱을 실행했을때 저장 시키는곳
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){//성공했을경우
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("회원등록을 성공했습니다.")
                                        .setPositiveButton("확인",null).create().show(); // Dialog를 실행 해줌
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class); // 로그인엑티비티로 넘어 가게 해줌
                                RegisterActivity.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("회원등록을 실패하였습니다.")
                                        .setNegativeButton("다시시도",null).create().show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(userID, userPassword, userName, userAge, /*userSex, userWeight, userHeight,*/ responseListener); //회원가입을 신청 Request
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this); //인터넷 접속방식
                queue.add(registerRequest);//실행하염 registerRequset를 실행
            }
        });
    }
}
