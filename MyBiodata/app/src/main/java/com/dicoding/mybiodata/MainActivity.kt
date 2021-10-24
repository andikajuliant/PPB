package com.dicoding.mybiodata

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title = "About Developer"

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnDialMail: Button = findViewById(R.id.btn_dial_email)
        btnDialMail.setOnClickListener(this)

        val btnDialMaps: Button = findViewById(R.id.btn_dial_map)
        btnDialMaps.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_dial_number -> {
                val phoneNumber = "087725257819"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_dial_email -> {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:abc@xyz.com")
                }
                startActivity(Intent.createChooser(emailIntent, "Send feedback"))
            }

            R.id.btn_dial_map -> {
                val gmapIntentUri = Uri.parse("geo:-6.744657, 111.074108")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmapIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                mapIntent.resolveActivity(packageManager)?.let {
                    startActivity(mapIntent)
                }
            }
        }
    }
}