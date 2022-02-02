package com.example.genshinmaterialscalculator;

public class CharacterPrimary {
    private int cpId;
    private String cpName1;
    private String cpName2;
    private String cpName3;
    private String cpWhere;
    private int cpImage1;
    private int cpImage2;
    private int cpImage3;

    public CharacterPrimary(int id, String name1, String name2, String name3, String where, int image1, int image2, int image3) {
        cpId = id;
        cpName1 = name1;
        cpName2 = name2;
        cpName3 = name3;
        cpWhere = where;
        cpImage1 = image1;
        cpImage2 = image2;
        cpImage3 = image3;
    }

    public CharacterPrimary(String name1, String name2, String name3, String where, int image1, int image2, int image3) {
        cpName1 = name1;
        cpName2 = name2;
        cpName3 = name3;
        cpWhere = where;
        cpImage1 = image1;
        cpImage2 = image2;
        cpImage3 = image3;
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

    public String getCpWhere() {
        return cpWhere;
    }

    public void setCpWhere(String cpWhere) {
        this.cpWhere = cpWhere;
    }

    public int getCpImage1() {
        return cpImage1;
    }

    public void setCpImage1(int cpImage1) {
        this.cpImage1 = cpImage1;
    }

    public int getCpImage2() {
        return cpImage2;
    }

    public void setCpImage2(int cpImage2) {
        this.cpImage2 = cpImage2;
    }

    public int getCpImage3() {
        return cpImage3;
    }

    public void setCpImage3(int cpImage3) {
        this.cpImage3 = cpImage3;
    }
}

