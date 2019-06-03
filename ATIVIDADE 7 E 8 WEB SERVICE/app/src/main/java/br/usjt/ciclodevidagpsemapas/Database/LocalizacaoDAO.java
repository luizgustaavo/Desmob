package br.usjt.ciclodevidagpsemapas.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.usjt.ciclodevidagpsemapas.Model.Localizacao;
import br.usjt.ciclodevidagpsemapas.Model.Previsao;

public class LocalizacaoDAO {

    /*
    Aula 07 e 08 - Consumo Web Service
    André Gianfratti
    RA: 817114511
    */


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
                long diaDaSemana = cursor.getLong(cursor.getColumnIndex(GPSContratos.COLUMN_DIA_DA_SEMANA));
                double umidade = cursor.getDouble(cursor.getColumnIndex(GPSContratos.COLUMN_UMIDADE));
                String descricao = cursor.getString(cursor.getColumnIndex(GPSContratos.COLUMN_DESCRICAO));
                double minTemp = cursor.getDouble(cursor.getColumnIndex(GPSContratos.COLUMN_MIN_TEMP));
                double maxTemp = cursor.getDouble(cursor.getColumnIndex(GPSContratos.COLUMN_MAX_TEMP));


                localizacoes.add(0, new Localizacao(latitude, longitude, new Previsao(diaDaSemana, umidade, descricao, minTemp, maxTemp)));
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
        contentValues.put(GPSContratos.COLUMN_DIA_DA_SEMANA, localizacao.previsao.diaDaSemana);
        contentValues.put(GPSContratos.COLUMN_UMIDADE, localizacao.previsao.umidade);
        contentValues.put(GPSContratos.COLUMN_DESCRICAO, localizacao.previsao.descricao);
        contentValues.put(GPSContratos.COLUMN_MIN_TEMP, localizacao.previsao.minTemp);
        contentValues.put(GPSContratos.COLUMN_MAX_TEMP, localizacao.previsao.maxTemp);
        database.insert(GPSContratos.TABLE_NAME, null, contentValues);
        database.close();
    }
}
