//
//  Student.kt
//  InstrumentChecker
//
//  Created by n-ivan on 2020-01-13.
//

package dataclasses

data class Instrument(val name: String,val insType: String,
                       val insNum: String, val model: String,
                       val make: String) {
    var dateIn: String? = null
    var dateOut: String?  = null

    constructor(name: String,insType: String,insNum: String,model: String,make: String,dateOut: String, dateIn: String):
            this(name,insType,insNum,model,make) {
        this.dateIn = dateIn
        this.dateOut = dateOut
    }
}