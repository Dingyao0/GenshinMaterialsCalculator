package com.example.genshinmaterialscalculator;

public class WeaponSecondary {
    private int wsId;
    private String wsName1;
    private String wsName2;
    private String wsName3;
    private String wsWhere;
    private int wsImage1;
    private int wsImage2;
    private int wsImage3;


    public WeaponSecondary() {}

    public WeaponSecondary(String name1, String name2, String name3, String where, int image1, int image2, int image3) {
        wsName1 = name1;
        wsName2 = name2;
        wsName3 = name3;
        wsWhere = where;
        wsImage1 = image1;
        wsImage2 = image2;
        wsImage3 = image3;
    }

    public WeaponSecondary(int id, String name1, String name2, String name3, String where, int image1, int image2, int image3) {
        wsId = id;
        wsName1 = name1;
        wsName2 = name2;
        wsName3 = name3;
        wsWhere = where;
        wsImage1 = image1;
        wsImage2 = image2;
        wsImage3 = image3;
    }

    public int getWsId() {
        return wsId;
    }

    public void setWsId(int wsId) {
        this.wsId = wsId;
    }

    public String getWsName1() {
        return wsName1;
    }

    public void setWsName1(String wsName1) {
        this.wsName1 = wsName1;
    }

    public String getWsName2() {
        return wsName2;
    }

    public void setWsName2(String wsName2) {
        this.wsName2 = wsName2;
    }

    public String getWsName3() {
        return wsName3;
    }

    public void setWsName3(String wsName3) {
        this.wsName3 = wsName3;
    }

    public String getWsWhere() {
        return wsWhere;
    }

    public void setWsWhere(String wsWhere) {
        this.wsWhere = wsWhere;
    }

    public int getWsImage1() {
        return wsImage1;
    }

    public void setWsImage1(int wsImage1) {
        this.wsImage1 = wsImage1;
    }

    public int getWsImage2() {
        return wsImage2;
    }

    public void setWsImage2(int wsImage2) {
        this.wsImage2 = wsImage2;
    }

    public int getWsImage3() {
        return wsImage3;
    }

    public void setWsImage3(int wsImage3) {
        this.wsImage3 = wsImage3;
    }
}
