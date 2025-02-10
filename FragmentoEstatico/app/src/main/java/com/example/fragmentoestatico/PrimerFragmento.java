package com.example.fragmentoestatico;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrimerFragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrimerFragmento extends Fragment {

    // Parameters for fragment initialization
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public interface OnItemSelectedListener {
        void onItemSelected(int imageResource);
    }

    private OnItemSelectedListener listener;

    public PrimerFragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PrimerFragmento.
     */
    public static PrimerFragmento newInstance(String param1, String param2) {
        PrimerFragmento fragment = new PrimerFragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primer_fragmento, container, false);

        // Set up ListView
        ListView listView = view.findViewById(R.id.listView);
        String[] frutas = {"Manzana", "Pera", "Platano"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item_fruit, frutas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            int[] images = {R.drawable.manzana, R.drawable.pera, R.drawable.platano};
            if (listener != null) listener.onItemSelected(images[position]);
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        }
    }
}
