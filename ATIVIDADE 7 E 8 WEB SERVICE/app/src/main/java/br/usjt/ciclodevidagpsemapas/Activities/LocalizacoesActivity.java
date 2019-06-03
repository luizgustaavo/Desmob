package br.usjt.ciclodevidagpsemapas.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;
import br.usjt.ciclodevidagpsemapas.R;
import br.usjt.ciclodevidagpsemapas.Database.LocalizacaoDAO;
import br.usjt.ciclodevidagpsemapas.Model.Localizacao;

public class LocalizacoesActivity extends AppCompatActivity {

    /*
    Aula 07 e 08 - Consumo Web Service
    André Gianfratti
    RA: 817114511
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacoes);

        List<Localizacao> localizacoes = new LocalizacaoDAO(this).resgataLocalizacoes();

        RecyclerView localizacoesRecyclerView = findViewById(R.id.localizacoes_list);
        localizacoesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        localizacoesRecyclerView.setNestedScrollingEnabled(false);
        localizacoesRecyclerView.setAdapter(new LocalizacoesAdapter(localizacoes));
    }
}
