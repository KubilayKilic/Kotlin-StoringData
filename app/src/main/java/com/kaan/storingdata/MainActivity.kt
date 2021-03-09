package com.kaan.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var ageFromPref : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences Initialize
        sharedPreferences = this.getSharedPreferences("com.kaan.storingdata",
            Context.MODE_PRIVATE)

        ageFromPref = sharedPreferences.getInt("age", -1)

        if (ageFromPref == -1) {
            textView.text = "your age: "
        } else {
            textView.text = "your age: ${ageFromPref}"
        }
    }

    fun save(view : View) {

        val myAge= editTextTextPersonName.text.toString().toIntOrNull()

        if (myAge != null) {
            textView.text = "Your Age: " + myAge
            sharedPreferences.edit().putInt("age", myAge).apply()
        }
    }

    fun delete(view : View) {

        ageFromPref = sharedPreferences.getInt("age", -1)

        if (ageFromPref != -1) {
            sharedPreferences.edit().remove("age").apply()
            textView.text = "your age: "
        }

    }
}