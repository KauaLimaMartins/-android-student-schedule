package com.example.agendaalura.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agendaalura.R;
import com.example.agendaalura.dao.AlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Lista de alunos");

        fabNovoAluno();
    }

    private void fabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_main_fab);

        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        MainActivity.this,
                        FormActivity.class
                ));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        AlunoDAO dao = new AlunoDAO();

        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_alunos);

        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                dao.todosNomes()
        ));

        listaDeAlunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}
