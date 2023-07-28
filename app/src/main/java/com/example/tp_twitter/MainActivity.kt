package com.example.tp_twitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSubmitLogin(view: View) {
        // On vide le message d'erreur
        findViewById<TextView>(R.id.tvError).text = ""

        // Liste de messages d'erreur. Vide par défaut
        var errors: ArrayList<String> = ArrayList<String>()

        // On vérifie les champs :
        // - email
        val edtLogin = findViewById<EditText>(R.id.edtLogin)
        if (edtLogin.text.isNullOrEmpty() || edtLogin.text.toString().length < 4) {
            errors.add("Email incorrect")
        }

        // - password
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        if (edtPassword.text.isNullOrEmpty() || edtPassword.text.toString().length < 6) {
            errors.add("Password incorrect")
        }

        if (errors.isNotEmpty()) {
            var message = ""
            for (error in errors) {
                message += "\n" + error
            }
            findViewById<TextView>(R.id.tvError).text = message
        }
    }
}