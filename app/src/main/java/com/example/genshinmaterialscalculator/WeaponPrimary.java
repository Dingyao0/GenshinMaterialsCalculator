package com.example.genshinmaterialscalculator;

public class WeaponPrimary {
    private int wpId;
    private String wpName1;
    private String wpName2;
    private String wpName3;
    private String wpName4;
    private String wpWhere;
    private int wpImage;

    public WeaponPrimary() {}

    public WeaponPrimary(int id, String name1, String name2, String name3, String name4, String where, int image) {
        wpId = id;
        wpName1 = name1;
        wpName2 = name2;
        wpName3 = name3;
        wpName4 = name4;
        wpWhere = where;
        wpImage = image;
    }

    public WeaponPrimary(String name1, String name2, String name3, String name4, String where, int image) {
        wpName1 = name1;
        wpName2 = name2;
        wpName3 = name3;
        wpName4 = name4;
        wpWhere = where;
        wpImage = image;
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

    public int getWpImage() {
        return wpImage;
    }

    public void setWpImage(int wpImage) {
        this.wpImage = wpImage;
    }
}
