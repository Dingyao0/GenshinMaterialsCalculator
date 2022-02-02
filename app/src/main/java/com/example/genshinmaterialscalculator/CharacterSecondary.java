package com.example.genshinmaterialscalculator;

public class CharacterSecondary {
    private int cseId;
    private String cseName1;
    private String cseName2;
    private String cseName3;
    private String cseWhere;
    private int cseImage1;
    private int cseImage2;
    private int cseImage3;

    public CharacterSecondary(int id, String name1, String name2, String name3, String where, int image1, int image2, int image3) {
        cseId = id;
        cseName1 = name1;
        cseName2 = name2;
        cseName3 = name3;
        cseWhere = where;
        cseImage1 = image1;
        cseImage2 = image2;
        cseImage3 = image3;
    }

    public CharacterSecondary(String name1, String name2, String name3, String where, int image1, int image2, int image3) {
        cseName1 = name1;
        cseName2 = name2;
        cseName3 = name3;
        cseWhere = where;
        cseImage1 = image1;
        cseImage2 = image2;
        cseImage3 = image3;
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

    public int getCseImage1() {
        return cseImage1;
    }

    public void setCseImage1(int cseImage) {
        this.cseImage1 = cseImage;
    }

    public int getCseImage2() {
        return cseImage2;
    }

    public void setCseImage2(int cseImage2) {
        this.cseImage2 = cseImage2;
    }

    public int getCseImage3() {
        return cseImage3;
    }

    public void setCseImage3(int cseImage3) {
        this.cseImage3 = cseImage3;
    }
}
