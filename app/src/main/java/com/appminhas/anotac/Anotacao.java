package com.appminhas.anotac;

import android.content.Context;
import android.content.SharedPreferences;

public class Anotacao {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQ = "anotações.preferencias";
    private final String CHAVE_NOME = "nome";

    public Anotacao(Context context){
        this.context = context;

        sharedPreferences = context.getSharedPreferences( NOME_ARQ , 0 );
        editor = sharedPreferences.edit();

    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public String recuperarAnotacao(){
        return sharedPreferences.getString(CHAVE_NOME, "");
    }

}
