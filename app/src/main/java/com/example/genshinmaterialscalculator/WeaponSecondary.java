package com.example.genshinmaterialscalculator;

public class WeaponSecondary {
    private int wsId;
    private String wsName1;
    private String wsName2;
    private String wsName3;
    private String wsWhere;
    private int wsImage;

    public WeaponSecondary() {}

    public WeaponSecondary(String name1, String name2, String name3, String where, int image) {
        wsName1 = name1;
        wsName2 = name2;
        wsName3 = name3;
        wsWhere = where;
        wsImage = image;
    }

    public WeaponSecondary(int id, String name1, String name2, String name3, String where, int image) {
        wsId = id;
        wsName1 = name1;
        wsName2 = name2;
        wsName3 = name3;
        wsWhere = where;
        wsImage = image;
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

    public int getWsImage() {
        return wsImage;
    }

    public void setWsImage(int wsImage) {
        this.wsImage = wsImage;
    }
}
