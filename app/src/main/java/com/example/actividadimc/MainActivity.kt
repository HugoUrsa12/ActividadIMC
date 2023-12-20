package com.example.actividadimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextWeight: EditText = findViewById(R.id.kg)
        val editTextHeight: EditText = findViewById(R.id.m)
        val buttonCalculate: Button = findViewById(R.id.calcular)
        val textViewResult: TextView = findViewById(R.id.respuesta)

        // Establecer el Listener onFocusChange para borrar el texto al obtener el foco
        editTextWeight.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editTextWeight.text.clear()
            }
        }

        editTextHeight.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editTextHeight.text.clear()
            }
        }

        buttonCalculate.setOnClickListener {
            val weightString: String = editTextWeight.text.toString()
            val heightString: String = editTextHeight.text.toString()

            if (weightString.isNotEmpty() && heightString.isNotEmpty()) {
                val weight: Float = weightString.toFloat()
                val height: Float = heightString.toFloat()

                val bmi: Float = calculateBMI(weight, height)
                textViewResult.text = "Tu IMC es: $bmi"
            } else {
                textViewResult.text = "Por favor, introduce peso y altura"
            }
        }
    }

    private fun calculateBMI(weight: Float, height: Float): Float {
        return weight / (height * height)
    }
}