package com.sfjamedia.android


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<MaterialButton>(R.id.send_message).setOnClickListener {
            val nameString = findViewById<EditText>(R.id.name_text).text.toString()
            val emailString = findViewById<EditText>(R.id.email_text).text.toString()
            val messageString = findViewById<EditText>(R.id.message_text).text.toString()

            if (nameString.length < 2 || emailString.length < 6 || messageString.length < 2) {
                Toast.makeText(this@ContactActivity, "Please fill out the form", Toast.LENGTH_SHORT).show()

            } else if (emailString.contains("@")) {
                if (emailString.startsWith("@") || emailString.endsWith("@")) {
                    Toast.makeText(this@ContactActivity, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
                } else {
                    val finalMessage = ("Name: " + nameString
                            + "\nEmail: " + emailString
                            + "\nMessage: " + messageString)
                    val emailIntent = Intent(Intent.ACTION_SEND)
                    val aEmailList = arrayOf("inquiries@sfjamedia.com")
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList)
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "SFJA Inquiry")
                    emailIntent.type = "plain/text"
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, finalMessage)
                    startActivity(Intent.createChooser(emailIntent, "Choose your email client"))
                }

            } else {
                Toast.makeText(this@ContactActivity, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


