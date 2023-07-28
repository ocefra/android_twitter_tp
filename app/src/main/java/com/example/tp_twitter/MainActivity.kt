package com.example.tp_twitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tp_twitter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit  var myView : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myView = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        // au clic sur le bouton
        myView.btnLogin.setOnClickListener() {
            onSubmitLogin()
        }
    }

    fun onSubmitLogin() {
        // On vide le message d'erreur
        myView.tvError.text = ""

        // Liste de messages d'erreur. Vide par défaut
        var errors: ArrayList<String> = ArrayList<String>()

        // On vérifie les champs :
        // - email
        val edtLogin = myView.edtLogin
        if (edtLogin.text.isNullOrEmpty() || edtLogin.text.toString().length < 4) {
            errors.add("Email incorrect")
        }

        // - password
        val edtPassword = myView.edtPassword
        if (edtPassword.text.isNullOrEmpty() || edtPassword.text.toString().length < 6) {
            errors.add("Password incorrect")
        }

        if (errors.isNotEmpty()) {
            var message = ""
            for (error in errors) {
                message += "\n" + error
            }
            myView.tvError.text = message
        }
    }
}