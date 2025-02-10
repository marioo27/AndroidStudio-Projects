package com.example.intentexplicita;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonDatosAct = findViewById(R.id.buttonDatosAct);
        buttonDatosAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatosActivity.class);
                intent.putExtra("numero", 123); // Cambiar valor según sea necesario
                intent.putExtra("nombre", "Mario"); // Cambiar valor según sea necesario
                startActivity(intent);
            }
        });
    }
}
