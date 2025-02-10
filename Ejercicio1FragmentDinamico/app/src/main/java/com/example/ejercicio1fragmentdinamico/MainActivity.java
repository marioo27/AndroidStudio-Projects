package com.example.ejercicio1fragmentdinamico;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    FragmentoSuperior fragmentoSuperior;
    FragmentoInferior fragmentoInferior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos los fragments
        fragmentoSuperior = new FragmentoSuperior();
        fragmentoInferior = new FragmentoInferior();

        // Añadimos el fragmento superior
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedorSuperior, fragmentoSuperior)
                .commit();

        // Añadimos el fragmento inferior
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedorInferior, fragmentoInferior)
                .commit();
    }

    // Método para cambiar la imagen en el fragmento inferior y añadir a la Back Stack
    public void mostrarImagen(int idImagen) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Reemplazamos el fragmento inferior con una nueva instancia para actualizar la imagen
        FragmentoInferior nuevoFragmentoInferior = FragmentoInferior.newInstance(idImagen);
        transaction.replace(R.id.contenedorInferior, nuevoFragmentoInferior);

        // Añadimos la transacción a la Back Stack
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
