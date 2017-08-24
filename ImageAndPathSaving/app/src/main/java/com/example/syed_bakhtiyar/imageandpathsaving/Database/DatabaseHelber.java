package com.example.syed_bakhtiyar.imageandpathsaving.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.syed_bakhtiyar.imageandpathsaving.ImagesData.MyImages;

import java.util.ArrayList;

/**
 * Created by Syed_Bakhtiyar on 8/20/2017.
 */
public class DatabaseHelber extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TODO.db";

    public static final int version = 1;

    public static final String CREATE_DATA_TABLE = "CREATE TABLE IF NOT EXIST "+DbDictionary.DATA_TABLE+" ("+DbDictionary.Data._ID+" INTEGER PRIMARY KEY AUTO INCREMENT , "+DbDictionary.Data.MY_DATA+" TEXT, "+DbDictionary.Data.FLOW+" INTEGER)";

    public static final String CREATE_IMAGE_TABLE = "CREATE TABLE IF NOT EXIST "+DbDictionary.IMAGE_TABLE+"( "+DbDictionary.Image_Saving._ID+" INTEGER PRIMARY KEY AUTO INCREMENT, "+DbDictionary.Image_Saving.DATA_ID+" INTEGER, "+DbDictionary.Image_Saving.IMAGES+" BLOB, "+DbDictionary.Image_Saving.IMAGE_NUMBER+" INTEGER)";

    public static final String CREATE_PATH_TABLE = "CREATE TABLE IF NOT EXIST "+DbDictionary.PATH_TABLE+"( "+DbDictionary.path_Saving._ID+" INTEGER PRIMARY KEY AUTO INCREMENT, "+DbDictionary.path_Saving.DATA_ID+" INTEGER, "+DbDictionary.path_Saving.PATH+" TEXT, "+DbDictionary.path_Saving.IMAGE_NUMBER+" INTEGER)";

    public static final String DROP_DATA_TABLE = "DROP TABLE "+DbDictionary.DATA_TABLE;

    public static final String DROP_IMAGE_TABLE = "DROP TABLE "+DbDictionary.IMAGE_TABLE;

    public static final String DROP_PATH_TABLE = "DROP TABLE "+DbDictionary.PATH_TABLE;

    Context context;

    ContentValues contentValues;

    Cursor cursor;

    public DatabaseHelber(Context context) {
        super(context, DATABASE_NAME, null, version);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DATA_TABLE);

        db.execSQL(CREATE_IMAGE_TABLE);

        db.execSQL(CREATE_PATH_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_DATA_TABLE);

        db.execSQL(DROP_IMAGE_TABLE);

        db.execSQL(DROP_PATH_TABLE);



    }

    public void writeData(String data, ArrayList<MyImages> arrayList, int execution, ArrayList<Integer> integerArrayList){

        contentValues = new ContentValues();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();



        if(execution == 1){
            // Todo image processing here


            contentValues.put(DbDictionary.Data.MY_DATA,data);

            contentValues.put(DbDictionary.Data.FLOW,execution);

            long is_insert = sqLiteDatabase.insert(DbDictionary.DATA_TABLE,null,contentValues);

            contentValues = null;

            contentValues = new ContentValues();

            if(is_insert != -1){

                int ref = -1;

                sqLiteDatabase = getReadableDatabase();

                cursor = sqLiteDatabase.rawQuery("SELECT MAX("+DbDictionary.Data._ID+") FROM "+DbDictionary.DATA_TABLE,null);

                while (cursor.moveToNext()){


                        ref = cursor.getInt(cursor.getColumnIndex(DbDictionary.Data._ID));



                }

                cursor.close();

                sqLiteDatabase = getWritableDatabase();

                for(int i = 0 ; i< arrayList.size() ; i++){

                    contentValues.put(DbDictionary.Image_Saving.DATA_ID,ref);

                    contentValues.put(DbDictionary.Image_Saving.IMAGES,arrayList.get(i).getImages());

                    contentValues.put(DbDictionary.Image_Saving.IMAGE_NUMBER, integerArrayList.get(i));

                    long is_save =  sqLiteDatabase.insert(DbDictionary.IMAGE_TABLE,null,contentValues);

                        if(is_save != -1){

                            Toast.makeText(context, "Inserted Images", Toast.LENGTH_SHORT).show();

                        }
                        else {

                            Toast.makeText(context, "Not Inserted Images", Toast.LENGTH_SHORT).show();

                        }

                }

            }




        }
        else {
            // Todo Path processing here


            contentValues.put(DbDictionary.Data.MY_DATA,data);

            contentValues.put(DbDictionary.Data.FLOW,execution);

            long is_insert = sqLiteDatabase.insert(DbDictionary.DATA_TABLE,null,contentValues);

            contentValues = null;

            contentValues = new ContentValues();

            if(is_insert != -1){

                int ref = -1;

                sqLiteDatabase = getReadableDatabase();

                cursor = sqLiteDatabase.rawQuery("SELECT MAX("+DbDictionary.Data._ID+") FROM "+DbDictionary.DATA_TABLE,null);

                while (cursor.moveToNext()){


                    ref = cursor.getInt(cursor.getColumnIndex(DbDictionary.Data._ID));



                }

                cursor.close();

                sqLiteDatabase = getWritableDatabase();

                for(int i = 0 ; i< arrayList.size() ; i++){

                    contentValues.put(DbDictionary.Image_Saving.DATA_ID,ref);

                    contentValues.put(DbDictionary.path_Saving.PATH,arrayList.get(i).getPath());

                    contentValues.put(DbDictionary.Image_Saving.IMAGE_NUMBER, integerArrayList.get(i));

                    long is_save =  sqLiteDatabase.insert(DbDictionary.PATH_TABLE,null,contentValues);

                    if(is_save != -1){

                        Toast.makeText(context, "Inserted path with data", Toast.LENGTH_SHORT).show();

                    }
                    else {

                        Toast.makeText(context, "Not Inserted path with data", Toast.LENGTH_SHORT).show();

                    }

                }

            }




        }



    }



}
