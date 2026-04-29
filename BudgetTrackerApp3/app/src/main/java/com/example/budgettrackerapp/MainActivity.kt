package com.example.budgettrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.loginBtn)
        val register = findViewById<Button>(R.id.registerBtn)

        // Go to Register screen
        register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Login logic + navigation to Dashboard
        login.setOnClickListener {

            val user = username.text.toString()
            val pass = password.text.toString()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val foundUser = DataStore.users.find {
                it.username == user && it.password == pass
            }

            if (foundUser != null) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

                // 👉 THIS IS THE IMPORTANT PART
                startActivity(Intent(this, DashboardActivity::class.java))

                // optional: close login screen
                finish()

            } else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show()
            }
        }
    }
}