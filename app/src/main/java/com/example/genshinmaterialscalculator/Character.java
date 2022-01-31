package com.example.genshinmaterialscalculator;

public class Character {
    private int Id;
    private String Name;
    private String Element;
    private String WeaponType;
    private String Hp;
    private String AttackValue;
    private String Def;
    private int SecondaryStat;
    private String SecondaryStatValue;
    private String CritRate;
    private String CritDamage;
    private int Image;
    private String Code;
    private String Rarity;
    private String SDescription;
    private String IDescription;
    private String Region;
    private int CharacterStoneId;
    private int CharacterLocalId;
    private int CharacterPrimaryId;
    private int CharacterSecondaryId;
    private int WeeklyId;
    private int Skill1;
    private int Skill2;
    private int Skill3;
    private int BannerImage;

    public Character(int id, String name, String element, String weaponType, String hp, String attackValue,
                     String def, int secondaryStat, String secondaryStatValue, String critRate,
                     String critDamage, int image, String code, String rarity, String sDescription,
                     String iDescription, String region, int skill1, int skill2, int skill3, int bannerImage, int characterStoneId, int characterLocalId, int characterPrimaryId,
                     int characterSecondaryId, int weeklyId) {
        Id = id;
        Name = name;
        Element = element;
        WeaponType = weaponType;
        Hp = hp;
        AttackValue = attackValue;
        Def = def;
        SecondaryStat = secondaryStat;
        SecondaryStatValue = secondaryStatValue;
        CritRate = critRate;
        CritDamage = critDamage;
        Image = image;
        Code = code;
        Rarity = rarity;
        SDescription = sDescription;
        IDescription = iDescription;
        Region = region;
        Skill1 = skill1;
        Skill2 = skill2;
        Skill3 = skill3;
        BannerImage = bannerImage;
        CharacterStoneId = characterStoneId;
        CharacterLocalId = characterLocalId;
        CharacterPrimaryId = characterPrimaryId;
        CharacterSecondaryId = characterSecondaryId;
        WeeklyId = weeklyId;
    }

    public Character(String name, String element, String weaponType, String hp, String attackValue,
                     String def, int secondaryStat, String secondaryStatValue, String critRate,
                     String critDamage, int image, String code, String rarity, String sDescription,
                     String iDescription, String region, int skill1, int skill2, int skill3, int bannerImage, int characterStoneId, int characterLocalId, int characterPrimaryId,
                     int characterSecondaryId, int weeklyId) {

        Name = name;
        Element = element;
        WeaponType = weaponType;
        Hp = hp;
        AttackValue = attackValue;
        Def = def;
        SecondaryStat = secondaryStat;
        SecondaryStatValue = secondaryStatValue;
        CritRate = critRate;
        CritDamage = critDamage;
        Image = image;
        Code = code;
        Rarity = rarity;
        SDescription = sDescription;
        IDescription = iDescription;
        Region = region;
        Skill1 = skill1;
        Skill2 = skill2;
        Skill3 = skill3;
        BannerImage = bannerImage;
        CharacterStoneId = characterStoneId;
        CharacterLocalId = characterLocalId;
        CharacterPrimaryId = characterPrimaryId;
        CharacterSecondaryId = characterSecondaryId;
        WeeklyId = weeklyId;
    }

    public Character() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getElement() {
        return Element;
    }

    public void setElement(String element) {
        Element = element;
    }

    public String getWeaponType() {
        return WeaponType;
    }

    public void setWeaponType(String weaponType) {
        WeaponType = weaponType;
    }

    public String getHp() {
        return Hp;
    }

    public void setHp(String hp) {
        Hp = hp;
    }

    public String getAttackValue() {
        return AttackValue;
    }

    public void setAttackValue(String attackValue) {
        AttackValue = attackValue;
    }

    public String getDef() {
        return Def;
    }

    public void setDef(String def) {
        Def = def;
    }

    public int getSecondaryStat() {
        return SecondaryStat;
    }

    public void setSecondaryStat(int secondaryStat) {
        SecondaryStat = secondaryStat;
    }

    public String getSecondaryStatValue() {
        return SecondaryStatValue;
    }

    public void setSecondaryStatValue(String secondaryStatValue) {
        SecondaryStatValue = secondaryStatValue;
    }

    public String getCritRate() {
        return CritRate;
    }

    public void setCritRate(String critRate) {
        CritRate = critRate;
    }

    public String getCritDamage() {
        return CritDamage;
    }

    public void setCritDamage(String critDamage) {
        CritDamage = critDamage;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getRarity() {
        return Rarity;
    }

    public void setRarity(String rarity) {
        Rarity = rarity;
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

    public int getCharacterStoneId() {
        return CharacterStoneId;
    }

    public void setCharacterStoneId(int characterStoneId) {
        CharacterStoneId = characterStoneId;
    }

    public int getCharacterLocalId() {
        return CharacterLocalId;
    }

    public void setCharacterLocalId(int characterLocalId) {
        CharacterLocalId = characterLocalId;
    }

    public int getCharacterPrimaryId() {
        return CharacterPrimaryId;
    }

    public void setCharacterPrimaryId(int characterPrimaryId) {
        CharacterPrimaryId = characterPrimaryId;
    }

    public int getCharacterSecondaryId() {
        return CharacterSecondaryId;
    }

    public void setCharacterSecondaryId(int characterSecondaryId) {
        CharacterSecondaryId = characterSecondaryId;
    }

    public int getWeeklyBossId() {
        return WeeklyId;
    }

    public void setWeeklyBossId(int weeklyBossId) {
        WeeklyId = weeklyBossId;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public int getSkill1() {
        return Skill1;
    }

    public void setSkill1(int skill1) {
        Skill1 = skill1;
    }

    public int getSkill2() {
        return Skill2;
    }

    public void setSkill2(int skill2) {
        Skill2 = skill2;
    }

    public int getSkill3() {
        return Skill3;
    }

    public void setSkill3(int skill3) {
        Skill3 = skill3;
    }

    public int getBannerImage() {
        return BannerImage;
    }

    public void setBannerImage(int bannerImage) {
        BannerImage = bannerImage;
    }
}
