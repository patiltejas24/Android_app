package com.example.kali.test2;
//
//
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.Cursor;
//import android.content.Context;
//import android.content.ContentValues;
//
//
//
//
//
///**
// * Created by root on 9/14/16.
// */
//public class MyDBHandler extends  SQLiteOpenHelper{
//
//    public static final int DATABASE_VERSION = 1 ;
//    public static final String DATABASE_NAME= "Product.db";
//    public static final String TABLE_NAME= "Product";
//    public static final String COLUMN_ID= "_id";
//    public static final String COLUMN_PRODUCTNAME = "productname";
//
//    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//        String query = "CREATE TABLE Product ( _id INTEGER PRIMARY KEY AUTOINCREMENT , _productname TEXT); ";
//        db.execSQL(query);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//        db.execSQL("DROP TABLE  IF EXISTS Product");
//        onCreate(db);
//    }
//
//    //Add new row to database
//    public void  addProduct(Product product){
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_PRODUCTNAME,product.get_productname());
//
//        SQLiteDatabase db = getWritableDatabase();
//
//        db.insert(TABLE_NAME , null , values);
//        //close database n clear the memory
//        db.close();
//
//    }
//
//    //deletedatabase
//    public void deleteProduct (String productName){
//
//        SQLiteDatabase db = getWritableDatabase();
//
//        db.execSQL("DELETE FROM Product WHERE _productname = \"productname\";");
//
//    }
//
//
//    //print out database to string
//
//    public String databaseToString (){
//        String dbString = "";
//        SQLiteDatabase db = getWritableDatabase();
//
//        String query = "SELECT * FROM Product WHERE 1 ; ";
//
//
//
////
////    Cursor c = db.rawQuery(query,null);
////
////        c.moveToFirst();
////
////        while (!c.moveToLast()){
////            if(c.getString(c.getColumnIndex("productname"))!=null){
////                dbString += c.getString(c.getColumnIndex("productname"));
////                dbString += "\n";
////            }
//
//
//     //   }
//
//        //Cursor points to a location in your results
//        Cursor recordSet = db.rawQuery(query, null);
//
//        //Move to the first row in your results
//        recordSet.moveToFirst();
//
//        //Position after the last row means the end of the results
//        while (!recordSet.isAfterLast()) {
//            // null could happen if we used our empty constructor
//            if (recordSet.getString(recordSet.getColumnIndex("productname")) != null) {
//                dbString += recordSet.getString(recordSet.getColumnIndex("productname"));
//                dbString += "\n";
//            }
//            recordSet.moveToNext();
//        }
//        db.close();
//        return dbString;
//    }
//
////        db.close();
////        return dbString;
//
//
//    }
//
//

// This class handles all the database activities
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";

    //We need to pass database information along to superclass
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCTNAME + " TEXT " +
                ");";
        db.execSQL(query);
    }
    //Lesson 51
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    //Add a new row to the database
    public void addProduct(Product product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.get_productname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    //Delete a product from the database
    public void deleteProduct(String productName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");
    }

    // this is goint in record_TextView in the Main activity.
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";// why not leave out the WHERE  clause?

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex("productname")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("productname"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }

}
