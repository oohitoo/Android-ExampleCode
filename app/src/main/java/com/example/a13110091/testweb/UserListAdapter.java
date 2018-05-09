package com.example.a13110091.testweb;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
/**
 * Created by 13110091 on 2018-03-22.
 */

public class UserListAdapter extends BaseAdapter {

    private Context context;
    private List<user> userList;

    public UserListAdapter(Context context, List<user> userList){
        this.context = context;
        this.userList = userList;

    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { //하나의 사용자의 부분을 보여주는곳
        View v = View.inflate(context, R.layout.user, null);
        TextView userID = (TextView)v.findViewById(R.id.userID);
        TextView userPassword = (TextView)v.findViewById(R.id.userPassword);
        TextView userName = (TextView)v.findViewById(R.id.userNmae);
        TextView userAge = (TextView)v.findViewById(R.id.userAge);
        TextView userSex = (TextView)v.findViewById(R.id.userSex);
        TextView userWeight = (TextView)v.findViewById(R.id.userWeight);
        TextView userHeight = (TextView)v.findViewById(R.id.userHeight);

        userID.setText(userList.get(i).getUserID()); //특정 위치의 유저 아이디를 가져온다
        userPassword.setText(userList.get(i).getUserPassword()); //특정 위치의 유저 아이디를 가져온다
        userName.setText(userList.get(i).getUserName()); //특정 위치의 유저 아이디를 가져온다
        userAge.setText(userList.get(i).getUserAge()); //특정 위치의 유저 아이디를 가져온다
        userSex.setText(userList.get(i).getUserSex()); //특정 위치의 유저 아이디를 가져온다
        userWeight.setText(userList.get(i).getUserWeight()); //특정 위치의 유저 아이디를 가져온다
        userHeight.setText(userList.get(i).getUserHeight()); //특정 위치의 유저 아이디를 가져온다

        v.setTag(userList.get(i).getUserID());
        return v;
    }
}
