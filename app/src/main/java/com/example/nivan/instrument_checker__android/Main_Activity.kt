package com.example.nivan.instrument_checker__android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.gson.Gson
import dataclasses.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileNotFoundException


class Main_Activity : AppCompatActivity() {

    // Click animation setup
    lateinit var clickAnim: Animation
    lateinit var invAnim: Animation
    // Empty student (problems with null student so this works instead)
    private var user: Student = Student("no_name","no_id","no_grade")
    lateinit var f: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickAnim = AnimationUtils.loadAnimation(this, R.anim.click)
        invAnim = AnimationUtils.loadAnimation(this,R.anim.invalid)
        f = applicationContext.filesDir
        try {
            user = loadUser(f)
        } catch (e: FileNotFoundException) {
            println("No user")
        }
        if (user.name!="no_name") {
            val nm = user.name.split(" ")[0]
            textView_welcome.text = "Welcome, $nm"
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        intent = Intent(Intent.ACTION_MAIN)
    }

    fun signInClick(v:View) {
        if (user.instrument == null) {
            textView_sign_in.startAnimation(invAnim)
            Toast.
                makeText(applicationContext,
                    "You don't have an instrument to sign in!",
                    Toast.LENGTH_SHORT)
                .show()
        } else {
            textView_sign_in.startAnimation(clickAnim)
            // when api made add sign in code here
            user.instrument = null
            //
            Toast.
                makeText(applicationContext,
                    "Your instrument has been signed in!",
                    Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun signOutClick(v:View) {
        if (user.instrument != null) {
            textView_sign_out.startAnimation(invAnim)
            Toast.
                makeText(applicationContext,
                    "You already have an instrument out.",
                    Toast.LENGTH_SHORT)
                .show()
        } else {
            textView_sign_out.startAnimation(clickAnim)
            intent = Intent(applicationContext, SignOut::class.java)
            startActivity(intent)
        }

    }

    fun statusClick(v:View) {
        if (user.instrument == null) {
            textView_status.startAnimation(invAnim)
            Toast.
                makeText(applicationContext, "You don't have an instrument!",
                    Toast.LENGTH_SHORT)
                .show()
        } else {
            textView_status.startAnimation(clickAnim)
        }
    }

    fun profileClick(v:View) {
        textView_profile.startAnimation(clickAnim)
        if (user.name!="no_name") {
            val gson = Gson()
            intent = Intent(applicationContext, Profile::class.java)
            intent.putExtra("User",gson.toJson(user))
        } else {
            intent = Intent(applicationContext, SetupProfile::class.java)
        }
        startActivity(intent)
    }

}
