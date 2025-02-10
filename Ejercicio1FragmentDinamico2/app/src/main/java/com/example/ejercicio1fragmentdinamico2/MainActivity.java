package com.example.ejercicio1fragmentdinamico2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button btnManzanas, btnPeras, btnPlatanos;
    FragmentTransaction transaction;
    Fragment Superior, Inferior;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Superior = new Superior();
        Inferior = new Inferior();

        Superior superiorFragment = (Superior) Superior;
        Inferior inferiorFragment = (Inferior) Inferior;

        btnManzanas = superiorFragment.getBtnManzanas();
        btnPeras = superiorFragment.getBtnPeras();
        btnPlatanos = superiorFragment.getBtnPlatanos();

        imageView = inferiorFragment.getImageView();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();

        if (view.getId() == R.id.btnManzanas) {
            imageView.setImageResource(R.drawable.manzana);
        }
        else if (view.getId() == R.id.btnPeras) {
            imageView.setImageResource(R.drawable.pera);
        }
        else if (view.getId() == R.id.btnPlatanos) {
            imageView.setImageResource(R.drawable.platano);
        }

        transaction.commit();
    }



}