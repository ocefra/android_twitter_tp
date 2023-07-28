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
    }

}