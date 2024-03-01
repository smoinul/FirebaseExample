package fanshawe.example.week6firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {
    val database = Firebase.database
    lateinit var et : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et = findViewById(R.id.editTextText)
    }

    fun onClickButton(view: View) {
        when(view.id){
            R.id.button -> {
                val myRef = database.getReference("message")
                myRef.setValue("Hello, World!")
                Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show()
            }
            R.id.button2 -> {
                val myRef = database.getReference("message").get().addOnSuccessListener {
                    if(it.exists()){
                        Toast.makeText(this, it.value.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

            }
            R.id.button3 -> {
                val myRef = database.getReference("message")
                myRef.setValue(et.text.toString())
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
            }
            R.id.button4 -> {
                val myRef = database.getReference("message")
                myRef.removeValue()
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
            }
        }
    }
}