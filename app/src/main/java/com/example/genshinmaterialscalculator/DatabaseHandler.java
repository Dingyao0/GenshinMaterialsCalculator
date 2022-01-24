package com.example.genshinmaterialscalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "genshin";
    //private static final String TABLE_CHARACTERS = "characters";


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
        Log.d("delete", "deleteDatabase: ...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String CREATE_CHARACTERS_TABLE = "CREATE TABLE " + TABLE_CHARACTERS + "("
//                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
//                + KEY_PH_NO + " TEXT" + ")";
//        db.execSQL(CREATE_CONTACTS_TABLE);
        Log.d("databasehandler", "onCreate: ");

        String CREATE_WEAPONS_TABLE = "CREATE TABLE " + TABLE_WEAPONS + "("
                + KEY_WEAPON_ID + " INTEGER PRIMARY KEY,"
                + KEY_WEAPON_NAME + " TEXT,"
                + KEY_TYPE + " TEXT,"
                + KEY_ATTACKVALUE + " TEXT,"
                + KEY_SUBSTAT + " z,"
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

        Log.d("database", "onCreate: table created");
//      String CREATE_MAT_TABLE = "CREATE TABLE " + TABLE_MAT + "("
//                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
//                + KEY_PH_NO + " TEXT" + ")";
//        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEAPONS);

        // Create tables again
        onCreate(db);
    }

    public void addWeapon(Weapons weapon) {
        Log.d("addWeapon", "above");
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("addWeapon", "below");

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

    public List<Weapons> getAllWeapons() {
        List<Weapons> weaponsList = new ArrayList<Weapons>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_WEAPONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Weapons weapons = new Weapons();
                weapons.setID(cursor.getInt(0));
                weapons.setName(cursor.getString(1));
                weapons.setType(cursor.getString(2));
                weapons.setAttackValue(cursor.getString(3));
                weapons.setSubStat(cursor.getInt(4));
                weapons.setSubStatValue(cursor.getString(5));
                weapons.setImage(cursor.getInt(6));
                weapons.setCode(cursor.getString(7));
                weapons.setRarity(cursor.getString(8));
                weapons.setSDescription(cursor.getString(9));
                weapons.setIDescription(cursor.getString(10));
                weapons.setFirstMatID(cursor.getInt(11));
                weapons.setSecondMatID(cursor.getInt(12));
                weapons.setThirdMatID(cursor.getInt(13));
                // Adding contact to list
                weaponsList.add(weapons);
            } while (cursor.moveToNext());
        }
        // return contact list
        return weaponsList;
    }

}
