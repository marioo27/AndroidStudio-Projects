package com.example.ejercicio1fragmentdinamico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FragmentoSuperior extends Fragment {

    public FragmentoSuperior() {
        // Constructor vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_superior, container, false);

        Button btnManzana = view.findViewById(R.id.btnManzana);
        Button btnPera = view.findViewById(R.id.btnPera);
        Button btnPlatano = view.findViewById(R.id.btnPlatano);

        btnManzana.setOnClickListener(v -> enviarImagen(R.drawable.manzana));
        btnPera.setOnClickListener(v -> enviarImagen(R.drawable.pera));
        btnPlatano.setOnClickListener(v -> enviarImagen(R.drawable.platano));

        return view;
    }

    private void enviarImagen(int idImagen) {
        ((MainActivity) getActivity()).mostrarImagen(idImagen);
    }
}
