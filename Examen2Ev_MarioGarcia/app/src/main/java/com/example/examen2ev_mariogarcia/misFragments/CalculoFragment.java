package com.example.examen2ev_mariogarcia.misFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.examen2ev_mariogarcia.R;

public class CalculoFragment extends Fragment {

    private EditText num1, num2, num3;

    private Button btnSuma, btnResta, btnMult, btnMedia;
    private TextView tvResultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculo, container, false);

        num1 = view.findViewById(R.id.etNum1);
        num2 = view.findViewById(R.id.etNum2);
        num3 = view.findViewById(R.id.etNum3);

        btnSuma = view.findViewById(R.id.btnSuma);
        btnResta = view.findViewById(R.id.btnResta);
        btnMult = view.findViewById(R.id.btnMultiplicacion);
        btnMedia = view.findViewById(R.id.btnMedia);

        tvResultado = view.findViewById(R.id.tvResultado);


        btnSuma.setOnClickListener(v -> operar(0));
        btnResta.setOnClickListener(v -> operar(1));
        btnMult.setOnClickListener(v -> operar(2));
        btnMedia.setOnClickListener(v -> operar(3));

        return view;
    }

    private void operar(int op) {

            double num1 = Double.parseDouble(this.num1.getText().toString());
            double num2 = Double.parseDouble(this.num2.getText().toString());
            double num3 = Double.parseDouble(this.num3.getText().toString());

            double resultado = 0.00;

            switch (op){
                case(0):{
                    resultado = (num1 + num2 + num3); //Suma
                    break;
                }
                case(1):{
                    resultado = (num1 - num2 - num3); //Resta
                    break;
                }
                case(2):{
                    resultado = (num1 * num2 * num3); //Multiplicacion
                    break;
                }
                case(3):{
                    resultado = (num1 + num2 + num3)/3; //Media
                    break;
                }
            }

        tvResultado.setText(String.format("Media: %.2f", resultado));
    }


}
