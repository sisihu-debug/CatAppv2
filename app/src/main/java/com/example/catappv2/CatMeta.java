package com.example.catappv2;

import java.util.ArrayList;

public class CatMeta {

    public CatMeta(CatMeta results){
        this.breeds = breeds;
    }

    private ArrayList<Cat> breeds;
    private String url;

    public ArrayList<Cat> getCats() {
        return breeds;
    }

    public void setBreeds(ArrayList<Cat> cats) {
        this.breeds = breeds;
    }

    public String getUrl() {
        return url;
    }


}
