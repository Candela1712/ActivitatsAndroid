package com.candelaortuno.act_03

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    private var altura = 73
    private var peso = 170
    private var edad = 18

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvAltura: TextView
    private lateinit var tvPeso: TextView
    private lateinit var tvEdad: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvAltura = findViewById(R.id.tvAltura)
        tvPeso = findViewById(R.id.tvPeso)
        tvEdad = findViewById(R.id.tvEdad)

        viewMale.setOnClickListener { seleccionarGenero(hombre = true) }
        viewFemale.setOnClickListener { seleccionarGenero(hombre = false) }

        val barraAltura = findViewById<Slider>(R.id.barraAltura)
        barraAltura.addOnChangeListener { _, value, _ ->
            altura = value.toInt()
            tvAltura.text = altura.toString()
        }

        findViewById<MaterialButton>(R.id.btnPesoMenos).setOnClickListener {
            peso = (peso - 1).coerceAtLeast(1)
            tvPeso.text = peso.toString()
        }
        findViewById<MaterialButton>(R.id.btnPesoMas).setOnClickListener {
            peso = (peso + 1).coerceAtMost(500)
            tvPeso.text = peso.toString()
        }

        findViewById<MaterialButton>(R.id.btnEdadMenos).setOnClickListener {
            edad = (edad - 1).coerceAtLeast(1)
            tvEdad.text = edad.toString()
        }
        findViewById<MaterialButton>(R.id.btnEdadMas).setOnClickListener {
            edad = (edad + 1).coerceAtMost(120)
            tvEdad.text = edad.toString()
        }

        findViewById<MaterialButton>(R.id.btnCalcular).setOnClickListener {
            val bmi = peso * 703.0 / (altura * altura)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("BMI", bmi)
            startActivity(intent)
        }
    }

    private fun seleccionarGenero(hombre: Boolean) {
        val normal = ContextCompat.getColor(this, R.color.boton)
        val seleccionado = ContextCompat.getColor(this, R.color.botonSeleccionado)
        viewMale.setCardBackgroundColor(if (hombre) seleccionado else normal)
        viewFemale.setCardBackgroundColor(if (hombre) normal else seleccionado)
    }
}





