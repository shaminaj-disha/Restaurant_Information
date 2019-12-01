package com.example.user.myprojectpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBaseCreate  extends SQLiteOpenHelper {
    public static final String TAG = DataBaseCreate.class.getSimpleName();
    public static final String DB_NAME = "loginInformation.db";
    public static final int DB_VERSION= 1; //update korle version change hobe updated database er jonno

    public static final String USER_TABLE = "users";
    public static final String RESTAURANT_TABLE = "restaurant";
    public static final String REVIEW_TABLE = "review";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_MOBILE = "mobile";

    public static final String COLUMN_ID2 = "id";
    public static final String COLUMN_rNAME = "rName";
    public static final String COLUMN_rAdd = "rAddress";
    public static final String COLUMN_rMOBILE = "rMobile";
    public static final String COLUMN_rRating = "rRating";
    public static final String COLUMN_rLocation = "rLocation";

    public static final String COLUMN_ID3 = "id3";
    public static final String COLUMN_RES_NAME = "resName";
    public static final String COLUMN_REVIEWER_NAME = "reviewerName";
    public static final String COLUMN_RES_REVIEW = "resRev";
    public static final String COLUMN_RES_RATING = "resRating";



    public static final String CREATE_TABLE_USERS = "CREATE TABLE "+ USER_TABLE + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT," +
            COLUMN_EMAIL + " TEXT," + COLUMN_MOBILE +" TEXT," + COLUMN_PASS+ " TEXT);";

    public static final String CREATE_TABLE_RESTAURANT = "CREATE TABLE "+ RESTAURANT_TABLE + "(" +
            COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_rNAME + " TEXT," +
            COLUMN_rAdd + " TEXT," + COLUMN_rMOBILE +" TEXT," + COLUMN_rRating+ " TEXT," +
            COLUMN_rLocation+ " TEXT);";

    public static final String CREATE_TABLE_REVIEW = "CREATE TABLE "+ REVIEW_TABLE + "(" +
            COLUMN_ID3 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_RES_NAME + " TEXT,"
            + COLUMN_REVIEWER_NAME + " TEXT," + COLUMN_RES_REVIEW +" TEXT," +
            COLUMN_RES_RATING + " TEXT);";




    public DataBaseCreate(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_RESTAURANT); //string type command ney
        db.execSQL(CREATE_TABLE_REVIEW);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ RESTAURANT_TABLE);  //ager table drop kore niche niye ashbe, upore notun ta thakbe
        db.execSQL("DROP TABLE IF EXISTS "+ REVIEW_TABLE);
        onCreate(db); //notun table create hobe

    }
    public void addUser( String name, String email, String mobile, String pass){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues(); //Array(Bundle er moto)
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_EMAIL,email);
        values.put(COLUMN_MOBILE,mobile);
        values.put(COLUMN_PASS,pass);

        long id = db.insert(USER_TABLE, null, values);  //database command with java for insert
        db.close();

        Log.d(TAG, "user inserted" + id);

    }
    public void addRestaurant( String name, String add, String mobile, String rating, String location){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_rNAME,name);
        values.put(COLUMN_rAdd,add);
        values.put(COLUMN_rMOBILE,mobile);
        values.put(COLUMN_rRating,rating);
        values.put(COLUMN_rLocation,location);

        long id2 = db.insert(RESTAURANT_TABLE, null, values);
        db.close();

        Log.d(TAG, "information inserted" + id2);

    }
    public void addReview( String resName, String reviwerName, String resRev, String resRating){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_RES_NAME,resName);
        values.put(COLUMN_REVIEWER_NAME,reviwerName);
        values.put(COLUMN_RES_REVIEW,resRev);
        values.put(COLUMN_RES_RATING,resRating);

        long id3 = db.insert(REVIEW_TABLE, null, values);
        db.close();

        Log.d(TAG, "information inserted" + id3);

    }
    public boolean getUser( String email, String pass){

        String selectQuery = "select * from "+USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String uEmail = cursor.getString(2);
            String passWord = cursor.getString(4);

            if (uEmail.equals(email) && passWord.equals(pass))
            {
                return true;
            }
            else
                cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return false;
    }
    public String getUserName( String email){

        String selectQuery = "select * from "+USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null); //column name gular okhane cursor thakbe 1st e

        cursor.moveToFirst(); ////first id er okane chole ashbe
        while (!cursor.isAfterLast()) {
            String uEmail = cursor.getString(2);

            if (uEmail.equals(email))
            {
                String uName= cursor.getString(1);
                return uName;
            }
            else
                cursor.moveToNext();
        }
        cursor.close();
        db.close();

        return "Not Found";
    }

    public boolean getRes( String name){

        String selectQuery = "select * from "+RESTAURANT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String rName = cursor.getString(1);

            if (rName.equals(name))
                return true;
            else
                cursor.moveToNext();
        }
        cursor.close();
        db.close();

        return false;
    }
    public ArrayList<String> getResDetails( String name){

        ArrayList<String> restA = new ArrayList<>();

        String selectQuery = "select * from "+RESTAURANT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String rName = cursor.getString(1);

            if (rName.equals(name)){

                restA.add(rName);
                restA.add(cursor.getString(2));
                restA.add(cursor.getString(3));
                restA.add(cursor.getString(4));
                restA.add(cursor.getString(5));
                break;
            }

            else
                cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return restA;
    }

    public List <RestaurantList> getRestaurant(){
        RestaurantList restaurantList = null;
        List <RestaurantList> restA = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "select * from restaurant";


        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            restaurantList = new RestaurantList(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));

            restA.add(restaurantList);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return restA;
    }

    public List<RestaurantReviewList> getReviewResturatnt(String resName)
    {
        RestaurantReviewList reviewList = null;
        List <RestaurantReviewList> revA = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "select * from review";


        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            String resN = cursor.getString(1);
            if (resN.equals(resName))
            {
                reviewList = new RestaurantReviewList(cursor.getInt(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4));
                revA.add(reviewList);
            }
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return revA;
    }
}
