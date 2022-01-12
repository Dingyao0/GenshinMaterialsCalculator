package com.example.genshinmaterialscalculator;

public class Weekly {
    private int Id;
    private String Name;
    private int Image;

    public Weekly() {

    }

    public Weekly (int id, String name, int image) {
        Id = id;
        Name = name;
        Image = image;
    }
    public Weekly (String name, int image) {
        Name = name;
        Image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
