/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.andruszko.lepapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import net.andruszko.lepapp.db.LepProviderMetaData.LepItemsTableMetaData;

public class LepDBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_CREATE_DICTLEPSESSION = "create table " + LepProviderMetaData.DB_TABLE_DICTLEPSESSION + " ( id integer primary key , description text not null)";
    private static final String DB_CREATE_DICTCORRECTANS = "create table " + LepProviderMetaData.DB_TABLE_DICTCORRECTANS + " ( id integer primary key , description text not null)";
    private static final String DB_CREATE_DICTLANGUAGE = "create table " + LepProviderMetaData.DB_TABLE_DICTLANGUAGE + " ( id integer primary key , description text not null)";
    private static final String DB_CREATE_DICTLEPTYPE = "create table " + LepProviderMetaData.DB_TABLE_DICTLEPTYPE + " ( id integer primary key , description text not null)";
    private static final String DB_CREATE_DICTSUBSSECTION = "create table " + LepProviderMetaData.DB_TABLE_DICTLEPTYPE + " ( id integer primary key , description text not null)";
    
    private static final String DB_CREATE_SMS_ITEM = "create table "
            + LepProviderMetaData.DB_TABLE_LEP_ITEM + " ( "
            + LepItemsTableMetaData.KEY_ID + " integer primary key autoincrement, "
            + LepItemsTableMetaData.KEY_POSITION + " integer not null ,"
            + LepItemsTableMetaData.KEY_QUESTION + " text not null ,"
            + LepItemsTableMetaData.KEY_ANSWER_A + " text not null ,"
            + LepItemsTableMetaData.KEY_ANSWER_B + " text not null ,"
            + LepItemsTableMetaData.KEY_ANSWER_C + " text not null ,"
            + LepItemsTableMetaData.KEY_ANSWER_D + " text not null ,"
            + LepItemsTableMetaData.KEY_ANSWER_E + " text not null ,"
            + LepItemsTableMetaData.KEY_SESSION_ID + "integer not null ,"
            + LepItemsTableMetaData.KEY_LEPTYPE_ID + "integer not null ,"
            + LepItemsTableMetaData.KEY_LANG_ID + "integer not null ,"
            + LepItemsTableMetaData.KEY_CORRECT_ANSWER_ID + "integer not null ,"
            
            + "foreign key (" + LepItemsTableMetaData.KEY_SESSION_ID + ")"
            + "references " + LepProviderMetaData.DB_TABLE_DICTLEPSESSION + " (id),"
                 + "foreign key (" + LepItemsTableMetaData.KEY_SECTION_ID + ")"
            + "references " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " (id),"
            + "foreign key (" + LepItemsTableMetaData.KEY_LEPTYPE_ID + ")"
            + "references " + LepProviderMetaData.DB_TABLE_DICTLEPTYPE + " (id),"
            + "foreign key (" + LepItemsTableMetaData.KEY_LANG_ID + ")"
            + "references " + LepProviderMetaData.DB_TABLE_DICTLANGUAGE + " (id),"
            + "foreign key (" + LepItemsTableMetaData.KEY_CORRECT_ANSWER_ID + ")"
            + "references " + LepProviderMetaData.DB_TABLE_DICTCORRECTANS + " (id)"
            + ")";

    public LepDBOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("db", DB_CREATE_SMS_ITEM + "\n " + DB_CREATE_DICTLEPSESSION);
        db.execSQL(DB_CREATE_DICTLEPSESSION);
        db.execSQL(DB_CREATE_DICTCORRECTANS);
        db.execSQL(DB_CREATE_DICTLANGUAGE);
        db.execSQL(DB_CREATE_DICTLEPTYPE);
        db.execSQL(DB_CREATE_DICTSUBSSECTION);
        
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLANGUAGE + " values(10,'PL')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLANGUAGE + " values(20,'EN')");
        
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLEPTYPE + " values(10,'LEP')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLEPTYPE + " values(20,'LDEP')");
        
        
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(10,'Interna')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(20,'Pediatria')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(30,'Chirurgia')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(40,'Ginekologia i Położ.')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(50,'Med. rodzinna')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(60,'Psychiatria')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(70,'Med. Ratunkowa i Intens.')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(80,'Prawo med. i bioetyka')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(90,'Orzecznictwo')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTSUBSECTION + " values(100,'Zdrowie Publiczne')");
        
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTCORRECTANS + " values(10,'A')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTCORRECTANS + " values(20,'B')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTCORRECTANS + " values(30,'C')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTCORRECTANS + " values(40,'D')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTCORRECTANS + " values(50,'E')");
              
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLEPSESSION + " values(10,'2008-09')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLEPSESSION + " values(20,'2009-02')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLEPSESSION + " values(30,'2009-09')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLEPSESSION + " values(40,'2010-02')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLEPSESSION + " values(50,'2010-09')");
        db.execSQL("insert into " + LepProviderMetaData.DB_TABLE_DICTLEPSESSION + " values(60,'2011-02')");
        db.execSQL(DB_CREATE_SMS_ITEM);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //	db.execSQL("DROP TABLE IF EXISTS "+SmsManagerProviderMetaData.DB_TABLE_SMSITEM);
        //	db.execSQL("DROP TABLE IF EXISTS "+SmsManagerProviderMetaData.DB_TABLE_DICSMSSTATUS);
        //chamska metoda
        onCreate(db);

    }
}
