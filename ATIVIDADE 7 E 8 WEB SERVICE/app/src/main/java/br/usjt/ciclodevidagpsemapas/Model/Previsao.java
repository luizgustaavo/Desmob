package br.usjt.ciclodevidagpsemapas.Model;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Previsao {
    public String diaDaSemana;
    public double umidade;
    public String descricao;
    public double minTemp;
    public double maxTemp;

    public Previsao(long diaSemana,  double umidade, String descricao, double minTemp, double maxTemp) {
        this.diaDaSemana = converteDia(diaSemana);
        this.umidade = umidade;
        this.descricao = descricao;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    @SuppressLint("SimpleDateFormat")
    private static String converteDia (long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time * 1000);
        TimeZone tz = TimeZone.getDefault();
        calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("EEEE").format(calendar.getTime());
    }
}
