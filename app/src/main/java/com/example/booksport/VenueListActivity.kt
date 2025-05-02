package com.example.booksport

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VenueListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_list)

        val sport = intent.getStringExtra("sport")

        // Menampilkan judul olahraga yang dipilih
        val sportTitle = findViewById<TextView>(R.id.sportTitle)
        sportTitle.text = "$sport Available Venues"  // Menampilkan judul olahraga dan daftar lapangan

        // Menentukan daftar lapangan dan lokasi berdasarkan olahraga yang dipilih
        val venueList: List<String> = when (sport) {
            "Futsal" -> listOf("Mini Soccer Gibeng", "Mini Soccer Kepituh", "Mini Soccer Mulyasara")
            "Basketball" -> listOf("Silver City", "X Arena", "HIST Arena")
            "Badminton" -> listOf("Super Badminton", "Rajawali Badminton", "BETOS Badminton")
            else -> emptyList()
        }

        // Menentukan lokasi lapangan
        val venueLocations = mapOf(
            "Mini Soccer Gibeng" to "Jl. Raya Gibeng No. 69, Surabaya",
            "Mini Soccer Kepituh" to "Jl. Raya Kepituh No. 45, Surabaya",
            "Mini Soccer Mulyasara" to "Jl. Raya Mulyasara No. 12, Surabaya",
            "Silver City" to "Jl. City Plaza No. 1, Surabaya",
            "X Arena" to "Jl. X Arena No. 33, Surabaya",
            "HIST Arena" to "Jl. HIST Arena No. 8, Surabaya",
            "Super Badminton" to "Jl. Super No. 10, Surabaya",
            "Rajawali Badminton" to "Jl. Rajawali No. 12, Surabaya",
            "BETOS Badminton" to "Jl. BETOS No. 5, Surabaya",
        )

        // Menampilkan nama lapangan dan lokasi
        findViewById<TextView>(R.id.tvVenueName1).text = venueList[0]
        findViewById<TextView>(R.id.tvVenueLocation1).text = venueLocations[venueList[0]]

        findViewById<TextView>(R.id.tvVenueName2).text = venueList[1]
        findViewById<TextView>(R.id.tvVenueLocation2).text = venueLocations[venueList[1]]

        findViewById<TextView>(R.id.tvVenueName3).text = venueList[2]
        findViewById<TextView>(R.id.tvVenueLocation3).text = venueLocations[venueList[2]]

        // OnClickListener untuk mengarahkan ke halaman booking
        findViewById<CardView>(R.id.cardVenue1).setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("venue", venueList[0])
            startActivity(intent)
        }

        findViewById<CardView>(R.id.cardVenue2).setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("venue", venueList[1])
            startActivity(intent)
        }

        findViewById<CardView>(R.id.cardVenue3).setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("venue", venueList[2])
            startActivity(intent)
        }

        // Tombol Kembali
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()  // Menutup VenueListActivity dan kembali ke MainActivity
        }
    }
}


