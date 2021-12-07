package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.imcapp.utils.dataAtualBrasil
import java.time.LocalDate

class PesagemActivity : AppCompatActivity() {

    lateinit var textViewDataPesagem: TextView
    lateinit var spinnerNivelAtividade: Spinner
    lateinit var editTextNovoPeso: EditText
    lateinit var buttonRegistrarPeso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem)

        editTextNovoPeso = findViewById(R.id.edit_text_novo_peso)
        textViewDataPesagem = findViewById(R.id.text_view_data_pesagem)
        spinnerNivelAtividade = findViewById(R.id.spinner_niveis_atividade)
        buttonRegistrarPeso = findViewById(R.id.button_registrar_peso)

        supportActionBar!!.hide()

        textViewDataPesagem.text = dataAtualBrasil()

        buttonRegistrarPeso.setOnClickListener {
            registrarPeso()
        }
    }
    private fun registrarPeso(){
        val cadastro = getSharedPreferences("cadastro", MODE_PRIVATE)
        val editor = cadastro.edit()

        editor.putString("data_pesagem", dataAtualBrasil())
        editor.putString("peso", editTextNovoPeso.text.toString())
        editor.putInt("nivel", spinnerNivelAtividade.selectedItemPosition)

        editor.commit()

        Toast.makeText(this, "Peso gravado com sucesso!", Toast.LENGTH_SHORT).show()
        finish()
    }
}