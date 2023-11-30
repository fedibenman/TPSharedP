package com.example.tpsharedp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var login_btn:Button ;
    lateinit var name:EditText ;
    lateinit var password:EditText ;
    lateinit var remember_check:CheckBox ;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login_btn = findViewById(R.id.login_btn)
        val sharedPreference:SharedPreference=SharedPreference(this)
        val old_name = sharedPreference.getValueString("name")
        val old_pass = sharedPreference.getValueString("password")

        if (old_name!=null && old_pass!=null)
        {
            val intent = Intent(this, logedinActivity::class.java)

            intent.putExtra("name",old_name)
            intent.putExtra("password",old_pass)
            startActivity(intent)
        }

        login_btn.setOnClickListener {
            name = findViewById(R.id.name)
            password =findViewById(R.id.passwrd)
            if (!name.text.isEmpty() && !password.text.isEmpty() ){
                sharedPreference.save("name",name.text.toString())
                sharedPreference.save("password",password.text.toString())

                val intent = Intent(this, logedinActivity::class.java)

                intent.putExtra("name",name.text.toString())
                intent.putExtra("password",password.text.toString())
                startActivity(intent)
            }
        }


    }
}