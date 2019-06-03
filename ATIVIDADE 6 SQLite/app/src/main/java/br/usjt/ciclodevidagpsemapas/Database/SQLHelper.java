package br.usjt.ciclodevidagpsemapas.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "gps";
    private static final int DB_VERSION = 1;

    SQLHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(GPSContratos.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(GPSContratos.removerTabela());
        onCreate(db);
    }
}
