package com.example.genshinmaterialscalculator;

public class CharacterLocal {
    private int clId;
    private String clName;
    private String clRegion;
    private int clImage;

    public CharacterLocal() {}

    public CharacterLocal(int id, String name, String region, int image) {
        clId = id;
        clName = name;
        clRegion = region;
        clImage = image;
    }

    public CharacterLocal(String name, String region, int image) {
        clName = name;
        clRegion = region;
        clImage = image;
    }

    public int getClId() {
        return clId;
    }

    public void setClId(int clId) {
        this.clId = clId;
    }

    public String getClName() {
        return clName;
    }

    public void setClName(String clName) {
        this.clName = clName;
    }

    public String getClRegion() {
        return clRegion;
    }

    public void setClRegion(String clRegion) {
        this.clRegion = clRegion;
    }

    public int getClImage() {
        return clImage;
    }

    public void setClImage(int clImage) {
        this.clImage = clImage;
    }
}
