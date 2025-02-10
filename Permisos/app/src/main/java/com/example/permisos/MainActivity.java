package com.example.permisos;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.widget.Toast;

import androidx.activity.EdgeToEdge;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.Manifest;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final int CODIGO_RESPUESTA= 200;


    @RequiresApi(api= Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        verificarPermisos();
    }

  /*  @RequiresApi(api= Build.VERSION_CODES.M)
    private void verificarPermisos() throws InterruptedException {
        int permisoSms = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
       // int permisoAlmac = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permisoInternet = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        int permisoContact = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        int permisoUbi = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);


        if(permisoSms == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(this, "Permiso de SMS Concedido", Toast.LENGTH_SHORT).show();
        else
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, COD_SMS);

        if(permisoAlmac == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(this, "Permiso Almacenamiento Concedido", Toast.LENGTH_SHORT).show();
        else
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, COD_ALMAC);


        Thread.sleep(3000);

        if(permisoInternet == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(this, "Permiso De Internet Concedido", Toast.LENGTH_SHORT).show();
        else
            requestPermissions(new String[]{Manifest.permission.INTERNET}, COD_INTERNET);

        Thread.sleep(3000);

        if(permisoContact == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(this, "Permiso De Contactos Concedido", Toast.LENGTH_SHORT).show();
        else
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, COD_CONTACT);

        Thread.sleep(3000);

        if(permisoUbi == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(this, "Permiso De Ubicación Concedido", Toast.LENGTH_SHORT).show();
        else
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, COD_UBI);


    }*/
  @RequiresApi(api = Build.VERSION_CODES.M)
  private void verificarPermisos() {
      List<String> permisos = new ArrayList<>();
      permisos.add(Manifest.permission.ACCESS_COARSE_LOCATION);
      permisos.add(Manifest.permission.ACCESS_FINE_LOCATION);
      permisos.add(Manifest.permission.READ_CONTACTS);
      permisos.add(Manifest.permission.SEND_SMS);
      permisos.add(Manifest.permission.READ_EXTERNAL_STORAGE);
      permisos.add(Manifest.permission.INTERNET);


      List<String> request = new ArrayList<>();

      for (String permiso : permisos) {
          if (ContextCompat.checkSelfPermission(this,permiso) == PackageManager.PERMISSION_GRANTED){
              Toast.makeText(this,permiso.toString()+" CONCEDIDO", Toast.LENGTH_SHORT).show();
          } else {
              request.add(permiso);
          }
      }
      if (!request.isEmpty()) {
          requestPermissions(request.toArray(new String[0]), CODIGO_RESPUESTA);
      }
  }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CODIGO_RESPUESTA){
            if (grantResults.length > 0){
                boolean permisosConcedidos = true;
                for (int result : grantResults){
                    if (result != PackageManager.PERMISSION_GRANTED){
                        permisosConcedidos = false;
                        break;
                    }
                }
                if (permisosConcedidos) {
                    Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permisos necesarios para funcionar", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


}