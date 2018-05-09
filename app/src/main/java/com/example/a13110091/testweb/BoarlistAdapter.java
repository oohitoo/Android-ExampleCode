package com.example.a13110091.testweb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 13110091 on 2018-05-02.
 */

public class BoarlistAdapter extends BaseAdapter{

    private Context context;
    private List<select> selectList;

    public BoarlistAdapter(Context context, List<select> selectList){
        this.context = context;
        this.selectList = selectList;
    }

    @Override
    public int getCount() {
        return selectList.size();
    }

    @Override
    public Object getItem(int i) {
        return selectList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { //하나의 사용자의 부분을 보여주는곳
        View v = View.inflate(context, R.layout.select, null);
        TextView name = (TextView)v.findViewById(R.id.name);
        TextView title = (TextView)v.findViewById(R.id.title);
        TextView content = (TextView)v.findViewById(R.id.content);
        TextView viewcount = (TextView)v.findViewById(R.id.view);

        name.setText(selectList.get(i).getName());
        title.setText(selectList.get(i).getTitle());
        content.setText(selectList.get(i).getContent());
        viewcount.setText(selectList.get(i).getView());

        v.setTag(selectList.get(i).getName());
        return v;
    }

}
