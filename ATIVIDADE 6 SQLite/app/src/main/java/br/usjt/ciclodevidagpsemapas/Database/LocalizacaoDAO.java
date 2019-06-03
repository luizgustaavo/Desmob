package br.usjt.ciclodevidagpsemapas.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.usjt.ciclodevidagpsemapas.Model.Localizacao;

public class LocalizacaoDAO {

    private Context context;

    public LocalizacaoDAO(Context context) {
        this.context = context;
    }

    public List<Localizacao> resgataLocalizacoes() {
        SQLHelper helper = new SQLHelper(context);
        SQLiteDatabase database = helper.getReadableDatabase();
        String query = String.format(Locale.getDefault(), "SELECT * FROM %s ORDER BY %s DESC LIMIT 50", GPSContratos.TABLE_NAME, GPSContratos.COLUMN_ID);
        Cursor cursor = database.rawQuery(query, null);
        ArrayList<Localizacao> localizacoes = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                double latitude = cursor.getDouble(cursor.getColumnIndex(GPSContratos.COLUMN_LATITUDE));
                double longitude = cursor.getDouble(cursor.getColumnIndex(GPSContratos.COLUMN_LONGITUDE));

                localizacoes.add(0, new Localizacao(latitude, longitude));
            }
        } finally {
            cursor.close();
            database.close();
            helper.close();
        }
        return localizacoes;
    }

    public void inputLocation(Localizacao localizacao) {
        SQLHelper helper = new SQLHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GPSContratos.COLUMN_LATITUDE, localizacao.latitude);
        contentValues.put(GPSContratos.COLUMN_LONGITUDE, localizacao.longitude);
        database.insert(GPSContratos.TABLE_NAME, null, contentValues);
        database.close();
    }
}
