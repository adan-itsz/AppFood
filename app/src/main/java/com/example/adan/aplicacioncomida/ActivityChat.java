package com.example.adan.aplicacioncomida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityChat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_chat);
        //se agrega el boton de retorno al activity padre
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
