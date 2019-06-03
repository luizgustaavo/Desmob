package br.usjt.ciclodevidagpsemapas.Model;

import java.io.Serializable;

public class Localizacao implements Serializable {
    public double latitude;
    public double longitude;
    public Previsao previsao;

    public Localizacao(double latitude, double longitude , Previsao previsao) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.previsao = previsao;
    }
}
