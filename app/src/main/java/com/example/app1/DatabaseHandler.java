package com.example.app1;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String TABLE_NAME="table_name";
    private static final String DATABASE_NAME="ProjectTexnologiasLogismikou";
    private static final int DATABASE_VERSION=1;
    private static final String KEYID="id";
    private static final String KEYNAME="name";


    public DatabaseHandler(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_CATEGORIES_TABLE="CREATE TABLE "+TABLE_NAME+"("+KEYID+"INTEGER PRIMARY  KEY , "
                + KEYNAME  + "   TEXT  )";
        db.execSQL(CREATE_CATEGORIES_TABLE);

    }

    public void onUpgrade(SQLiteDatabase  db, int past_version,int new_version)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void insertLabel(String label)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEYNAME,label);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public List<String> getAllLabels()
    {

        List<String> list = new ArrayList<String>();
        String selectQuery="SELECT *     FROM  " + TABLE_NAME;
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor c= db.rawQuery(selectQuery,null);
        if(c.moveToFirst())
        {

            do
            {
                list.add(c.getString(1));
            }while(c.moveToNext());

        }

         c.close();
         db.close();
         return list;
    }


}
