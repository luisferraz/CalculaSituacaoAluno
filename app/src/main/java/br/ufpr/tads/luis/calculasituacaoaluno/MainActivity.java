package br.ufpr.tads.luis.calculasituacaoaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculaSituacao(View view) {
        EditText etNomeAluno = (EditText) findViewById(R.id.editTextNomeAluno);
        EditText etNota1 = (EditText) findViewById(R.id.editTextNota1);
        EditText etNota2 = (EditText) findViewById(R.id.editTextNota2);
        EditText etFrequencia = (EditText) findViewById(R.id.editTextFrequencia);

        if (etNomeAluno.length() == 0) {
            Toast.makeText(this, "Informe o nome do Aluno!", Toast.LENGTH_SHORT).show();
            return;
        }

        if ((etNota1.length() == 0) || (etNota2.length() == 0)) {
            Toast.makeText(this, "Informe as notas do Aluno!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (etFrequencia.length() == 0) {
            Toast.makeText(this, "Informe a frequência do Aluno!", Toast.LENGTH_SHORT).show();
            return;
        }
        String nomeAluno = etNomeAluno.getText().toString();
        double nota1, nota2;
        int frequencia;

        try {
            nota1 = Double.parseDouble(etNota1.getText().toString());
            nota2 = Double.parseDouble(etNota2.getText().toString());
            frequencia = Integer.parseInt(etFrequencia.getText().toString());
        } catch (NumberFormatException e){
            Toast.makeText(this, "Dados informados inválidos!", Toast.LENGTH_SHORT).show();
            return;
        }

        //Calcula a média
        double media = (nota1 + nota2) / 2;

        //Atribui a media, o nome do Aluno e a frequencia para um bundle
        Bundle params = new Bundle();
        params.putString("nomeAluno", nomeAluno);
        params.putInt("frequencia", frequencia);
        params.putDouble("media", media);

        //Cria um intent e atribui o bundle a ele
        Intent it = new Intent(this, Resultado.class);
        it.putExtras(params);

        //Invoca a activity de resultado
        startActivity(it);


    }

}