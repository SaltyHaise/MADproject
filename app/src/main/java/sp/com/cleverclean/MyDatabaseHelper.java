package sp.com.cleverclean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.ColorSpace;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }

    public long insertInfo(String name, String address, String date, double lat, double lon, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Constants.C_NAME, name);
        cv.put(Constants.C_ADDRESS, address);
        cv.put(Constants.C_DATE, date);
        cv.put(Constants.C_LAT, lat);
        cv.put(Constants.C_LON, lon);
        cv.put(Constants.C_IMAGE, image);

        long id = db.insert(Constants.TABLE_NAME, Constants.C_NAME, cv);
        db.close();
        return id;
    }

    public void updateInfo(String id, String name, String address, String date, double lat, double lon, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Constants.C_NAME, name);
        cv.put(Constants.C_ADDRESS, address);
        cv.put(Constants.C_DATE, date);
        cv.put(Constants.C_LAT, lat);
        cv.put(Constants.C_LON, lon);
        cv.put(Constants.C_IMAGE, image);

        db.update(Constants.TABLE_NAME, cv, Constants.C_ID + " =?", new String[]{id});
        db.close();
    }

    public void deleteInfo(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Constants.TABLE_NAME, Constants.C_ID + " =?", new String[]{id});
        db.close();
    }

    public ArrayList<Model> getAllData(String orderBy) {
        ArrayList<Model> arrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " ORDER BY " + orderBy;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToNext()) {
            do {
                Model model = new Model(
                        cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_ADDRESS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Constants.C_DATE)),
                        cursor.getDouble(cursor.getColumnIndexOrThrow(Constants.C_LAT)),
                        cursor.getDouble(cursor.getColumnIndexOrThrow(Constants.C_LON)),
                        cursor.getBlob(cursor.getColumnIndexOrThrow(Constants.C_IMAGE))
                );
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }
}
