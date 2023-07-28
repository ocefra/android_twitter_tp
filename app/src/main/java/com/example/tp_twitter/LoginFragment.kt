package com.example.tp_twitter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.tp_twitter.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    lateinit var myFragmentView: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // On récupère la vue du fragment
        myFragmentView = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)

        // au clic sur le bouton
        myFragmentView.btnLogin.setOnClickListener() {
            onSubmitLogin()
        }

        return myFragmentView.root
    }

    fun onSubmitLogin() {
        // On vide le message d'erreur
        myFragmentView.tvError.text = ""

        // Liste de messages d'erreur. Vide par défaut
        var errors: ArrayList<String> = ArrayList<String>()

        // On vérifie les champs :
        // - email
        val edtLogin = myFragmentView.edtLogin
        if (edtLogin.text.isNullOrEmpty() || edtLogin.text.toString().length < 4) {
            errors.add("Email incorrect")
        }

        // - password
        val edtPassword = myFragmentView.edtPassword
        if (edtPassword.text.isNullOrEmpty() || edtPassword.text.toString().length < 6) {
            errors.add("Password incorrect")
        }

        if (errors.isNotEmpty()) {
            var message = ""
            for (error in errors) {
                message += "\n" + error
            }
            myFragmentView.tvError.text = message
        } else {
            // On navigue sur le fragment Twitter
            requireActivity().findNavController(R.id.myNavHost).navigate(R.id.action_loginFragment_to_twitterFragment)
        }
    }
}