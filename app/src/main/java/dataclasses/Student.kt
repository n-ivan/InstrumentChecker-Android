//
//  Student.kt
//  InstrumentChecker
//
//  Created by n-ivan on 2020-01-13.
//

package dataclasses

class Student(_name: String, _id: String, _grade: String) {
    val name = _name.capitalize()
    val id = _id
    var grade = _grade
    var instrument: Instrument? = null

    constructor(_name: String, _id: String, _grade: String,
    _instrument: Instrument): this(_name,_id,_grade) {
        this.instrument = _instrument
    }

    fun set_instrument(instrument: Instrument) {
        this.instrument = instrument
    }
}

