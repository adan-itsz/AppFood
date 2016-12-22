package com.example.adan.aplicacioncomida;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class formulario_platillo extends AppCompatActivity {

    private String APP_DIRECTORY = "myPictureApp/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";

    private final int PHOTO_CODE = 100;
    private final int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_platillo);
        //se agrega el boton de retorno al activity padre
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button buttonPicture = (Button) findViewById(R.id.button2);

        buttonPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CharSequence[] options = {"Tomar foto", "Elegir de galeria", "Cancelar"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(formulario_platillo.this);
                builder.setTitle("Elige una opcion");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int seleccion) {
                        if(options[seleccion] == "Tomar foto"){
                            openCamara();
                        }
                        else if (options[seleccion] == "Elegir de galeria"){
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("imagen/*");
                            startActivityForResult(intent.createChooser(intent,"Selecciona app de imagen"),SELECT_PICTURE);
                        }
                        else if (options[seleccion]=="Cancelar"){
                            dialog.dismiss();
                        }

                    }
                });

            }
        });


    }

    private void openCamara(){
        File file = new File(Environment.get)
    }
}
