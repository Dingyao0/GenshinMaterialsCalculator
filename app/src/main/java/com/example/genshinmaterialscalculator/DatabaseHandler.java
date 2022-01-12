package com.example.genshinmaterialscalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "genshin";

    private static final String TABLE_FAVOURITE = "favourites";
    private static final String KEY_FID = "id";
    private static final String KEY_FCID = "characterId";

    private static final String TABLE_CHARACTER_STONE = "characterStone";
    private static final String KEY_CSID = "id";
    private static final String KEY_CSNAME = "name";
    private static final String KEY_CSIMAGE = "image";

    private static final String TABLE_CHARACTER_LOCAL = "characterLocal";
    private static final String KEY_CLID = "id";
    private static final String KEY_CLNAME = "name";
    private static final String KEY_CLREGION = "region";

    private static final String TABLE_CHARACTER_PRIMARY = "CharacterPrimary";
    private static final String KEY_CPID = "id";
    private static final String KEY_CPNAME1 = "name1";
    private static final String KEY_CPNAME2 = "name2";
    private static final String KEY_CPNAME3 = "name3";
    private static final String KEY_CPNAME4 = "name4";
    private static final String KEY_CPWHERE = "'where'";
    private static final String KEY_CPIMAGE = "image";

    private static final String TABLE_WEAPON_PRIMARY = "WeaponPrimary";
    private static final String KEY_WPID = "id";
    private static final String KEY_WPNAME1 = "name1";
    private static final String KEY_WPNAME2 = "name2";
    private static final String KEY_WPNAME3 = "name3";
    private static final String KEY_WPNAME4 = "name4";
    private static final String KEY_WPWHERE = "'where'";
    private static final String KEY_WPIMAGE = "image";

    private static final String TABLE_WEAPON_SECONDARY = "WeaponSecondary";
    private static final String KEY_WSID = "id";
    private static final String KEY_WSNAME1 = "name1";
    private static final String KEY_WSNAME2 = "name2";
    private static final String KEY_WSNAME3 = "name3";
    private static final String KEY_WSWHERE = "'where'";
    private static final String KEY_WSIMAGE = "image";

    private static final String TABLE_CHARACTER_SECONDARY = "CharacterSecondary";
    private static final String KEY_CS_ID = "id";
    private static final String KEY_CS_NAME1 = "name1";
    private static final String KEY_CS_NAME2 = "name2";
    private static final String KEY_CS_NAME3 = "name3";
    private static final String KEY_CS_WHERE = "'where'";
    private static final String KEY_CS_IMAGE = "image";

    private static final String TABLE_WEEKLY = "Weekly";
    private static final String KEY_WID = "id";
    private static final String KEY_WNAME = "name";
    private static final String KEY_W_IMAGE = "image";

    //KEY_CS_ID IS CHARACTER SECONDARY
    //KEY_CSID IS CHARACTER STONE
    //ETC

    private static final String TABLE_CHARACTERS = "characters";
    private static final String KEY_CID = "id";
    private static final String KEY_CNAME = "name";
    private static final String KEY_CELEMENT = "element";
    private static final String KEY_CWEAPONTYPE = "weaponType";
    private static final String KEY_CHP = "hp";
    private static final String KEY_CATTACKVALUE = "attackValue";
    private static final String KEY_CDEF = "def";
    private static final String KEY_CSECONDARYSTAT = "secondaryStat";
    private static final String KEY_CSECONDARYSTATVALUE = "secondaryStatValue";
    private static final String KEY_CCRITRATE = "critRate";
    private static final String KEY_CCRITDAMAGE = "critDamage";
    private static final String KEY_CIMAGE = "image";
    private static final String KEY_CCODE = "code";
    private static final String KEY_CRARITY = "rarity";
    private static final String KEY_CSDESCRIPTION = "sDescription";
    private static final String KEY_CIDESCRIPTION = "iDescription";
    private static final String KEY_CCHARACTERSTONEID = "characterStoneId";
    private static final String KEY_CCHARACTERLOCALID = "characterLocalId";
    private static final String KEY_CCHARACTERPRIMARYID = "characterPrimaryId";
    private static final String KEY_CCHARACTERSECONDARYID = "characterSecondaryId";
    private static final String KEY_CWEEKLYID = "weeklyId";
    private static final String KEY_CREGION = "region";



    private static final String TABLE_WEAPONS = "weapons";
    private static final String KEY_WEAPON_ID = "id";
    private static final String KEY_WEAPON_NAME = "name";
    private static final String KEY_TYPE = "type";
    private static final String KEY_ATTACKVALUE = "attack";
    private static final String KEY_SUBSTAT = "subStat";
    private static final String KEY_SUBSTATVALUE = "subStatValue";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_CODE = "code";
    private static final String KEY_RARITY = "rarity";
    private static final String KEY_SDESCRIPTION = "sDescription";
    private static final String KEY_IDESCRIPTION = "iDescription";
    private static final String KEY_FIRSTMATID = "firstMatId";
    private static final String KEY_SECONDMATID = "secondMatId";
    private static final String KEY_THIRDMATID = "thirdMatId";

    //private static final String TABLE_MAT = "weapons";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    public void deleteDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEAPONS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String CREATE_CHARACTERS_TABLE = "CREATE TABLE " + TABLE_CHARACTERS + "("
