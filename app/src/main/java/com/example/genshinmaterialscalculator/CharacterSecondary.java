package com.example.genshinmaterialscalculator;

public class CharacterSecondary {
    private int cseId;
    private String cseName1;
    private String cseName2;
    private String cseName3;
    private String cseWhere;
    private int cseImage;

    public CharacterSecondary(int id, String name1, String name2, String name3, String where, int image) {
        cseId = id;
        cseName1 = name1;
        cseName2 = name2;
        cseName3 = name3;
        cseWhere = where;
        cseImage = image;
    }

    public CharacterSecondary(String name1, String name2, String name3, String where, int image) {
        cseName1 = name1;
        cseName2 = name2;
        cseName3 = name3;
        cseWhere = where;
        cseImage = image;
    }

    public CharacterSecondary() {

    }

    public int getCseId() {
        return cseId;
    }

    public void setCseId(int cseId) {
        this.cseId = cseId;
    }

    public String getCseName1() {
        return cseName1;
    }

    public void setCseName1(String cseName1) {
        this.cseName1 = cseName1;
    }

    public String getCseName2() {
        return cseName2;
    }

    public void setCseName2(String cseName2) {
        this.cseName2 = cseName2;
    }

    public String getCseName3() {
        return cseName3;
    }

    public void setCseName3(String cseName3) {
        this.cseName3 = cseName3;
    }

    public String getCseWhere() {
        return cseWhere;
    }

    public void setCseWhere(String cseWhere) {
        this.cseWhere = cseWhere;
    }

    public int getCseImage() {
        return cseImage;
    }

    public void setCseImage(int cseImage) {
        this.cseImage = cseImage;
    }
}
