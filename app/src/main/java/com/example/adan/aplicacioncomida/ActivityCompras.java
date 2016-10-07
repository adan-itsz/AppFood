package com.example.adan.aplicacioncomida;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.Toast;

public class ActivityCompras extends AppCompatActivity {

    //Se declaran los arreglos de Strings que se mostraran en la lista asi como las imagenes

    //Nombre del platillo
    private String NombrePlatillo[]=new String[]{"Pollo asado","Carne asada","pescado con ensalda",
            "ensalada de papas"};
    //Nombre del cocinero
    private String NombreCocinero[] = new String[]{"Pepe Gonzalez","Pedro Martinez","Fulanito Macias","Julio Perez"};
    //Fecha que se realizo la compra
    private String FechaCompra[]=new String[]{"24/nov/2016","12/ene/2016","28/abr/2016",
            "27/feb/2016"};
    //Precio
    private String PrecioCompra[]= new String[]{"25","43","60","55"};
    //imagen del platillo
    private Integer[] imgid={
            R.drawable.descarga,
            R.drawable.images,
            R.drawable.platillos02,
            R.drawable.platillo01

    };
    //se declara lista
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_compras);

        ComprasListAdapter adapter=new ComprasListAdapter(this,NombrePlatillo,NombreCocinero,FechaCompra,PrecioCompra,imgid);
        lista=(ListView)findViewById(R.id.listCompras);
        lista.setAdapter(adapter);

        //se agrega el boton de retorno al activity padre
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }







}



