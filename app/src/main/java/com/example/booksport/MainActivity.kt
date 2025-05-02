package com.example.booksport

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivFutsal = findViewById<ImageView>(R.id.ivFutsal)
        val ivBasketball = findViewById<ImageView>(R.id.ivBasketball)
        val ivBadminton = findViewById<ImageView>(R.id.ivBadminton)

        val tvMiniSoccer = findViewById<TextView>(R.id.tvPilihAktivitas2) // Mini Soccer
        val tvBasketball = findViewById<TextView>(R.id.tvPilihAktivitas3)  // Basketball
        val tvBadminton = findViewById<TextView>(R.id.tvPilihAktivitas4)  // Badminton

        ivFutsal.setOnClickListener {
            val intent = Intent(this, VenueListActivity::class.java)
            intent.putExtra("sport", "Futsal") // Mengirimkan olahraga yang dipilih
            startActivity(intent)
        }

        ivBasketball.setOnClickListener {
            val intent = Intent(this, VenueListActivity::class.java)
            intent.putExtra("sport", "Basketball") // Mengirimkan olahraga yang dipilih
            startActivity(intent)
        }

        ivBadminton.setOnClickListener {
            val intent = Intent(this, VenueListActivity::class.java)
            intent.putExtra("sport", "Badminton") // Mengirimkan olahraga yang dipilih
            startActivity(intent)
        }

        // Mengatur klik pada TextView juga
        tvMiniSoccer.setOnClickListener {
            val intent = Intent(this, VenueListActivity::class.java)
            intent.putExtra("sport", "Futsal") // Mengirimkan olahraga yang dipilih
            startActivity(intent)
        }

        tvBasketball.setOnClickListener {
            val intent = Intent(this, VenueListActivity::class.java)
            intent.putExtra("sport", "Basketball") // Mengirimkan olahraga yang dipilih
            startActivity(intent)
        }

        tvBadminton.setOnClickListener {
            val intent = Intent(this, VenueListActivity::class.java)
            intent.putExtra("sport", "Badminton") // Mengirimkan olahraga yang dipilih
            startActivity(intent)
        }
    }
}

