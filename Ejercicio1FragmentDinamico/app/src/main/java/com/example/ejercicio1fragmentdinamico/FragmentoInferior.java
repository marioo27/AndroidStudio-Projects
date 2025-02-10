package com.example.ejercicio1fragmentdinamico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class FragmentoInferior extends Fragment {

    private static final String ARG_IMAGE_ID = "image_id";
    private int idImagen;

    public FragmentoInferior() {
        // Constructor vacío
    }

    // Factory method para crear una nueva instancia del fragmento
    public static FragmentoInferior newInstance(int imageId) {
        FragmentoInferior fragment = new FragmentoInferior();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_ID, imageId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inferior, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);

        if (getArguments() != null) {
            idImagen = getArguments().getInt(ARG_IMAGE_ID);
            imageView.setImageResource(idImagen);
        }

        return view;
    }
}
