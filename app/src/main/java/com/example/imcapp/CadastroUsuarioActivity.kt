package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

class CadastroUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        editEmail = findViewById(R.id.cadastro_usuario_email)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cadastro, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //salva os dados na sharedPreferences
        val dados = getSharedPreferences("cadastro", MODE_PRIVATE)

        //cria um editor para o arquivo
        val editor = dados.edit()
        editor.putString("email", editEmail.text.toString())
        editor.apply()



        return true
    }


}