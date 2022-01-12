package com.example.genshinmaterialscalculator;

public class CharacterStone {
    private int csId;
    private String csName;
    private int csImage;

    public CharacterStone() {

    }

    public CharacterStone(int id, String name, int image) {
        csId = id;
        csName = name;
        csImage = image;
    }

    public CharacterStone(String name, int image) {
        csName = name;
        csImage = image;
    }

    public int getCsId() {
        return csId;
    }

    public void setCsId(int csId) {
        this.csId = csId;
    }

    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }

    public int getCsImage() {
        return csImage;
    }

    public void setCsImage(int csImage) {
        this.csImage = csImage;
    }
}