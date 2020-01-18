package com.example.nivan.instrument_checker__android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import dataclasses.Instrument
import kotlinx.android.synthetic.main.activity_sign_out.*
import java.io.FileNotFoundException

class SignOut : AppCompatActivity() {


    private lateinit var instruments: Array<Instrument>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_out)

        try {
            instruments = loadInstruments(filesDir)
        } catch (e: FileNotFoundException) {
            instruments = arrayOf(Instrument("Tuba","1234","x1","Smith"),
                        Instrument("Trumpet","1122","ff44","Qbert"),
                        Instrument("Violin","1337","He123","Stratovarius")
            )
        }

        val instrumentsText = arrayOfNulls<String>(instruments.size)

        for (i in 0 until instruments.size) {
            instrumentsText[i] = "${instruments[i].insType} #${instruments[i].insNum}"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,instrumentsText)
        instrument_list_view.adapter = adapter
    }
}
