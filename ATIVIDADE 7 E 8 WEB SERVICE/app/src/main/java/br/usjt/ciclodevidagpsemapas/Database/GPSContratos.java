package br.usjt.ciclodevidagpsemapas.Database;

class GPSContratos {

    /*
    Aula 07 e 08 - Consumo Web Service
    André Gianfratti
    RA: 817114511
    */

    static final String TABLE_NAME = "localizacoes";

    static final String COLUMN_ID = "id";
    static final String COLUMN_LATITUDE = "latitude";
    static final String COLUMN_LONGITUDE = "longitude";
    static final String COLUMN_DIA_DA_SEMANA = "diaDaSemana";
    static final String COLUMN_UMIDADE= "umidade";
    static final String COLUMN_DESCRICAO= "descricao";
    static final String COLUMN_MIN_TEMP = "min_temp";
    static final String COLUMN_MAX_TEMP = "max_temp";

    static String criarTabela() {

        return String.format(" CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s DOUBLE, %s DOUBLE," +
                        "%s INTEGER, %s DOUBLE, %s TEXT, %s DOUBLE, %s DOUBLE );",
                    GPSContratos.COLUMN_ID,
                    GPSContratos.TABLE_NAME,
                    GPSContratos.COLUMN_LATITUDE,
                    GPSContratos.COLUMN_LONGITUDE,
                    GPSContratos.COLUMN_DIA_DA_SEMANA,
                    GPSContratos.COLUMN_UMIDADE,
                    GPSContratos.COLUMN_DESCRICAO,
                    GPSContratos.COLUMN_MIN_TEMP,
                    GPSContratos.COLUMN_MAX_TEMP
                );
    }

    static String removerTabela() {
        return String.format("DROP TABLE %s IF EXISTS",
                GPSContratos.TABLE_NAME
                );
    }
}
