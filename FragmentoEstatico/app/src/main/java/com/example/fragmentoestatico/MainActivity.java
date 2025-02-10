package com.example.fragmentoestatico;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SegundoFragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SegundoFragmento extends Fragment {

    // Parameters for fragment initialization
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private ImageView imageView;

    public SegundoFragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SegundoFragmento.
     */
    public static SegundoFragmento newInstance(String param1, String param2) {
        SegundoFragmento fragment = new SegundoFragmento();
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
        View view = inflater.inflate(R.layout.fragment_segundo_fragmento, container, false);
        imageView = view.findViewById(R.id.imageView);

        // Muestra la imagen por defecto (tutifruti.jpg)
        imageView.setImageResource(R.drawable.tutifruti);

        return view;
    }

    /**
     * Método para actualizar la imagen en el ImageView.
     * @param imageResource El recurso de imagen que se mostrará.
     */
    public void updateImage(int imageResource) {
        if (imageView != null) {
            imageView.setImageResource(imageResource);
        }
    }
    @Override
    public void onItemSelected(int imageResource) {
        SegundoFragmento segundoFragmento = (SegundoFragmento) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_segundo);

        if (segundoFragmento != null) {
            segundoFragmento.updateImage(imageResource);
        }
    }

}
