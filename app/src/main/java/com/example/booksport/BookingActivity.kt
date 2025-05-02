package com.example.booksport

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_booking)

        // Menampilkan lapangan yang dipilih
        val selectedVenue = intent.getStringExtra("venue")
        val venueTextView = findViewById<TextView>(R.id.venueTextView)
        venueTextView.text = "Anda memilih: $selectedVenue"

        // Menangani input nama pemesan
        val etNama = findViewById<EditText>(R.id.etNama)
        val etTanggal = findViewById<EditText>(R.id.etTanggal)
        val etWaktu = findViewById<EditText>(R.id.etWaktu)
        val btnKirim = findViewById<Button>(R.id.btnKirim)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish() // Menutup BookingActivity dan kembali ke halaman sebelumnya
        }

        // Menangani klik untuk memilih tanggal
        etTanggal.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val tanggalTerpilih = "%04d-%02d-%02d".format(selectedYear, selectedMonth + 1, selectedDay)
                etTanggal.setText(tanggalTerpilih)
            }, year, month, day)

            datePicker.show()
        }

        // Menangani klik untuk memilih waktu
        etWaktu.setOnClickListener {
            val timePicker = TimePickerDialog(this, { _, hourOfDay, minute ->
                val waktuTerpilih = "%02d:%02d".format(hourOfDay, minute)
                etWaktu.setText(waktuTerpilih)
            }, 12, 0, true)
            timePicker.show()
        }

        // Menangani tombol Kirim untuk mengonfirmasi pemesanan
        btnKirim.setOnClickListener {
            val nama = etNama.text.toString()
            val tanggal = etTanggal.text.toString()
            val waktu = etWaktu.text.toString()

            if (nama.isEmpty() || tanggal.isEmpty() || waktu.isEmpty()) {
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            } else {
                val konfirmasi = "Pemesanan untuk $nama pada $tanggal pukul $waktu di $selectedVenue"
                Toast.makeText(this, konfirmasi, Toast.LENGTH_LONG).show()
            }
        }
    }
}



