package com.example.ciisa_2022_appventario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.ciisa_2022_appventario.databinding.ActivityRegistrarUsuarioBinding
import com.google.android.material.textfield.TextInputLayout

class registrarUsuario : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarUsuarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //GENERACIÓN DEL SPINNER
        val cargos = resources.getStringArray(R.array.name_items)
        val adapter = ArrayAdapter(
            this,
            R.layout.lista_cargos,
            cargos
        )

        with(binding.autoCompleteTextView2) {
            setAdapter(adapter)

        }
        //FLECHA BACK LOGIN
        val btn_backhome = findViewById<ImageButton>(R.id.btn_backmenu)
        btn_backhome.setOnClickListener {
            val intent = Intent(this@registrarUsuario, Login::class.java)
            startActivity(intent)
        }

        //BOTON CANCELAR
        val btn_cancelar = findViewById<Button>(R.id.btn_cancelar)
        btn_cancelar.setOnClickListener {
            val intent = Intent(this@registrarUsuario, Login::class.java)
            startActivity(intent)
        }

        //VALIDACION Y CAPTURA DE DATOS DEL REGISTRO

        val edittext_PersonName = findViewById<EditText>(R.id.edittext_PersonName)
        val edittext_personrut = findViewById<EditText>(R.id.edittext_personrut)
        val til_password = findViewById<TextInputLayout>(R.id.til_password)
        val til_repassword = findViewById<TextInputLayout>(R.id.til_repassword)
        val til_function = findViewById<TextInputLayout>(R.id.til_function)
        val btn_create = findViewById<Button>(R.id.btn_agregarO)

        btn_create.setOnClickListener {

            var fullname = edittext_PersonName.editableText.toString()
            var rutregistro = edittext_personrut.editableText.toString()
            var contra = til_password.editText?.text.toString()
            var recontra = til_repassword.editText?.text.toString()
            var funcion = til_function.editText?.text.toString()

            if (validarCampos() == 0) {

                println("$fullname $rutregistro $contra $recontra $funcion")
                Toast.makeText(this,"$fullname $rutregistro $contra $recontra $funcion",
                    Toast.LENGTH_LONG).show()

                val intent = Intent(this@registrarUsuario,Login::class.java)
                startActivity(intent)
            }
        }
    }

    // FUNCION VALIDACION DE DATOS

    fun validarCampos(): Int {

        var contador: Int = 0
        val edittext_PersonName = findViewById<EditText>(R.id.edittext_PersonName)
        val edittext_personrut = findViewById<EditText>(R.id.edittext_personrut)
        val til_password = findViewById<TextInputLayout>(R.id.til_password)
        val til_repassword = findViewById<TextInputLayout>(R.id.til_repassword)
        val til_function = findViewById<TextInputLayout>(R.id.til_function)
        var fullname = edittext_PersonName.editableText.toString()
        var rutregistro = edittext_personrut.editableText.toString()
        var contra = til_password.editText?.text.toString()
        var recontra = til_repassword.editText?.text.toString()
        var funcion = til_function.editText?.text.toString()
        val validate = Validate()

        if (validate.validarCampoNulo(fullname)) {
            edittext_PersonName.error = "Este campo es obligatorio"
            contador++
        } else {
            if (validate.validarNombre(fullname)) {
                edittext_PersonName.error = "Por favor, escriba su nombre completo"
                contador++
            } else {
                edittext_PersonName.error = null
                true
            }
        }
            if (validate.validarCampoNulo(rutregistro)) {
                edittext_personrut.error = "Este campo es obligatorio"
                contador++
            } else {
                if (validate.validarRut(rutregistro)) {
                    edittext_personrut.error = "Error formato de rut invalido"
                    contador++
                } else {
                    edittext_personrut.error = null
                    true
                }
            }
            if (validate.validarCampoNulo(contra)) {
                til_password.error = "Este campo es obligatorio"
                contador++
            } else {
                til_repassword.error = ""
            }
            if (validate.validarCampoNulo(recontra)){
                til_repassword.error = "Este campo es obligatorio"
                contador++
            }else{
                if(!validate.validarMatch(contra, recontra)){
                    til_repassword.error = "Contraseñas deben coincidir"
                    contador++
                }else{
                    til_repassword.error = ""
                }
                til_password.error = ""
            }

            if (validate.validarCampoNulo(funcion)) {
                til_function.error = "Este campo es obligatorio"
                contador++
            } else {
                til_function.error = ""
            }

            return contador

        }
    }



