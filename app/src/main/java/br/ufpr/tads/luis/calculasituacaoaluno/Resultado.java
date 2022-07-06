package br.ufpr.tads.luis.calculasituacaoaluno;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView tvAluno = findViewById(R.id.textViewAluno);
        TextView tvMediaFinal = findViewById(R.id.textViewMedia);
        TextView tvSituacao = findViewById(R.id.textViewSituacao);

        String nomeAluno = "";
        double media = 0;
        int frequencia = 0;

        //Recebe os parametros enviados pela tela principal
        Intent it = getIntent();
        if (it != null) {
            Bundle params = it.getExtras();
            if (params != null) {
                nomeAluno = params.getString("nomeAluno");
                media = params.getDouble("media");
                frequencia = params.getInt("frequencia");
            }
        }

        String situacao = validaSituacao (media, frequencia);

        tvAluno.setText(nomeAluno);
        tvMediaFinal.setText(String.valueOf(media));
        tvSituacao.setText(situacao);

    }

    //Rotina que retorna uma string indicando a situacao a partir da media Final e da frequencia
    private String validaSituacao (double mediaFinal, int frequencia) {
        if (mediaFinal < 4) {
            return "Reprovado por nota";
        }
        else {
            if (frequencia < 75) {
                return "Reprovado por falta";
            }
            if (mediaFinal >= 7)
                return "Aprovado";
        }
        return "Final";
    }
}
