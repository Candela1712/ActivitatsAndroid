package com.candelaortuno.prueba1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.candelaortuno.prueba1.ui.theme.Prueba1Theme


data class Persona(
    val name: String,
    val age: Int,
    val entreteniments: List<String>
)

fun botDeSeguretat(persona: Persona){
    if (persona.name != "Candela"){
        println("Nom incorrecte, no pots accedir")
        return
    }
    println("Nom correcte! Continua.")

    if (persona.age in 0..13){
        println("Ets massa petita. No pots accedir")
        return
    }else if(persona.age in 14..17){
        println("Necessites permís parental.")
        return
    }else if(persona.age >= 18){
        println("Accés concedit.")
    }else{
        println("Edat no vàlida. No pots accedir")
        return
    }

    val entrOrdenats = persona.entreteniments.sorted()

    for(e in entrOrdenats){
        val primeraLletra = e[0].uppercaseChar()
        if(primeraLletra in 'A'..'L'){
            println(e)
        }
    }
}
fun main(){
    val persona = Persona(
        name = "Candela",
        age = 18,
        entreteniments = listOf(
            "Fútbol",
            "Gimnàs",
            "Videojocs",
            "Cinema",
        )
    )
    botDeSeguretat(persona)
}