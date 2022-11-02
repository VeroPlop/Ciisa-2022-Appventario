package com.example.ciisa_2022_appventario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.SearchView
import com.example.ciisa_2022_appventario.databinding.ActivityBuscarOrdenBinding

class Buscar_orden : AppCompatActivity() {

    lateinit var binding: ActivityBuscarOrdenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_buscar_orden)

        val btn_backmenu = findViewById<ImageButton>(R.id.btn_backmenu)
        btn_backmenu.setOnClickListener {
            val intent = Intent(this@Buscar_orden, menu_orden::class.java)
            startActivity(intent)

        }
}
}