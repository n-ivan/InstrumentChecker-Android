package com.example.nivan.instrument_checker__android

import dataclasses.Student
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.Writer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.Error



fun saveUser(user: Student,dir: File) {
    saveJSON(user,"user",dir)
}

fun loadUser(dir: File): Student {
    val gson = Gson()
    val jsonFile = File(dir,"user.json")
    val text: String = jsonFile.readText()
    var user: Student = Student("no_name","no_id","no_grade")
    try{
        user = gson.fromJson(text, Student::class.java)
    } catch (e: Error) {
        println("Failed to load User")
    }
    return user
}

private fun saveJSON(obj: Any,fileName: String,dir: File) {
    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonString: String = gson.toJson(obj)
    val output: Writer
    val file = makeFile(fileName,dir)
    output = BufferedWriter(FileWriter(file))
    output.write(jsonString)
    output.close()
}

private fun makeFile(fileName: String,dir: File): File{

    if (!dir.exists()) {
        dir.mkdir()
    }
    return File(dir,"$fileName.json")
}