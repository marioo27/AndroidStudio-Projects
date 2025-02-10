package com.example.fragmentosdinamicos;

import static com.example.fragmentosdinamicos.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

 FragmentTransaction transaction;
 Fragment fragmentInicio, fragmentRojo, fragmentVerde;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fragmentInicio = new FragmentoInicio();
        fragmentRojo = new FragmentoRojo();
        fragmentVerde = new FragmentoVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragmentos, fragmentInicio).commit();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClick (View view){
        transaction=getSupportFragmentManager().beginTransaction();

        if(view.getId() == id.btnRojo){
            transaction.replace(id.contenedorFragmentos, fragmentRojo);
            transaction.addToBackStack(null);
        }
        else if(view.getId() == id.btnVerde){
            transaction.replace(id.contenedorFragmentos, fragmentVerde);
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}