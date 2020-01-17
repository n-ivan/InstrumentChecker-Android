//
//  Student.kt
//  InstrumentChecker
//
//  Created by n-ivan on 2020-01-13.
//

package dataclasses

data class Student(val name: String,val id: String,var grade: String) {
    var instrument: Instrument? = null

    constructor(name: String, id: String,grade: String,instrument: Instrument):
            this(name,id,grade){
        this.instrument = instrument
    }
}