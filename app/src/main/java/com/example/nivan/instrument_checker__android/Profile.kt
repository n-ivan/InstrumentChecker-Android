package com.example.nivan.instrument_checker__android

import android.content.Intent
import dataclasses.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_profile.*
import java.io.File

class Profile : AppCompatActivity() {

    lateinit var user: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val gson = Gson()

        user = gson.fromJson(intent.getStringExtra("User"),
                                            Student::class.java)

        textView_nameBox.text = user.name
        textView_idBox.text = user.id
        if (user.instrument!=null) {
            val type = user.instrument?.insType
            val num = user.instrument?.insNum
            textView_insBox.text = "$type, #$num"
        } else {
            textView_insBox.text = "No Instrument yet..."
        }
    }

    fun resetClick(v: View) {
        if (user.instrument == null) {
            File(filesDir,"user.json").delete()
            intent = Intent(applicationContext, Main_Activity::class.java)
            startActivity(intent)
        } else {
            Toast.
                makeText(applicationContext,
                    "You can't reset while you have an Instrument signed out"
                    ,Toast.LENGTH_SHORT)
                .show()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        intent = Intent(applicationContext, Main_Activity::class.java)
        startActivity(intent)
    }
}
