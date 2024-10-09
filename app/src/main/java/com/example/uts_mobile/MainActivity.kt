package com.example.uts_mobile

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.uts_mobile.databinding.ActivityMainBinding
import com.example.uts_mobile.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

        binding.btnSubmit.setOnClickListener {

            val name = binding.enterName.text.toString()

            val editor = sharedPreferences.edit()
            editor.putString("name", name)

            if (name.isEmpty()){
                Toast.makeText(this, "Enter your name first", Toast.LENGTH_SHORT).show()
            }
            else{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish() }
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }
}

