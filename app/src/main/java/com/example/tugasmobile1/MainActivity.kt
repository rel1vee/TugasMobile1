package com.example.tugasmobile1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val panjangEditText = findViewById<TextInputEditText>(R.id.panjang)
        val lebarEditText = findViewById<TextInputEditText>(R.id.lebar)
        val buttonHasil = findViewById<Button>(R.id.buttonHasil)

        buttonHasil.setOnClickListener {
            val panjang = panjangEditText.text.toString()
            val lebar = lebarEditText.text.toString()

            val intent = Intent(this, ActivityResult::class.java)
            intent.putExtra("panjang", panjang)
            intent.putExtra("lebar", lebar)
            startActivity(intent)
        }
    }
}