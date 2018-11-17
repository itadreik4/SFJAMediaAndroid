package com.sfjamedia.android


import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_contact.*


class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        super.onCreate(savedInstanceState)
        val nightModeFlags = this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (nightModeFlags == Configuration.UI_MODE_NIGHT_NO) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        setContentView(R.layout.activity_contact)
        setSupportActionBar(toolbar)

        send_message.setOnClickListener {
            val nameString = name_text.text.toString()
            val emailString = email_text.text.toString()
            val messageString = message_text.text.toString()

            if (nameString.length < 2 || emailString.length < 6 || messageString.length < 2) {
                Snackbar.make(it, "Please fill out the form", Snackbar.LENGTH_SHORT).show()

            } else if (emailString.contains("@")) {
                if (emailString.startsWith("@") || emailString.endsWith("@")) {
                    Snackbar.make(it, "Please enter a valid email address", Snackbar.LENGTH_SHORT).show()
                } else {
                    val finalMessage = ("Name: $nameString"
                            + "\nEmail: $emailString"
                            + "\nMessage: $messageString")
                    val emailIntent = Intent(Intent.ACTION_SEND)
                    val aEmailList = arrayOf("inquiries@sfjamedia.com")
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList)
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "SFJA Inquiry")
                    emailIntent.type = "plain/text"
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, finalMessage)
                    startActivity(Intent.createChooser(emailIntent, "Choose your email client"))
                }

            } else {
                Snackbar.make(it, "Please enter a valid email", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}