//                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
//                + KEY_PH_NO + " TEXT" + ")";
//        db.execSQL(CREATE_CHARACTERS_TABLE);

        String CREATE_FAVOURITES_TABLE = "CREATE TABLE " + TABLE_FAVOURITE + "("
                + KEY_FID + " INTEGER PRIMARY KEY," + KEY_FCID + " INTEGER)";
        db.execSQL(CREATE_FAVOURITES_TABLE);

        //create character stones table query
        String CREATE_CHARACTER_STONE_TABLE = "CREATE TABLE " + TABLE_CHARACTER_STONE + "("
                + KEY_CSID + " INTEGER PRIMARY KEY," + KEY_CSNAME + " TEXT,"
                + KEY_CSIMAGE + " INTEGER" + ")";
        db.execSQL(CREATE_CHARACTER_STONE_TABLE);


        //create character local table query
        String CREATE_CHARACTER_LOCAL_TABLE = "CREATE TABLE " + TABLE_CHARACTER_LOCAL + "("
                + KEY_CLID + " INTEGER PRIMARY KEY," + KEY_CLNAME + " TEXT,"
                + KEY_CLREGION + " TEXT" + ")";
        db.execSQL(CREATE_CHARACTER_LOCAL_TABLE);


        //create weekly table query
        String CREATE_WEEKLY_TABLE = "CREATE TABLE " + TABLE_WEEKLY + "("
                + KEY_WID + " INTEGER PRIMARY KEY," + KEY_WNAME + " TEXT,"
                + KEY_W_IMAGE + " INTEGER" + ")";
        db.execSQL(CREATE_WEEKLY_TABLE);


        //create character primary table query
        String CREATE_CHARACTER_PRIMARY_TABLE = "CREATE TABLE " + TABLE_CHARACTER_PRIMARY + "("
                + KEY_CPID + " INTEGER PRIMARY KEY,"
                + KEY_CPNAME1 + " TEXT,"
                + KEY_CPNAME2 + " TEXT,"
                + KEY_CPNAME3 + " TEXT,"
                + KEY_CPNAME4 + " TEXT,"
                + KEY_CPWHERE + " TEXT,"
                + KEY_CPIMAGE + " INTEGER" + ")";
        db.execSQL(CREATE_CHARACTER_PRIMARY_TABLE);

        //create weapon primary table query
        String CREATE_WEAPON_PRIMARY_TABLE = "CREATE TABLE " + TABLE_WEAPON_PRIMARY + "("
                + KEY_WPID + " INTEGER PRIMARY KEY,"
                + KEY_WPNAME1 + " TEXT,"
                + KEY_WPNAME2 + " TEXT,"
                + KEY_WPNAME3 + " TEXT,"
                + KEY_WPNAME4 + " TEXT,"
                + KEY_WPWHERE + " TEXT,"
                + KEY_WPIMAGE + " INTEGER" + ")";
        db.execSQL(CREATE_WEAPON_PRIMARY_TABLE);

        //create weapon secondary table query
        String CREATE_WEAPON_SECONDARY_TABLE = "CREATE TABLE " + TABLE_WEAPON_SECONDARY + "("
                + KEY_WSID + " INTEGER PRIMARY KEY,"
                + KEY_WSNAME1 + " TEXT,"
                + KEY_WSNAME2 + " TEXT,"
                + KEY_WSNAME3 + " TEXT,"
                + KEY_WSWHERE + " TEXT,"
                + KEY_WSIMAGE + " INTEGER" + ")";
        db.execSQL(CREATE_WEAPON_SECONDARY_TABLE);

        //create character secondary
        String CREATE_CHARACTER_SECONDARY_TABLE = "CREATE TABLE " + TABLE_CHARACTER_SECONDARY + "("
                + KEY_CS_ID + " INTEGER PRIMARY KEY,"
                + KEY_CS_NAME1 + " TEXT,"
                + KEY_CS_NAME2 + " TEXT,"
                + KEY_CS_NAME3 + " TEXT,"
                + KEY_CS_WHERE + " TEXT,"
                + KEY_CS_IMAGE + " INTEGER" + ")";
        db.execSQL(CREATE_CHARACTER_SECONDARY_TABLE);

        //create weapons table query
        String CREATE_WEAPONS_TABLE = "CREATE TABLE " + TABLE_WEAPONS + "("
                + KEY_WEAPON_ID + " INTEGER PRIMARY KEY,"
                + KEY_WEAPON_NAME + " TEXT,"
                + KEY_TYPE + " TEXT,"
                + KEY_ATTACKVALUE + " TEXT,"
                + KEY_SUBSTAT + " TEXT,"
                + KEY_SUBSTATVALUE + " TEXT,"
                + KEY_IMAGE + " TEXT,"
                + KEY_CODE + " TEXT,"
                + KEY_RARITY + " TEXT,"
                + KEY_SDESCRIPTION + " TEXT,"
                + KEY_IDESCRIPTION + " TEXT,"
                + KEY_FIRSTMATID + " TEXT,"
                + KEY_SECONDMATID + " TEXT,"
                + KEY_THIRDMATID + " TEXT" + ")";
        db.execSQL(CREATE_WEAPONS_TABLE);


        //create character table query
        String CREATE_CHARACTER_TABLE = "CREATE TABLE " + TABLE_CHARACTERS + "("
                + KEY_CID + " INTEGER PRIMARY KEY,"
                + KEY_CNAME + " TEXT,"
                + KEY_CELEMENT + " TEXT,"
                + KEY_CWEAPONTYPE + " TEXT,"
                + KEY_CHP + " TEXT,"
                + KEY_CATTACKVALUE + " TEXT,"
                + KEY_CDEF + " TEXT,"
                + KEY_CSECONDARYSTAT + " TEXT,"
                + KEY_CSECONDARYSTATVALUE + " TEXT,"
                + KEY_CCRITRATE + " TEXT,"
                + KEY_CCRITDAMAGE + " TEXT,"
                + KEY_CIMAGE + " INTEGER, "
                + KEY_CCODE + " TEXT,"
                + KEY_CRARITY + " TEXT,"
                + KEY_CSDESCRIPTION + " TEXT,"
                + KEY_CIDESCRIPTION + " TEXT,"
                + KEY_CREGION + " TEXT,"
                + KEY_CCHARACTERSTONEID + " INTEGER,"
                + KEY_CCHARACTERLOCALID + " INTEGER,"
                + KEY_CCHARACTERPRIMARYID + " INTEGER,"
                + KEY_CCHARACTERSECONDARYID + " INTEGER,"
                + KEY_CWEEKLYID + " INTEGER" + ")";
        db.execSQL(CREATE_CHARACTER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEAPONS);

        // Create tables again
        onCreate(db);
    }

    public void addFavorite(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FCID, id);

        db.insert(TABLE_FAVOURITE, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<Integer> getAllFavouriteCharacterId() {
        List<Integer> idList = new ArrayList<Integer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FAVOURITE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                int cid;
                cid = (cursor.getInt(1));
                idList.add(cid);
            } while (cursor.moveToNext());
        }
        return idList;
    }

    public void addCharacterStone(CharacterStone characterStone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CSNAME, characterStone.getCsName());
        values.put(KEY_CSIMAGE, characterStone.getCsImage());

        // Inserting Row
        db.insert(TABLE_CHARACTER_STONE, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public CharacterStone getCharacterStoneById(int id) {
        String selectQuery = "SELECT * FROM " + TABLE_CHARACTER_STONE + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        CharacterStone charStone = new CharacterStone();
        charStone.setCsName(cursor.getString(1));
        charStone.setCsImage(cursor.getInt(2));

        return charStone;
    }


    public void addWeekly(Weekly weekly) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CSNAME, weekly.getName());
        values.put(KEY_CSIMAGE, weekly.getImage());

        // Inserting Row
        db.insert(TABLE_WEEKLY, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public Weekly getWeeklyById(int id) {
        String selectQuery = "SELECT * FROM " + TABLE_WEEKLY + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        Weekly weekly = new Weekly();
        weekly.setName(cursor.getString(1));
        weekly.setImage(cursor.getInt(2));

        return weekly;
    }

    public void addCharacterLocal(CharacterLocal characterLocal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CLNAME, characterLocal.getClName());
        values.put(KEY_CLREGION, characterLocal.getClRegion());

        // Inserting Row
        db.insert(TABLE_CHARACTER_LOCAL, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public CharacterLocal getCharacterLocalById(int id) {
        String selectQuery = "SELECT * FROM " + TABLE_CHARACTER_LOCAL + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        CharacterLocal characterLocal = new CharacterLocal();
        characterLocal.setClName((cursor.getString(1)));
        characterLocal.setClRegion(cursor.getString(2));

        return characterLocal;
    }

    public void addCharacterPrimary(CharacterPrimary characterPrimary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CPNAME1, characterPrimary.getCpName1());
        values.put(KEY_CPNAME2, characterPrimary.getCpName2());
        values.put(KEY_CPNAME3, characterPrimary.getCpName3());
        values.put(KEY_CPNAME4, characterPrimary.getCpName4());
        values.put(KEY_CPWHERE, characterPrimary.getCpWhere());
        values.put(KEY_CPIMAGE, characterPrimary.getCpImage());

        // Inserting Row
        db.insert(TABLE_CHARACTER_PRIMARY, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public CharacterPrimary getCharacterPrimaryById(int id) {
        String selectQuery = "SELECT * FROM " + TABLE_CHARACTER_PRIMARY + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        CharacterPrimary characterPrimary = new CharacterPrimary();
        characterPrimary.setCpName1((cursor.getString(1)));
        characterPrimary.setCpName2((cursor.getString(2)));
        characterPrimary.setCpName3((cursor.getString(3)));
        characterPrimary.setCpName4((cursor.getString(4)));
        characterPrimary.setCpWhere(cursor.getString(5));
        characterPrimary.setCpImage(cursor.getInt(6));


        return characterPrimary;
    }


    public void addCharacterSecondary(CharacterSecondary characterSecondary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CS_NAME1, characterSecondary.getCs_Name1());
        values.put(KEY_CS_NAME2, characterSecondary.getCs_Name2());
        values.put(KEY_CS_NAME3, characterSecondary.getCs_Name3());
        values.put(KEY_CS_WHERE, characterSecondary.getCs_Where());
        values.put(KEY_CS_IMAGE, characterSecondary.getCs_Image());

        // Inserting Row
        db.insert(TABLE_CHARACTER_SECONDARY, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public CharacterSecondary getCharacterSecondaryById(int id) {
        String selectQuery = "SELECT * FROM " + TABLE_CHARACTER_SECONDARY + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        CharacterSecondary characterSecondary = new CharacterSecondary();
        characterSecondary.setCs_Name1((cursor.getString(1)));
        characterSecondary.setCs_Name2((cursor.getString(2)));
        characterSecondary.setCs_Name3((cursor.getString(3)));
        characterSecondary.setCs_Where(cursor.getString(4));
        characterSecondary.setCs_Image(cursor.getInt(5));

        return characterSecondary;
    }

    public void addWeaponPrimary(WeaponPrimary weaponPrimary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_WPNAME1, weaponPrimary.getWpName1());
        values.put(KEY_WPNAME2, weaponPrimary.getWpName2());
        values.put(KEY_WPNAME3, weaponPrimary.getWpName3());
        values.put(KEY_WPWHERE, weaponPrimary.getWpWhere());
        values.put(KEY_WPIMAGE, weaponPrimary.getWpImage());

        // Inserting Row
        db.insert(TABLE_WEAPON_PRIMARY, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public WeaponPrimary getWeaponPrimaryById(int id) {
        String selectQuery = "SELECT * FROM " + TABLE_WEAPON_PRIMARY + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        WeaponPrimary weaponPrimary = new WeaponPrimary();
        weaponPrimary.setWpName1((cursor.getString(1)));
        weaponPrimary.setWpName2((cursor.getString(2)));
        weaponPrimary.setWpName3((cursor.getString(3)));
        weaponPrimary.setWpName4((cursor.getString(4)));
        weaponPrimary.setWpWhere(cursor.getString(5));
        weaponPrimary.setWpImage(cursor.getInt(6));

        return weaponPrimary;
    }

    public void addWeaponSecondary(WeaponSecondary weaponSecondary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_WSNAME1, weaponSecondary.getWsName1());
        values.put(KEY_WSNAME2, weaponSecondary.getWsName2());
        values.put(KEY_WSNAME3, weaponSecondary.getWsName3());
        values.put(KEY_WSWHERE, weaponSecondary.getWsWhere());
        values.put(KEY_WSIMAGE, weaponSecondary.getWsImage());

        // Inserting Row
        db.insert(TABLE_WEAPON_SECONDARY, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public WeaponSecondary getWeaponSecondaryById(int id) {
        String selectQuery = "SELECT * FROM " + TABLE_WEAPON_SECONDARY + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        WeaponSecondary weaponSecondary = new WeaponSecondary();
        weaponSecondary.setWsName1((cursor.getString(1)));
        weaponSecondary.setWsName2((cursor.getString(2)));
        weaponSecondary.setWsName3((cursor.getString(3)));
        weaponSecondary.setWsWhere(cursor.getString(4));
        weaponSecondary.setWsImage(cursor.getInt(5));

        return weaponSecondary;
    }

    public void addCharacter(Character character) {
        Log.d("adding", "addCharacter: ");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CNAME, character.getName());
        values.put(KEY_CELEMENT, character.getElement());
        values.put(KEY_CWEAPONTYPE, character.getWeaponType());
        values.put(KEY_CHP, character.getHp());
        values.put(KEY_CATTACKVALUE, character.getAttackValue());
        values.put(KEY_CDEF, character.getDef());
        values.put(KEY_CSECONDARYSTAT, character.getSecondaryStat());
        values.put(KEY_CSECONDARYSTATVALUE, character.getSecondaryStatValue());
        values.put(KEY_CCRITRATE, character.getCritRate());
        values.put(KEY_CCRITDAMAGE, character.getCritDamage());
        values.put(KEY_CIMAGE, character.getImage());
        values.put(KEY_CCODE, character.getCode());
        values.put(KEY_CRARITY, character.getRarity());
        values.put(KEY_CSDESCRIPTION, character.getSDescription());
        values.put(KEY_CIDESCRIPTION, character.getIDescription());
        values.put(KEY_CREGION, character.getRegion());
        values.put(KEY_CCHARACTERSTONEID, character.getCharacterStoneId());
        values.put(KEY_CCHARACTERLOCALID, character.getCharacterLocalId());
        values.put(KEY_CCHARACTERPRIMARYID, character.getCharacterPrimaryId());
        values.put(KEY_CCHARACTERSECONDARYID, character.getCharacterSecondaryId());
        values.put(KEY_CWEEKLYID, character.getWeeklyBossId());

        // Inserting Row
        db.insert(TABLE_CHARACTERS, null, values);
        Log.d("added", "addCharacter done: ");
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public Character getCharacterById(int id) {
        String selectQuery = "SELECT * FROM " + TABLE_CHARACTERS + " WHERE id = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Character character = new Character();
        cursor.moveToFirst();
        //Log.d("cursor id", cursor.getString(0));
        character.setName((cursor.getString(1)));
        character.setElement((cursor.getString(2)));
        character.setWeaponType((cursor.getString(3)));
        character.setHp((cursor.getString(4)));
        character.setAttackValue((cursor.getString(5)));
        character.setDef((cursor.getString(6)));
        character.setSecondaryStat((cursor.getString(7)));
        character.setSecondaryStatValue((cursor.getString(8)));
        character.setCritRate((cursor.getString(9)));
        character.setCritDamage((cursor.getString(10)));
        character.setImage((cursor.getInt(11)));
        character.setCode((cursor.getString(12)));
        character.setRarity((cursor.getString(13)));
        character.setSDescription((cursor.getString(14)));
        character.setIDescription((cursor.getString(15)));
        character.setRegion((cursor.getString(16)));
        character.setCharacterStoneId((cursor.getInt(17)));
        character.setCharacterLocalId((cursor.getInt(18)));
        character.setCharacterPrimaryId((cursor.getInt(19)));
        character.setCharacterSecondaryId((cursor.getInt(20)));
        character.setWeeklyBossId((cursor.getInt(21)));

        return character;
    }


    public void addWeapon(Weapon weapon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //values.put(KEY_WEAPON_ID, weapon.getID());
        values.put(KEY_WEAPON_NAME, weapon.getName());
        values.put(KEY_TYPE, weapon.getType());
        values.put(KEY_ATTACKVALUE, weapon.getAttackValue());
        values.put(KEY_SUBSTAT, weapon.getSubStat());
        values.put(KEY_SUBSTATVALUE, weapon.getSubStatValue());
        values.put(KEY_IMAGE, weapon.getImage());
        values.put(KEY_CODE, weapon.getCode());
        values.put(KEY_RARITY, weapon.getRarity());
        values.put(KEY_SDESCRIPTION, weapon.getSDescription());
        values.put(KEY_IDESCRIPTION, weapon.getIDescription());
        values.put(KEY_FIRSTMATID, weapon.getFirstMatID());
        values.put(KEY_SECONDMATID, weapon.getSecondMatID());
        values.put(KEY_THIRDMATID, weapon.getThirdMatID());

        // Inserting Row
        db.insert(TABLE_WEAPONS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<Weapon> getAllWeapons() {
        List<Weapon> weaponsList = new ArrayList<Weapon>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_WEAPONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Weapon weapons = new Weapon();
                weapons.setID(cursor.getInt(0));
                weapons.setName(cursor.getString(1));
                weapons.setType(cursor.getString(2));
                weapons.setAttackValue(cursor.getString(3));
                weapons.setSubStat(cursor.getString(4));
                weapons.setSubStatValue(cursor.getString(5));
                weapons.setImage(cursor.getInt(6));
                weapons.setCode(cursor.getString(7));
                weapons.setRarity(cursor.getString(8));
                weapons.setSDescription(cursor.getString(9));
                weapons.setIDescription(cursor.getString(10));
                weapons.setFirstMatID(cursor.getInt(11));
                weapons.setSecondMatID(cursor.getInt(12));
                weapons.setThirdMatID(cursor.getInt(13));
                // Adding weapons to list
                weaponsList.add(weapons);
            } while (cursor.moveToNext());
        }
        // return weapon list
        return weaponsList;
    }

}
