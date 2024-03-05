package com.example.tugasmobile1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val panjangTextView = findViewById<TextView>(R.id.panjang)
        val lebarTextView = findViewById<TextView>(R.id.lebar)
        val hasilTextView = findViewById<TextView>(R.id.hasil)

        val panjang = intent.getStringExtra("panjang")?.toDoubleOrNull()
        val lebar = intent.getStringExtra("lebar")?.toDoubleOrNull()

        if (panjang != null && lebar != null) {
            val hasil = panjang * lebar

            panjangTextView.text = panjang.toString()
            lebarTextView.text = lebar.toString()
            hasilTextView.text = hasil.toString()
        } else {
            // Menangani kasus jika panjang atau lebar tidak valid
            panjangTextView.text = "0.0"
            lebarTextView.text = "0.0"
            hasilTextView.text = "0.0"
        }
    }
}