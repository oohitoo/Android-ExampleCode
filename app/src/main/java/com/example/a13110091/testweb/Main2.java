package com.example.a13110091.testweb;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class Main2 extends AppCompatActivity {

    ViewPager vp;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
//        vp = (ViewPager)findViewById(R.id.vp);
//        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
//        vp.setCurrentItem(0);

        fragment1 =  new Fragment1();
        fragment2 =  new Fragment2();
        fragment3 =  new Fragment3();

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //전체화면
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("1단계"));
        tabs.addTab(tabs.newTab().setText("2단계"));
        tabs.addTab(tabs.newTab().setText("3단계"));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("TAG","선택된탭 :"+position);
//                switch (position){
//                    case 0:
//                        setContentView(R.layout.activity_fragment1);
//                        break;
//                    case 1:
//                        setContentView(R.layout.activity_fragment2);
//                        break;
//                    case 2:
//                        setContentView(R.layout.activity_fragment3);
//                        break;
//                }

                Fragment selected = null;
                if(position == 0){
                    selected = fragment1;
//                    selected = new Fragment1();
                }else if(position == 1){
                    selected = fragment2;
//                    selected = new Fragment2();
                }else if(position == 2){
                    selected = fragment3;
//                    selected = new Fragment3();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
//    View.OnClickListener movePageListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            int tag = (int)view.getTag();
//        }
//    };
//    private class pagerAdapter extends FragmentStatePagerAdapter{
//        public pagerAdapter(android.support.v4.app.FragmentManager fm){
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position){
//                case 0:
//                    return new Fragment1();
//                case 1:
//                    return new Fragment2();
//                case 2:
//                    return new Fragment3();
//                default:
//                    return null;
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return 3;
//        }
//    }
}
