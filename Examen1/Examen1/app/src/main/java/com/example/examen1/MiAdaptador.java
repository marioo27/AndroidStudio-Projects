package com.example.examen1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptador extends ArrayAdapter<Elemento> {

    Context ctx;
    int layoutTemplate;
    List<Elemento> elementoList;

    public MiAdaptador(@NonNull Context context, int resource, @NonNull List<Elemento> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.elementoList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent,false);
        //Obtener la informacion del elemento de la lista
        Elemento elementoActual = elementoList.get(position);
        //Rescatar los elementos  de la interfaz de usuario de la template
        TextView textViewTitulo = (TextView) v.findViewById(R.id.textViewTitulo);
        TextView textViewSubtitulo = (TextView) v.findViewById(R.id.textViewSubtitulo);

        //Hacer un set de la informacion del elementoActual en los elementos de la interfaz del usuario.
        textViewTitulo.setText(elementoActual.getTitulo());
        textViewSubtitulo.setText(elementoActual.getSubtitulo());

        return v;
    }
}