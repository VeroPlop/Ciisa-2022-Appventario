package com.example.ciisa_2022_appventario

import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class Validate {
    //FUNCION PARA VALIDAR SI EL TEXTO ES NULO

    fun validarCampoNulo(texto:String):Boolean{
        var aux = texto.trim()
        return aux.equals("") || aux.length==0
    }
    //EXPRESION REGULAR RUT

    fun validarRut(rut:String): Boolean {
        val rutexreg = Pattern.compile("\\d{7,8}[-][0-9kK]{1}")
        return !rutexreg.matcher(rut).matches()
    }

    //EXPRESION REGULAR NOMBRE

    fun validarNombre(nombre:String): Boolean {
        val pattern = Pattern.compile("^[a-zA-ZÁ-ÿ\\s?]{1,40}\$")
        return !pattern.matcher(nombre).matches()
    }

    //VALIDAR FORMATO CORREO

    fun validarFormatoCorreo(correo:String):Boolean{
        return !Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    }

    //VALIDAR DOS TEXTOS IGUALES

    fun validarMatch(texto: String,texto2: String):Boolean{
        return texto.equals(texto2)
    }

}