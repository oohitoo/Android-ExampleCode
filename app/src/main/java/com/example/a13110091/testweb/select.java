package com.example.a13110091.testweb;

/**
 * Created by 13110091 on 2018-05-02.
 */

public class select {

    String name;
    String title;
    String content;
    String view;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public select(String name, String title, String content, String view) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.view = view;
    }
}
