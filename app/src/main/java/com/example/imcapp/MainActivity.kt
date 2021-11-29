package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var btnEntrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Remover toolbar
        supportActionBar?.hide()

        //Instanciar o botão entrar
        val botaoCriarConta = findViewById<View>(R.id.botao_criar_conta)

        editEmail = findViewById(R.id.edit_login_email)
        editSenha = findViewById(R.id.edit_login_senha)
        btnEntrar = findViewById(R.id.btn_entrar)

        btnEntrar.setOnClickListener {
            login()
        }

        //cria um ouvidor
        botaoCriarConta.setOnClickListener{

            //cria uma intencao e troca de tela
            val intent = Intent(this, CadastroUsuarioActivity::class.java)
            startActivity(intent)
        }

    }

    private fun login() {

        val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        val emailDigitado = editEmail.text.toString()
        val senhaDigitada = editSenha.text.toString()

        val email = arquivo.getString("email", "")
        val senha = arquivo.getString("senha", "")



        if (emailDigitado == email && senhaDigitada == senha){
            val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        }
        else{
        Toast.makeText(this, "Usuario ou senha incorretos!", Toast.LENGTH_SHORT).show()
       }
    }
}
