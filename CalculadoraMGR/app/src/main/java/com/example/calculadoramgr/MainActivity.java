package com.example.calculadoramgr;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNum1, editTextNum2;
    private Button buttonSuma, buttonResta, buttonMult, buttonDiv, buttonBorrar;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        buttonSuma = findViewById(R.id.buttonSuma);
        buttonResta = findViewById(R.id.buttonResta);
        buttonMult = findViewById(R.id.buttonMultiplicacion);
        buttonDiv = findViewById(R.id.buttonDivision);
        buttonBorrar = findViewById(R.id.buttonBorrar);
        textViewResultado = findViewById(R.id.textViewResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraintLayoutMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        configurarListeners();
    }

    private void configurarListeners() {
        buttonSuma.setOnClickListener(v -> realizarOperacion("+"));
        buttonResta.setOnClickListener(v -> realizarOperacion("-"));
        buttonMult.setOnClickListener(v -> realizarOperacion("*"));
        buttonDiv.setOnClickListener(v -> realizarOperacion("/"));
        buttonBorrar.setOnClickListener(v -> borrarDatos());
    }

    private void realizarOperacion(String operador) {
        double[] numeros = recogerDatos();
        if (numeros != null) {
            double resultado = 0;

            switch (operador) {
                case "+":
                    resultado = numeros[0] + numeros[1];
                    break;
                case "-":
                    resultado = numeros[0] - numeros[1];
                    break;
                case "*":
                    resultado = numeros[0] * numeros[1];
                    break;
                case "/":
                    if (numeros[1] != 0) {
                        resultado = numeros[0] / numeros[1];
                    } else {
                        Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }
            textViewResultado.setText(String.valueOf(resultado));
        }
    }

    private double[] recogerDatos() {
        try {
            double num1 = Double.parseDouble(editTextNum1.getText().toString());
            double num2 = Double.parseDouble(editTextNum2.getText().toString());
            return new double[]{num1, num2};
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    private void borrarDatos() {
        editTextNum1.setText("");
        editTextNum2.setText("");
        textViewResultado.setText("");
    }}