package com.example.ciisa_2022_appventario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Editar_orden : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_orden)

        val btn_backmenu = findViewById<ImageButton>(R.id.btn_backmenu)
        btn_backmenu.setOnClickListener {
            val intent = Intent(this@Editar_orden, menu_orden::class.java)
            startActivity(intent)
        }
    }
}