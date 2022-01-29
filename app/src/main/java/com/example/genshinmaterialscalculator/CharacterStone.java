package com.example.genshinmaterialscalculator;

public class CharacterStone {
    private int cstId;
    private String cstName;
    private int cstImage;

    public CharacterStone() {

    }

    public CharacterStone(int id, String name, int image) {
        cstId = id;
        cstName = name;
        cstImage = image;
    }

    public CharacterStone(String name, int image) {
        cstName = name;
        cstImage = image;
    }

    public int getCstId() {
        return cstId;
    }

    public void setCstId(int cstId) {
        this.cstId = cstId;
    }

    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    public int getCstImage() {
        return cstImage;
    }

    public void setCstImage(int cstImage) {
        this.cstImage = cstImage;
    }
}