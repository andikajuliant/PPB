package com.dicoding.bidangdatar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtLength: TextView
    private lateinit var edtWidth: TextView
    private lateinit var edtHeight: TextView
    private lateinit var btnCalculateSegitiga: Button
    private lateinit var btnCalculatePersegi: Button
    private lateinit var btnCalculateLingkaran: Button
    private lateinit var tvReslutKeliling: TextView
    private lateinit var tvResultLuas: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtLength = findViewById(R.id.edt_length)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        btnCalculateSegitiga = findViewById(R.id.btn_calculate_segitiga)
        btnCalculatePersegi = findViewById(R.id.btn_calculate_persegi)
        btnCalculateLingkaran = findViewById(R.id.btn_calculate_lingkaran)
        tvReslutKeliling = findViewById(R.id.tv_result_keliling)
        tvResultLuas = findViewById(R.id.tv_result_luas)

        btnCalculateSegitiga.setOnClickListener(this)
        btnCalculatePersegi.setOnClickListener(this)
        btnCalculateLingkaran.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate_segitiga) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            val keliling = inputLength.toDouble() + inputWidth.toDouble() + inputLength.toDouble()
            tvReslutKeliling.text = keliling.toString() + " m"

            val luas = inputHeight.toDouble() * inputWidth.toDouble() * 0.5
            tvResultLuas.text = luas.toString() + " m2"
        }

        if (v.id == R.id.btn_calculate_persegi) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            val keliling = inputLength.toDouble() + inputWidth.toDouble() + inputLength.toDouble() + inputWidth.toDouble()
            tvReslutKeliling.text = keliling.toString() + " m"

            val luas = inputLength.toDouble() * inputWidth.toDouble()
            tvResultLuas.text = luas.toString() + " m2"

        }

        if (v.id == R.id.btn_calculate_lingkaran) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            val keliling = 2 * inputLength.toDouble() * inputWidth.toDouble()
            tvReslutKeliling.text = keliling.toString() + "m"

            val luas = inputLength.toDouble() * inputLength.toDouble() * inputWidth.toDouble()
            tvResultLuas.text = luas.toString() + " m2"
        }
    }
}