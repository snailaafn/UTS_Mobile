package com.example.uts_mobile

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uts_mobile.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)

//        val nameInput = binding.txtNama.text.toString()
//        val savedName = sharedPreferences.getString("name", "")

        val name = intent.getStringExtra("name")
//        intent.putExtra("name", savedName)
        binding.txtNama.text = "$name"

        binding.btnKeluar.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "You have successfully logged out", Toast.LENGTH_SHORT).show()
        }

    }

}