package com.example.adan.aplicacioncomida;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by emmanuelgarcia on 06/10/16.
 */

public class ComprasListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final String[] cocineroname;
    private final String[] fechacompra;
    private final String[] preciocompra;
    private final Integer[] integers;


    public ComprasListAdapter(Activity context, String[] itemname,String[] cocineroname,String[] fechacompra,String[] preciocompra, Integer[] integers) {
        super(context, R.layout.item_genericos, itemname);

        this.context=context;
        this.itemname=itemname;
        this.cocineroname = cocineroname;
        this.fechacompra = fechacompra;
        this.preciocompra = preciocompra;
        this.integers=integers;

    }

    public View getView(int posicion, View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_genericos,null,true);
        //crea los objetos con los datos necesarios: imagen,nombre del platillo, nombre cocinero, fecha y precio
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtNombrePlatillo);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView etxDescripcion = (TextView) rowView.findViewById(R.id.txtNombrePersona);
        TextView txtFecha= (TextView) rowView.findViewById(R.id.txtFecha);
        TextView txtPrecio=(TextView) rowView.findViewById(R.id.txtPrecio);

        //sustituye los antiguos TextView por los nuevos ya con los valores necesarios
        txtTitle.setText(itemname[posicion]);
        imageView.setImageResource(integers[posicion]);
        etxDescripcion.setText("cocinero :"+cocineroname[posicion]);
        txtFecha.setText("Fecha de compra : "+fechacompra[posicion]);
        txtPrecio.setText("$"+preciocompra[posicion]);

        return rowView;
    }


}
