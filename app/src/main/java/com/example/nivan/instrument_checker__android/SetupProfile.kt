package com.example.nivan.instrument_checker__android

import android.content.Intent
import dataclasses.Student
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_setup_profile.*

class SetupProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_profile)

    }

    fun saveClick(v:View) {
        lateinit var user: Student
        val name = editText_name.text.toString()
        val id = editText_id.text.toString()
        val grade = editText_grade.text.toString()
        val noEdit_name = getString(R.string.entername)
        val noEdit_id = getString(R.string.enterid)
        val noEdit_grade = getString(R.string.entergrade)

        if (name!=noEdit_name) {
            if (id!=noEdit_id) {
                if (grade!=noEdit_grade) {
                    val gson = Gson()
                    user = Student(name,id, grade)
                    val jsonString = gson.toJson(user)
                    intent = Intent(applicationContext, Profile::class.java)
                    intent.putExtra("User",jsonString)
                    saveUser(user,applicationContext.filesDir)
                    startActivity(intent)
                }
            }
        } else {
            Toast.
                makeText(applicationContext, "Finish filling out the fields.",Toast.LENGTH_SHORT)
                .show()
        }
    }
}
