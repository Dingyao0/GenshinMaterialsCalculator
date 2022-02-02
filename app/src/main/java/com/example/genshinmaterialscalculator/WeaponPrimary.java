package com.example.genshinmaterialscalculator;

public class WeaponPrimary {
    private int wpId;
    private String wpName1;
    private String wpName2;
    private String wpName3;
    private String wpName4;
    private String wpWhere;
    private int wpImage1;
    private int wpImage2;
    private int wpImage3;
    private int wpImage4;

    public WeaponPrimary() {}

    public WeaponPrimary(int id, String name1, String name2, String name3, String name4, String where, int image1, int image2, int image3, int image4) {
        wpId = id;
        wpName1 = name1;
        wpName2 = name2;
        wpName3 = name3;
        wpName4 = name4;
        wpWhere = where;
        wpImage1 = image1;
        wpImage2 = image2;
        wpImage3 = image3;
        wpImage4 = image4;
    }

    public WeaponPrimary(String name1, String name2, String name3, String name4, String where, int image1, int image2, int image3, int image4) {
        wpName1 = name1;
        wpName2 = name2;
        wpName3 = name3;
        wpName4 = name4;
        wpWhere = where;
        wpImage1 = image1;
        wpImage2 = image2;
        wpImage3 = image3;
        wpImage4 = image4;
    }

    public int getWpId() {
        return wpId;
    }

    public void setWpId(int wpId) {
        this.wpId = wpId;
    }

    public String getWpName1() {
        return wpName1;
    }

    public void setWpName1(String wpName1) {
        this.wpName1 = wpName1;
    }

    public String getWpName2() {
        return wpName2;
    }

    public void setWpName2(String wpName2) {
        this.wpName2 = wpName2;
    }

    public String getWpName3() {
        return wpName3;
    }

    public void setWpName3(String wpName3) {
        this.wpName3 = wpName3;
    }

    public String getWpName4() {
        return wpName4;
    }

    public void setWpName4(String wpName4) {
        this.wpName4 = wpName4;
    }

    public String getWpWhere() {
        return wpWhere;
    }

    public void setWpWhere(String wpWhere) {
        this.wpWhere = wpWhere;
    }

    public int getWpImage1() {
        return wpImage1;
    }

    public void setWpImage1(int wpImage1) {
        this.wpImage1 = wpImage1;
    }

    public int getWpImage2() {
        return wpImage2;
    }

    public void setWpImage2(int wpImage2) {
        this.wpImage2 = wpImage2;
    }

    public int getWpImage3() {
        return wpImage3;
    }

    public void setWpImage3(int wpImage3) {
        this.wpImage3 = wpImage3;
    }

    public int getWpImage4() {
        return wpImage4;
    }

    public void setWpImage4(int wpImage4) {
        this.wpImage4 = wpImage4;
    }
}
