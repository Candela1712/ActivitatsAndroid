
package com.candelaortuno.act_03

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.util.Locale

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        val bmi = intent.getDoubleExtra("BMI", 0.0)

        val tvCategoria = findViewById<TextView>(R.id.tvCategoria)
        val tvBmi = findViewById<TextView>(R.id.tvBmi)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcion)

        val categoria: String
        val color: String
        val descripcion: String

        when {
            bmi < 18.5 -> {
                categoria = "UNDERWEIGHT"
                color = "#FFC107"
                descripcion = "Your body weight is lower than normal."
            }
            bmi < 25.0 -> {
                categoria = "NORMAL"
                color = "#24D876"
                descripcion = "You have a normal body weight. Good job!"
            }
            bmi < 30.0 -> {
                categoria = "OVERWEIGHT"
                color = "#FF9800"
                descripcion = "Your body weight is higher than normal."
            }
            else -> {
                categoria = "OBESE"
                color = "#F44336"
                descripcion = "Your body weight is well above normal."
            }
        }

        tvCategoria.text = categoria
        tvCategoria.setTextColor(Color.parseColor(color))
        tvBmi.text = String.format(Locale.US, "%.2f", bmi)
        tvDescripcion.text = descripcion

        findViewById<MaterialButton>(R.id.btnRecalcular).setOnClickListener { finish() }
    }
}
 




