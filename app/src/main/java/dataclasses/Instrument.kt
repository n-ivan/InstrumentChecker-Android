//
//  Student.kt
//  InstrumentChecker
//
//  Created by n-ivan on 2020-01-13.
//

package dataclasses

class Instrument(_name: String, _insType: String, _insNum: String,
                 _model: String, _make: String) {
    val name = _name.capitalize()
    val insType = _insType
    val insNum = _insNum
    val model: String = _model
    val make: String = _make
    var dateOut: String? = null
    var timeOut: String? = null

    constructor(_name: String, _insType: String, _insNum: String,
                _model: String, _make: String, _dateOut: String, _timeOut: String):
            this(_name, _insType, _insNum, _model, _make) {
        this.dateOut = _dateOut
        this.timeOut = _timeOut
    }
}