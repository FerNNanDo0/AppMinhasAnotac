package com.appminhas.anotac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private String strText;
    private Anotacao anotacaoPreferencias;
    private FloatingActionButton floatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        floatButton = findViewById(R.id.floatingActionButton);

        if (getSupportActionBar() != null){
            getSupportActionBar().setElevation(0);
        }

        anotacaoPreferencias = new Anotacao(getApplicationContext());

        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strText = editText.getText().toString();

                if ( strText.isEmpty() ){
                    Snackbar.make(view, " Preencha as anotações! ", Snackbar.LENGTH_LONG).show();

                }else{
                    anotacaoPreferencias.salvarAnotacao( strText );
                    Snackbar.make(view, " anotação salva com sucesso! ", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        String anotacao = anotacaoPreferencias.recuperarAnotacao();
        if ( !anotacao.isEmpty() ){
            editText.setText( anotacao );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_settings){
            editText.setText("");
            anotacaoPreferencias.salvarAnotacao("");
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}