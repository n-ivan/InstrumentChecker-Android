package com.example.nivan.instrument_checker__android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import dataclasses.*
import kotlinx.android.synthetic.main.activity_main.*


class Main_Activity : AppCompatActivity() {

    // Click animation setup
    lateinit var clickAnim: Animation
    private var user: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickAnim = AnimationUtils.loadAnimation(this,R.anim.click)
        user = Student("John Cena","1337420","11")
    }

    fun signInClick(v:View) {
        textView_sign_in.startAnimation(clickAnim)
    }
    fun signOutClick(v:View) {
        textView_sign_out.startAnimation(clickAnim)
    }
    fun statusClick(v:View) {
        textView_status.startAnimation(clickAnim)
    }
    fun profileClick(v:View) {
        var intent = Intent(applicationContext, SetupProfile::class.java)
        textView_profile.startAnimation(clickAnim)
        if (user!=null) {
            intent = Intent(applicationContext, Profile::class.java)
        }
        startActivity(intent)
    }
}
