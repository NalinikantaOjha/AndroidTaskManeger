package com.example.recycleview2revision;

public class Model {
    public static final int ViewHolde1r=0;
    private String Name;
    private int time;
    int viewType;


    public Model(int viewType,String name, int time) {
        Name = name;
        this.time = time;
        this.viewType=viewType;

    }

    public String getName() {
        return Name;
    }

    public int getTime() {
        return time;
    }
    public int getViewType(){
        return viewType;
    }
}
