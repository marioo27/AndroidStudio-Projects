package com.example.calculadoranominas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText dias, horas;
    private final double paga = 13.75f;
    private Button btnCalcular, btnBorrar;
    private RadioButton redondeoSi, redondeoNo;

    private CheckBox ckbPago, ckbDescuento;

    private RadioGroup redondeos;

    private TextView pago, descuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //----------------------------------------------------------------------------
        dias = (EditText) findViewById(R.id.editTextTextDias);
        horas = (EditText) findViewById(R.id.editTextTextHoras);
        pago = (TextView) findViewById(R.id.textViewPago);
        descuento = (TextView) findViewById(R.id.textViewDescuento);
        btnBorrar = (Button) findViewById(R.id.buttonBorrar);
        btnCalcular = (Button) findViewById(R.id.buttonCalcular);
        ckbPago = (CheckBox) findViewById(R.id.checkBoxPago);
        ckbDescuento = (CheckBox) findViewById(R.id.checkBoxDescuento);
        redondeos = (RadioGroup) findViewById(R.id.radioGroupRedondeo);
        redondeoSi = (RadioButton) findViewById(R.id.radioButtonRedondeo);
        redondeoNo = (RadioButton) findViewById(R.id.radioButtonDesRedondeo);

        //----------------------------------------------------------------------------
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Borrar();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcular();
            }
        });
    }

    public void Calcular() {

        int numDias = Integer.parseInt(dias.getText().toString());
        int numHoras = Integer.parseInt(horas.getText().toString());
        int horasTotales = numDias * numHoras;
        Double totalPago = horasTotales * paga;

        if(ckbPago.isChecked())
            pago.setText(String.valueOf(totalPago));
        if(ckbDescuento.isChecked())
            descuento.setText(String.valueOf(totalPago * 0.10));

        if (redondeoSi.isChecked()) {
            int pagoRedondeo = (int) Math.round(totalPago);
            pago.setText(String.valueOf(pagoRedondeo));

            int descuentoRedondeo = (int) Math.round(totalPago * 0.10);
            descuento.setText(String.valueOf(descuentoRedondeo));
        }
    }


    public void Borrar() {
        dias.setText("");
        horas.setText("");
        pago.setText("");
        descuento.setText("");
        ckbPago.setChecked(false);
        ckbDescuento.setChecked(false);
        redondeoSi.setChecked(false);
        redondeoNo.setChecked(false);
    }
}