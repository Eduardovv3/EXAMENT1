package com.pmdm.exament1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val tvResultado: TextView = findViewById(R.id.tvResultado)
        val name:String = intent.extras?.getString("name").orEmpty()
        val personas:String = intent.extras?.getString("personas").orEmpty()
        val hora:String = intent.extras?.getString("hora").orEmpty()
        tvResultado.text = "Mesa reservada para $personas a nombre de $name , a las $hora"
    }
}