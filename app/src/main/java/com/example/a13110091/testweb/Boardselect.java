package com.example.a13110091.testweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Boardselect extends AppCompatActivity {

    private ListView listView;
    private BoarlistAdapter adapter;
    private List<select> selectList;

    Button writebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardselect);

        writebutton = (Button)findViewById(R.id.write); // 글쓰기 버튼

        writebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Boardselect.this, Write.class);
                startActivity(intent);
            }
        });

//        TextView userListTextView = (TextView)findViewById(R.id.userListTextView);
        Intent intent = getIntent();
//        userListTextView.setText(intent.getStringExtra("userList"));

        listView = (ListView)findViewById(R.id.listView);
        selectList = new ArrayList<select>();

        //수동데이터 넣어서 확인 완료
//        selectList.add(new select("홍길동","홍길동","홍길동","20"));
//        selectList.add(new select("김갑수","김갑수","김갑수","50"));
//        selectList.add(new select("송중기","송중기","송중기","20"));

        adapter = new BoarlistAdapter(getApplicationContext(), selectList);
        listView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("selectList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String name, title, content, viewcount;

            while (count < jsonArray.length()){
                JSONObject object = jsonArray.getJSONObject(count);
                name = object.getString("name");
                title= object.getString("title");
                content= object.getString("content");
                viewcount = object.getString("viewcount");
                select select = new select(name,title,content,viewcount);
                selectList.add(select);
                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
