import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculonominasbasico.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etDias = findViewById<EditText>(R.id.etDias)
        val etHoras = findViewById<EditText>(R.id.etHoras)
        val tvPago = findViewById<TextView>(R.id.tvPago)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)

        // Botón para calcular el pago
        btnCalcular.setOnClickListener {
            val dias = etDias.text.toString().toIntOrNull() ?: 0
            val horas = etHoras.text.toString().toIntOrNull() ?: 0
            val pago = dias * horas * 10 // Cálculo simple: 10 es la tarifa por hora
            tvPago.text = "Pago: $pago€"
        }

        // Botón para borrar los campos
        btnBorrar.setOnClickListener {
            etDias.text.clear()
            etHoras.text.clear()
            tvPago.text = "Pago"
        }
    }
}
