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

public class Write extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        final EditText writename = (EditText)findViewById(R.id.writename);
        final EditText writetitle = (EditText)findViewById(R.id.writetitle);
        final EditText writecontent = (EditText)findViewById(R.id.writecontent);

        Button writebutton = (Button)findViewById(R.id.writebutton);

        writebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = writename.getText().toString();
                String title = writetitle.getText().toString();
                String content = writecontent.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(Write.this);
                                builder.setMessage("등록이 완료 되었습니다.")
                                        .setPositiveButton("확인", null)
                                        .create().show();

                                Intent intent = new Intent(Write.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Write.this);
                                builder.setMessage("등록이 실패 되었습니다.")
                                        .setPositiveButton("다시 시도", null)
                                        .create().show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                boardRequest boardRequest = new boardRequest(name, title, content,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Write.this); //인터넷 접속방식
                queue.add(boardRequest);//실행하염 registerRequset를 실행
            }
        });
    }
}
