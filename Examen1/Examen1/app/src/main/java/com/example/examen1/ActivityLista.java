package com.example.examen1;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;

import java.util.ArrayList;
import java.util.List;

public class ActivityLista {

    private ListView listViewElemento;
    private List<Elemento> listaElementos;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        listViewElemento = (ListView) findViewById(R.id.listViewElemento);
        listaElementos = new ArrayList<>();
        listaElementos.add(new Elemento("Título Ejemplo 1", "Subtitulo Ejemplo 1", "", 1));
        listaElementos.add(new Elemento("Título Ejemplo 1", "Subtitulo Ejemplo 1", "", 1));

        MiAdaptador adaptadorEjemplo = new MiAdaptador(this, R.layout.elemento_item, listaElementos);
        listViewElemento.setAdapter(adaptadorEjemplo);
    }*/

}
