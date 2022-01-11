package com.example.genshinmaterialscalculator;

/**
 * Created by Aws on 28/01/2018.
 */

public class Weapons {

    private String Title;
    private String Description;
    private int Thumbnail;
    private String Code;


    public Weapons() {
    }

    public Weapons(String title, String code, String description, int thumbnail) {
        Title = title;
        Code = code;
        Description = description;
        Thumbnail = thumbnail;
    }


    public String getTitle() {
        return Title;
    }

    public String getCode() {
        return Code;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public void setTitle(String title) {
        Title = title;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}