package com.example.examenmariogarcia;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       // textView = findViewById(R.id.textView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

  /*  @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuOption) {

        int id = menuOption.getItemId();

        if (id == R.id.optionCalculo){
            textView.setText("hola");
        }if (id == R.id.optionAlarma){
            textView.setText("hola2");
        }if (id == R.id.optionMenu){
            textView.setText("hola3");
        }if (id == R.id.optionAcercaDe){
            textView.setText("hola4");
        }

        return true;
    }*/

}