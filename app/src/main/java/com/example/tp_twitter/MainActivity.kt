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

        var errorMessage = ""

        // On vérifie les champs :
        // - email
        val edtLogin = findViewById<EditText>(R.id.edtLogin)
        if (edtLogin.text.isNullOrEmpty() || edtLogin.text.toString().length < 4) {
            errorMessage = "Email incorrect"
        }

        // - password
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        if (edtPassword.text.isNullOrEmpty() || edtPassword.text.toString().length < 6) {
            errorMessage = "Password incorrect"
        }

        if (errorMessage.isNotEmpty()) {
            findViewById<TextView>(R.id.tvError).text = errorMessage
        }
    }
}