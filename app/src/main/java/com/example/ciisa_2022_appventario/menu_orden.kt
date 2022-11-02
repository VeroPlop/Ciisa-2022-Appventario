package com.example.ciisa_2022_appventario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class menu_orden : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_orden)

        val btn_backhome = findViewById<ImageButton>(R.id.btn_backmenu)
        btn_backhome.setOnClickListener {
            val intent = Intent(this@menu_orden, home::class.java)
            startActivity(intent)
        }

        val btn_buscarorden = findViewById<ImageButton>(R.id.btn_buscarorden)
        btn_buscarorden.setOnClickListener {
            val intent = Intent(this@menu_orden, Buscar_orden::class.java)
            startActivity(intent)

        }

        val btn_editarorden = findViewById<ImageButton>(R.id.btn_editarorden)
        btn_editarorden.setOnClickListener {
            val intent = Intent(this@menu_orden, Editar_orden::class.java)
            startActivity(intent)

        }
        val btn_eliminarorden = findViewById<ImageButton>(R.id.btn_eliminarorden)
        btn_eliminarorden.setOnClickListener {
            val intent = Intent(this@menu_orden, Eliminar_orden::class.java)
            startActivity(intent)

        }
        val btn_agregarorden = findViewById<ImageButton>(R.id.btn_agregarorden)
        btn_agregarorden.setOnClickListener {
            val intent = Intent(this@menu_orden, Agregar_orden::class.java)
            startActivity(intent)
        }
    }
}