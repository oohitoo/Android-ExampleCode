package com.example.a13110091.testweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManagementActivity extends AppCompatActivity {

    private ListView listView;
    private UserListAdapter adapter;
    private List<user> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

//        TextView userListTextView = (TextView)findViewById(R.id.userListTextView);
        Intent intent = getIntent();
//        userListTextView.setText(intent.getStringExtra("userList"));

        listView = (ListView)findViewById(R.id.listView);
        userList = new ArrayList<user>();

        //수동데이터 넣어서 확인 완료
//        userList.add(new user("홍길동","홍길동","홍길동","20","남","20","20"));
//        userList.add(new user("김갑수","김갑수","김갑수","50","남","20","20"));
//        userList.add(new user("송중기","송중기","송중기","20","남","20","20"));

        adapter = new UserListAdapter(getApplicationContext(), userList);
        listView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("userList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String userID, userPassword, userName, userAge, userSex, userWeight, userHeight;

            while (count < jsonArray.length()){
                JSONObject object = jsonArray.getJSONObject(count);
                userID = object.getString("userID");
                userPassword = object.getString("userPassword");
                userName = object.getString("userName");
                userAge = object.getString("userAge");
                userSex = object.getString("userSex");
                userWeight = object.getString("userWeight");
                userHeight = object.getString("userHeight");
                user user = new user(userID, userPassword,userName,userAge,userSex, userWeight,userHeight);
                userList.add(user);
                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
