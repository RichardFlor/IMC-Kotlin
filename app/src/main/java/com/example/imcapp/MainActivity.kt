package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val botaoCriarConta = findViewById<View>(R.id.botao_criar_conta)

        //cria um ouvidor
        botaoCriarConta.setOnClickListener{

            //cria uma intencao e troca de tela
            val intent = Intent(this, CadastroUsuarioActivity::class.java)
            startActivity(intent)
        }

    }
}