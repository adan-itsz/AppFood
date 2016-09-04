package com.example.adan.aplicacioncomida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityPlatillos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_platillos);
        //se agrega el boton de retorno al activity padre
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
