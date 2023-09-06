package com.curso.android.app.practica.cuadradofinal.view

import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.cuadradofinal.R
import com.curso.android.app.practica.cuadradofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    lateinit var editTextOne: EditText
    lateinit var editTextTwo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editTextOne = findViewById(R.id.editableTextOne)
        editTextTwo = findViewById(R.id.editableTextTwo)

        binding.resultButton.setOnClickListener{
            if(mainViewModel.comparateText(editTextOne.text.toString(), editTextTwo.text.toString())) {
                binding.textResult.setTextColor(Color.GREEN)
                binding.textResult.text = "Los textos son iguales"
            } else {
                binding.textResult.setTextColor(Color.RED)
                binding.textResult.text = "Los textos no son iguales"
            }
        }
    }
}
