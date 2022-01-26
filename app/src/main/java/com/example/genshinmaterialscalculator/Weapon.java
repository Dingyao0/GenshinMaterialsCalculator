package com.example.genshinmaterialscalculator;

/**
 * Created by Aws on 28/01/2018.
 */

public class Weapon {

    private int ID;
    private String Name;
    private String Type;
    private String AttackValue;
    private int SubStat;
    private String SubStatValue;
    private int Image;
    private String Code;
    private String Rarity;
    private String SDescription;
    private String IDescription;
    private int FirstMatID;
    private int SecondMatID;
    private int ThirdMatID;

    public Weapon() {
    }

    public Weapon(int id, String name, String code, String type, String attackValue, int subStat, String subStatValue, String rarity, String sDescription, String iDescription, int firstMatID, int secondMatID, int thirdMatID, int image) {
        ID=id;
        Name = name;
        Code = code;
        Type = type;
        AttackValue = attackValue;
        SubStat = subStat;
        SubStatValue = subStatValue;
        Rarity = rarity;
        SDescription = sDescription;
        IDescription = iDescription;
        FirstMatID = firstMatID;
        SecondMatID = secondMatID;
        ThirdMatID = thirdMatID;
        Image = image;
    }

    public Weapon(String name, String code, String type, String attackValue, int subStat, String subStatValue, String rarity, String sDescription, String iDescription, int firstMatID, int secondMatID, int thirdMatID, int image) {
        Name = name;
        Code = code;
        Type = type;
        AttackValue = attackValue;
        SubStat = subStat;
        SubStatValue = subStatValue;
        Rarity = rarity;
        SDescription = sDescription;
        IDescription = iDescription;
        FirstMatID = firstMatID;
        SecondMatID = secondMatID;
        ThirdMatID = thirdMatID;
        Image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFirstMatID() {
        return FirstMatID;
    }

    public void setFirstMatID(int firstMatID) {
        FirstMatID = firstMatID;
    }

    public int getSecondMatID() {
        return SecondMatID;
    }

    public void setSecondMatID(int secondMatID) {
        SecondMatID = secondMatID;
    }

    public int getThirdMatID() {
        return ThirdMatID;
    }

    public void setThirdMatID(int thirdMatID) {
        ThirdMatID = thirdMatID;
    }

    public String getSDescription() {
        return SDescription;
    }

    public void setSDescription(String SDescription) {
        this.SDescription = SDescription;
    }

    public String getIDescription() {
        return IDescription;
    }

    public void setIDescription(String IDescription) {
        this.IDescription = IDescription;
    }

    public String getName() {
        return Name;
    }

    public String getType() { return Type; }

    public String getCode() {
        return Code;
    }

    public String getAttackValue() { return AttackValue; }
    public int getSubStat() { return SubStat; }
    public String getSubStatValue() { return SubStatValue; }

    public String getRarity() {
        return Rarity;
    }

    public int getImage() {
        return Image;
    }


    public void setName(String name) {
        Name = name;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setType(String type) { Type = type; }

    public void setAttackValue(String attackValue) { AttackValue = attackValue; }
    public void setSubStat (int subStat ) { SubStat = subStat ; }
    public void setSubStatValue (String subStatValue ) { SubStatValue = subStatValue ; }

    public void setRarity(String rarity) {
        Rarity = rarity;
    }


    public void setImage(int image) {
        Image = image;
    }
}