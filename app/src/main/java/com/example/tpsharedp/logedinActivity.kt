package com.example.tpsharedp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class logedinActivity: ComponentActivity() {

    lateinit var Text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logedin)
        Text = findViewById(R.id.Text) ;

        val intent = intent
        if (intent != null) {
            val name = intent.getStringExtra ("name");
            val password = intent.getStringExtra ("password");
            val message  ="Name:"+name +"-Password:" +password
            Text.setText(message)
        }

    }
}

