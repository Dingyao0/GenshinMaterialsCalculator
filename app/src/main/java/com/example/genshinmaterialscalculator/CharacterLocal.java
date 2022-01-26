package com.example.genshinmaterialscalculator;

public class CharacterLocal {
    private int clId;
    private String clName;
    private String clRegion;

    public CharacterLocal() {}

    public CharacterLocal(int id, String name, String region) {
        clId = id;
        clName = name;
        clRegion = region;
    }

    public CharacterLocal(String name, String region) {
        clName = name;
        clRegion = region;
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
}
