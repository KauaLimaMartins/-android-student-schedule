package com.example.agendaalura.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agendaalura.R;
import com.example.agendaalura.dao.AlunoDAO;
import com.example.agendaalura.model.Aluno;

public class FormActivity extends AppCompatActivity {
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        setTitle("Novo aluno");

        inicializacaoDosCampos();

        Button botaoSalvar = findViewById(R.id.activity_form_botao);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarAluno();

                finish();
            }
        });
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_form_nome);
        campoEmail = findViewById(R.id.activity_form_nome);
        campoTelefone = findViewById(R.id.activity_form_nome);
    }

    private void criarAluno() {
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String telefone = campoTelefone.getText().toString();

        final AlunoDAO dao = new AlunoDAO();

        Aluno alunoCriado = new Aluno(nome, email, telefone);

        dao.salva(alunoCriado);
    }
}