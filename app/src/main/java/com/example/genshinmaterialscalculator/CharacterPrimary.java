package com.example.genshinmaterialscalculator;

public class CharacterPrimary {
    private int cpId;
    private String cpName1;
    private String cpName2;
    private String cpName3;
    private String cpName4;
    private String cpWhere;
    private int cpImage;

    public CharacterPrimary(int id, String name1, String name2, String name3, String name4, String where, int image) {
        cpId = id;
        cpName1 = name1;
        cpName2 = name2;
        cpName3 = name3;
        cpName4 = name4;
        cpWhere = where;
        cpImage = image;
    }

    public CharacterPrimary(String name1, String name2, String name3, String name4, String where, int image) {
        cpName1 = name1;
        cpName2 = name2;
        cpName3 = name3;
        cpName4 = name4;
        cpWhere = where;
        cpImage = image;
    }

    public CharacterPrimary() {

    }

    public int getCpId() {
        return cpId;
    }

    public void setCpId(int cpId) {
        this.cpId = cpId;
    }

    public String getCpName1() {
        return cpName1;
    }

    public void setCpName1(String cpName1) {
        this.cpName1 = cpName1;
    }

    public String getCpName2() {
        return cpName2;
    }

    public void setCpName2(String cpName2) {
        this.cpName2 = cpName2;
    }

    public String getCpName3() {
        return cpName3;
    }

    public void setCpName3(String cpName3) {
        this.cpName3 = cpName3;
    }

    public String getCpName4() {
        return cpName4;
    }

    public void setCpName4(String cpName4) {
        this.cpName4 = cpName4;
    }

    public String getCpWhere() {
        return cpWhere;
    }

    public void setCpWhere(String cpWhere) {
        this.cpWhere = cpWhere;
    }

    public int getCpImage() {
        return cpImage;
    }

    public void setCpImage(int cpImage) {
        this.cpImage = cpImage;
    }
}
