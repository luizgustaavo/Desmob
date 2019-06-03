package br.usjt.ciclodevidagpsemapas.Database;

class GPSContratos {
    static final String TABLE_NAME = "localizacoes";

    static final String COLUMN_ID = "id";
    static final String COLUMN_LATITUDE = "latitude";
    static final String COLUMN_LONGITUDE = "longitude";

    static String criarTabela() {

        return String.format(" CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s DOUBLE, %s DOUBLE);",
                    GPSContratos.COLUMN_ID,
                    GPSContratos.TABLE_NAME,
                    GPSContratos.COLUMN_LATITUDE,
                    GPSContratos.COLUMN_LONGITUDE
                );
    }

    static String removerTabela() {
        return String.format("DROP TABLE %s IF EXISTS",
                GPSContratos.TABLE_NAME
                );
    }
}
