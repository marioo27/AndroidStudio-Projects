package com.example.examen2ev_mariogarcia.misFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.examen2ev_mariogarcia.Contacto;
import com.example.examen2ev_mariogarcia.ContactAdapter;
import com.example.examen2ev_mariogarcia.R;

import java.util.ArrayList;
import java.util.List;

public class ListaContactosFragment extends Fragment {

    private GridView gridViewContacts;

    public ListaContactosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lista_contactos, container, false);

        gridViewContacts = root.findViewById(R.id.gridViewContacts);

        List<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.ic_person, "Mario García", "123-456-7890", "mario@mejoralumno"));
        contactos.add(new Contacto(R.drawable.ic_person2, "Cristiano Ronaldo", "000-000-0000", "cris@suuu.com"));
        contactos.add(new Contacto(R.drawable.ic_person2, "Madison Beer", "666-666-6666", "maddy@check.com"));
        contactos.add(new Contacto(R.drawable.ic_person, "Laura Sacristán", "111-111-1111", "laura@profe.com"));
        contactos.add(new Contacto(R.drawable.ic_conejito, "Conejo Blanco", "000-000-0001", "conejo@blanco.us"));
        contactos.add(new Contacto(R.drawable.ic_robot, "Elon Musk", "898-989-9988", "elon@marte.us"));
        contactos.add(new Contacto(R.drawable.ic_raton, "Ratita Presumida", "999-999-9999", "ratita@presumida.es"));
        contactos.add(new Contacto(R.drawable.ic_person, "Papa Francisco", "777-777-7777", "fran@papa.vat"));

        ContactAdapter adapter = new ContactAdapter(getContext(), contactos);
        gridViewContacts.setAdapter(adapter);

        gridViewContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto clickedContacto = contactos.get(position);

                Toast.makeText(getContext(), "Has pulsado el contacto: " + clickedContacto.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}
