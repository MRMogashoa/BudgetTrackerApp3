package com.example.budgettrackerapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        val save = findViewById<Button>(R.id.saveBtn)

        save.setOnClickListener {
            Toast.makeText(this, "Expense Saved!", Toast.LENGTH_SHORT).show()
        }
    }
}