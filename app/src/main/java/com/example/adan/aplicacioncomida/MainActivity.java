package com.example.adan.aplicacioncomida;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener,GoogleApiClient.OnConnectionFailedListener {
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private GoogleApiClient mGoogleApiClient;
    private String mUsername;
    private String mPhotoUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, login.class));
            finish();
            return;
        } else {
            mUsername = mFirebaseUser.getDisplayName();
            if (mFirebaseUser.getPhotoUrl() != null) {
                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button boton = (Button)findViewById(R.id.button);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//se agrega imagen al nav view
        ImageView img = (ImageView) findViewById(R.id.imageView);
        TextView txtnombre = (TextView)findViewById(R.id.txtNombre);
        URL imageUrl = null;
        HttpURLConnection conn = null;

        try {

            imageUrl = new URL(mPhotoUrl);
            conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            Bitmap imagen = BitmapFactory.decodeStream(conn.getInputStream());
            img.setImageBitmap(imagen);

        } catch (IOException e) {

            e.printStackTrace();

        }

        txtnombre.setText(mUsername);




    }

    public void onClick(View view){
    Log.d("a","si entro------------------------");

        switch(view.getId()){

            case R.id.button:

                Intent i =new Intent(getApplicationContext(),formulario_platillo.class);
                startActivity(i);
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) { //funciona como escuchas de java
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.perfil) { //r.id.perfil indica el id del item en el menu del drawer

            Intent intent = new Intent(getApplicationContext(),ActivityPerfil.class);
            startActivity(intent);

        } else if (id == R.id.ventas) {

            Intent intent = new Intent(getApplicationContext(),ActivityVentas.class);
            startActivity(intent);

        } else if (id == R.id.compras) {


            Intent intent = new Intent(getApplicationContext(),ActivityCompras.class);
            startActivity(intent);

        } else if (id == R.id.platillos) {
            Intent intent = new Intent(getApplicationContext(),ActivityPlatillos.class);
            startActivity(intent);

        } else if (id == R.id.chat) {
            Intent intent = new Intent(getApplicationContext(),ActivityChat.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("Main", "onConnectionFailed:" + connectionResult);
    }
}
