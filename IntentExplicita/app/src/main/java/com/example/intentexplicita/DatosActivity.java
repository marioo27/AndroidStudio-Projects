package com.example.intentexplicita;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        // Obtener los extras de la Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int n = extras.getInt("numero", 0); // Valor por defecto 0 si el extra no existe
            String s = extras.getString("nombre", "Sin nombre"); // Valor por defecto
            Toast.makeText(this, "Numero: " + n + " y nombre: " + s, Toast.LENGTH_LONG).show();
        }

        // Ajustar márgenes para bordes del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
