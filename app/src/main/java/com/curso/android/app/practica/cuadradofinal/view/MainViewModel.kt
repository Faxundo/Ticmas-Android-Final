package com.curso.android.app.practica.cuadradofinal.view

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    fun comparateText (firstText: String, secondText: String):Boolean {
        return firstText == secondText
    }
}