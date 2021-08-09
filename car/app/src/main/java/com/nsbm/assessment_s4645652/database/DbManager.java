package com.nsbm.assessment_s4645652.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.nsbm.assessment_s4645652.entity.addCar;

import java.util.ArrayList;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbName = "garage";
    private static final int Version = 1;
    private static final String tblName = "car";

    public DbManager(@Nullable Context context) {
        super(context, dbName, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String sqlCreateCar = "CREATE TABLE "+tblName
               +"(id INTEGER PRIMARY KEY AUTOINCREMENT , carBrand TEXT," +
               "carModel TEXT, carPrice TEXT )";
       sqLiteDatabase.execSQL(sqlCreateCar);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       String upgradeSql = "DROP TABLE IF EXISTS "+tblName;
       sqLiteDatabase.execSQL(upgradeSql);
       onCreate(sqLiteDatabase);

    }

    public long addEntity(addCar addCar){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("carBrand", addCar.getCarBrand());
        contentValues.put("carModel",addCar.getCarModel());
        contentValues.put("carPrice",addCar.getCarPrice());

        long retValue = sqLiteDatabase.insert(tblName, null, contentValues);
        sqLiteDatabase.close();
        return retValue;
    }

    public addCar getCarbyBrandAndModel(String carBrand, String carModel){
        addCar addCar = new addCar();
        try{
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

            String sqlQuery = "SELECT * FROM " + tblName + " WHERE (carBrand = '" +carBrand+ "' AND carModel = '" +carModel+"')";

            Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);
            if(cursor != null){
                cursor.moveToFirst();

                addCar.setId(cursor.getInt(0));
                addCar.setCarBrand(cursor.getString(1));
                addCar.setCarModel(cursor.getString(2));
                addCar.setCarPrice(cursor.getString(3));
            }
        } catch(Exception e){
            e.printStackTrace();

        }
        return addCar;
    }


        }


