package com.example.tuan07;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SqliteHelper extends SQLiteOpenHelper {

    private static final  int version = 1;
    private static final  String databaseName = "itemDB";
    private static final  String tableName = "item";
    private static final  String NAME = "name";
    private static final  String key = "id";

    private Item item;


    public SqliteHelper(@Nullable Context context) {
        super(context, databaseName, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + tableName + "("
                + key + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT)";

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(sqLiteDatabase);
    }
    public void addItem(Item item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,item.getName());
        db.insert(tableName,null,values);
        db.close();
    }
    public List<Item> getAllItem(){

        List<Item> ls = new ArrayList<Item>();
        String sql = "SELECT  * FROM " + tableName;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        if (cursor.moveToFirst()) {
            do {
                Item i = new Item();
                i.setId(Integer.parseInt(cursor.getString(0)));
                i.setName(cursor.getString(1));

                ls.add(i);
            } while (cursor.moveToNext());
        }


        return ls;
    }

    public void updateItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, item.getName());
//        String sql = "UPDATE "+tableName +" SET name =" +item.getName()+ "where id="+item.getId();
//
//        db.execSQL(sql);

        db.update(tableName, values, key + " = ?",
                new String[] { String.valueOf(item.getId()) });
    }

    public int deleteItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(tableName,  key + " = ?",
                new String[] { String.valueOf(item.getId()) });
    }


}
