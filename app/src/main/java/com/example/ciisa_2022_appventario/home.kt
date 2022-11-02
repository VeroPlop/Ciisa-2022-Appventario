package com.example.ciisa_2022_appventario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toolbar

class home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(findViewById(R.id.tool_menu))


        val btn_orden = findViewById<ImageButton>(R.id.btn_orden)
        btn_orden.setOnClickListener {
            val intent = Intent(this@home, menu_orden::class.java)
            startActivity(intent)


        }
        val btn_backhome = findViewById<ImageButton>(R.id.btn_backmenu)
        btn_backhome.setOnClickListener {
            val intent = Intent(this@home, Login::class.java)
            startActivity(intent)

        }
    }
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.home_test,menu)
            return true
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId


        when(itemview){
            R.id.perfil -> Toast.makeText(applicationContext,"Ver Mi Perfil", Toast.LENGTH_SHORT).show()
            R.id.salir -> Toast.makeText(applicationContext,"Salir", Toast.LENGTH_SHORT).show()




        }
        return false
    }
}

