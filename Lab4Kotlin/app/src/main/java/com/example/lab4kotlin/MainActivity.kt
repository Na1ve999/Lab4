package com.example.lab4kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var tv_meal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_meal = findViewById(R.id.tv_meal)
        btn = findViewById(R.id.btn_choice)
        btn.setOnClickListener{v: View? ->
            startActivityForResult(Intent(this@MainActivity, Main2Activity::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null)
            return
        if (requestCode == 1) {
            if (resultCode == 101) {
                val str1 = data.extras?.getString("drink")
                val str2 = data.extras?.getString("sugar")
                val str3 = data.extras?.getString("ice_opt")
                tv_meal.text = String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n", str1, str2, str3)
            }
        }
    }
}