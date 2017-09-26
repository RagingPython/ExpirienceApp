package shitycoders.expirienceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbConnector {
    private MyDbOpenHelper openHelper;
    private SQLiteDatabase database;

    private static String DB_DATABSE_NAME ="notes";
    private static String DB_NOTE = "note";

    public DbConnector(Context context) {
        openHelper = new MyDbOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public void addRecord(String txt){
        ContentValues values = new ContentValues();
        values.put(DB_NOTE, txt);
        database.insert(DB_DATABSE_NAME, null, values);
    }

    public Cursor readAll() {
        String[] cols = new String[] {DB_NOTE};
        Cursor ans = database.query(false, DB_DATABSE_NAME, cols, null, null, null,null, null, null);
        if (ans != null) {
            ans.moveToFirst();
        }
        return ans;
    }
}
