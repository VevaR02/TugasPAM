package com.example.hellotoast


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri


class MainActivity : AppCompatActivity() {
    private var mCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)
        val buttonMap = findViewById<Button>(R.id.button_map)
        val buttonDial = findViewById<Button>(R.id.button_dial)
        val buttonShare = findViewById<Button>(R.id.button_share)


        buttonCountUp.setOnClickListener {
            mCount++
            Log.d("mCount", mCount.toString())
            if (mShowCount != null)
                mShowCount.text = mCount.toString()
        }


        buttonToast.setOnClickListener {
            val tulisan: String = mShowCount?.text.toString()
            val toast: Toast =
                Toast.makeText(this, "Angka yang dimunculkan $tulisan", Toast.LENGTH_LONG)
            toast.show()
        }


        buttonSwitchPage.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        buttonBrowser.setOnClickListener {
            val intentbrowse = Intent(Intent.ACTION_VIEW)
            intentbrowse.setData("https://www.google.com/".toUri())
            startActivity(intentbrowse)
        }


        buttonMap.setOnClickListener {
            val gmmIntentUri = "geo:0,0?q=Monumen Nasional, Jakarta".toUri()
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        buttonDial.setOnClickListener {
            val phoneNumber = "081234567890"
            val dialIntent = Intent(Intent.ACTION_DIAL, "tel:$phoneNumber".toUri())
            startActivity(dialIntent)
        }

        buttonShare.setOnClickListener {
            val shareText = "Halo! Ini adalah teks yang saya bagikan dari aplikasi."
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }


    }

}
