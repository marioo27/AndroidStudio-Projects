package com.example.creacionmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.menu_activity, mimenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();

        // Gestionar las opciones del menú
        if (id == R.id.Opcion_menu_1) {
            Toast.makeText(this, "Madrid: San Sebastián de los Reyes, Alcobendas, Tres Cantos", Toast.LENGTH_LONG).show();
        } else if (id == R.id.Opcion_menu_2) {
            // Si seleccionan Cataluña, mostrar las provincias
        } else if (id == R.id.provincia_bcn) {
            // Mostrar las poblaciones de Barcelona
            Toast.makeText(this, "Barcelona: Barcelona, L'Hospitalet de Llobregat, Badalona", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_gir) {
            // Mostrar las poblaciones de Girona
            Toast.makeText(this, "Girona: Girona, Figueres, Blanes", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_tar) {
            // Mostrar las poblaciones de Tarragona
            Toast.makeText(this, "Tarragona: Tarragona, Reus, Salou", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_lle) {
            // Mostrar las poblaciones de Lleida
            Toast.makeText(this, "Lleida: Lleida, Balaguer, Cervera", Toast.LENGTH_LONG).show();
        } else if (id == R.id.Opcion_menu_3) {
            // Si seleccionan Aragón, mostrar las provincias
        } else if (id == R.id.provincia_zar) {
            // Mostrar las poblaciones de Zaragoza
            Toast.makeText(this, "Zaragoza: Zaragoza, Ejea de los Caballeros, Calatayud", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_hue) {
            // Mostrar las poblaciones de Huesca
            Toast.makeText(this, "Huesca: Huesca, Jaca, Sabiñánigo", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_ter) {
            // Mostrar las poblaciones de Teruel
            Toast.makeText(this, "Teruel: Teruel, Alcañiz, Orihuela del Tremedal", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(opcion_menu);
    }
}
