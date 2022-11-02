package com.example.ciisa_2022_appventario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class olvidopassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olvidopassword)

        val til_mail = findViewById<TextInputLayout>(R.id.til_mail)
        val btn_enviarmail = findViewById<Button>(R.id.btn_enviarmail)
        btn_enviarmail.setOnClickListener {

            var mail = til_mail.editText?.text.toString()

            if (validarCampo() == 0) {

                println("$mail")
                Toast.makeText(this, "$mail", Toast.LENGTH_LONG).show()

                val intent = Intent(this@olvidopassword,Login::class.java)
                startActivity(intent)
            }
        }
            val btn_cancelarmail = findViewById<ImageButton>(R.id.btn_cancelarmail)
            btn_cancelarmail.setOnClickListener {
                val intent = Intent(this@olvidopassword, Login::class.java)
                startActivity(intent)

        }

    }

    fun validarCampo(): Int {
        var contador: Int = 0
        val til_mail = findViewById<TextInputLayout>(R.id.til_mail)
        var mail = til_mail.editText?.text.toString()
        val validate = Validate()
        if (validate.validarCampoNulo(mail)) {
            til_mail.error = "Por Favor, ingrese un correo electrónico"
            contador++
        } else {
            if (validate.validarFormatoCorreo(mail)) {
                til_mail.error = "Formato incorrecto"
                contador++
            } else {
                til_mail.error = ""
            }
        }
            return contador
        }

    }

