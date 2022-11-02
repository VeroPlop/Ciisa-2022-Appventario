package com.example.ciisa_2022_appventario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Agregar_orden : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_orden)

        val btn_backmenu = findViewById<ImageButton>(R.id.btn_backmenu)
        btn_backmenu.setOnClickListener {
            val intent = Intent(this@Agregar_orden, menu_orden::class.java)
            startActivity(intent)
        }
        val btn_backhomeicono = findViewById<ImageButton>(R.id.btn_backhomeicono)
        btn_backhomeicono.setOnClickListener {
            val intent = Intent(this@Agregar_orden, home::class.java)
            startActivity(intent)
        }
    }
}