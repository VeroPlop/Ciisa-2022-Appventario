package com.example.ciisa_2022_appventario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // BOTON PARA IR AL LAYOUT "RECUPERAR CONTRASEÑA"

        val btn_password = findViewById<ImageButton>(R.id.btn_password)
        btn_password.setOnClickListener {
            val intent = Intent(this@Login, olvidopassword::class.java)
            startActivity(intent)
        }

        //BOTON PARA IR AL LAYOUT "FORMULARIO DE REGISTRO

        val btn_register = findViewById<ImageButton>(R.id.btn_register)
        btn_register.setOnClickListener {
            val intent = Intent(this@Login, registrarUsuario::class.java)
            startActivity(intent)
        }

        //VALIDACION Y CAPTURA DATOS "LOGIN"

        val til_rut = findViewById<TextInputLayout>(R.id.til_rut)
        val til_passlogin = findViewById<TextInputLayout>(R.id.til_passlogin)
        val btn_login = findViewById<Button>(R.id.btn_login)

        btn_login.setOnClickListener {
            var rut = til_rut.editText?.text.toString()
            var pass = til_passlogin.editText?.text.toString()

            if (validarLogin()==0){
                println("$rut, $pass")
                Toast.makeText(this,"$rut $pass",Toast.LENGTH_LONG).show()

                val intent = Intent(this@Login, home::class.java)
                startActivity(intent)
            }
        }
    }
     // FUNCION VALIDACION DATOS Y CONTADOR DE ERRORES "LOGIN"

    fun validarLogin(): Int {
        var error: Int = 0
        val til_rut = findViewById<TextInputLayout>(R.id.til_rut)
        val til_passlogin = findViewById<TextInputLayout>(R.id.til_passlogin)
        var rut = til_rut.editText?.text.toString()
        var pass = til_passlogin.editText?.text.toString()
        val validate = Validate()

        if (validate.validarCampoNulo(rut)) {
            til_rut.error = "Campo Obligatorio"
            error++
        } else {
            if (validate.validarRut(rut)) {
                til_rut.error = "Error!, Formato Rut Inválido"
                error++
            } else {
                til_rut.error = ""
            }
        }
            if (validate.validarCampoNulo(pass)) {
                til_passlogin.error = "Campo Obligatorio"
                error++
            } else {
                til_passlogin.error = ""
            }

            return error
        }
    }

