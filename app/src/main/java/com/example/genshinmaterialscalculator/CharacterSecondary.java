package com.example.genshinmaterialscalculator;

public class CharacterSecondary {
    private int cs_Id;
    private String cs_Name1;
    private String cs_Name2;
    private String cs_Name3;
    private String cs_Where;
    private int cs_Image;

    public CharacterSecondary(int id, String name1, String name2, String name3, String where, int image) {
        cs_Id = id;
        cs_Name1 = name1;
        cs_Name2 = name2;
        cs_Name3 = name3;
        cs_Where = where;
        cs_Image = image;
    }

    public CharacterSecondary(String name1, String name2, String name3, String where, int image) {
        cs_Name1 = name1;
        cs_Name2 = name2;
        cs_Name3 = name3;
        cs_Where = where;
        cs_Image = image;
    }

    public CharacterSecondary() {

    }

    public int getCs_Id() {
        return cs_Id;
    }

    public void setCs_Id(int cs_Id) {
        this.cs_Id = cs_Id;
    }

    public String getCs_Name1() {
        return cs_Name1;
    }

    public void setCs_Name1(String cs_Name1) {
        this.cs_Name1 = cs_Name1;
    }

    public String getCs_Name2() {
        return cs_Name2;
    }

    public void setCs_Name2(String cs_Name2) {
        this.cs_Name2 = cs_Name2;
    }

    public String getCs_Name3() {
        return cs_Name3;
    }

    public void setCs_Name3(String cs_Name3) {
        this.cs_Name3 = cs_Name3;
    }

    public String getCs_Where() {
        return cs_Where;
    }

    public void setCs_Where(String cs_Where) {
        this.cs_Where = cs_Where;
    }

    public int getCs_Image() {
        return cs_Image;
    }

    public void setCs_Image(int cs_Image) {
        this.cs_Image = cs_Image;
    }
}
