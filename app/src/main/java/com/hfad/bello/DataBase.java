
//This class is responsible for local sqlite database which will store user information
//If entry of a user exists in this database,authentication fragment will not be opened
package com.hfad.bello;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

//SQLiteOpenHelper creates database when app needs to access it,not before
public class DataBase extends SQLiteOpenHelper {

    //Database name is given so that the database exists even after app is closed
    private static final String nameDatabase="BelloBase";
    //Only one version of the database is created
    private static final int versionDatabase=1;

    //Class constructor
    public DataBase(Context context)
    {
        super(context,nameDatabase,null,versionDatabase);//third parameter is related to cursors
    }
    //This method is called when database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("Database creation: ","check");
        //create table
        db.execSQL("CREATE TABLE USER("+"EMAIL TEXT PRIMARY KEY," +
                "NAME TEXT," +
                "PASSWORD TEXT," +
                "CLUBS TEXT," +
                "UPCOMING_CLUB_EVENTS TEXT," +
                "UPCOMING_CLUB_EVENTS_DATE NUMERIC," +
                "ADMIN TEXT)");




    }

    //This method is called when database is updated
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertUsertData(String Email,String name,String password)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("EMAIL",Email);
        contentValues.put("NAME",name);
        contentValues.put("PASSWORD",password);
        sqLiteDatabase.insert(nameDatabase,null,contentValues);
    }

    public void insertAdmin(String clubName)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ADMIN",clubName);
        sqLiteDatabase.insert(nameDatabase,null,contentValues);
    }

    public void insertClubs(String clubName)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("CLUBS",clubName);
        sqLiteDatabase.insert(nameDatabase,null,contentValues);
    }

}
