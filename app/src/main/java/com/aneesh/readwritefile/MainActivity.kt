package com.aneesh.readwritefile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    val FILE_NAME = "file.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveText()
        readText()

    }

    private fun readText() {
        buttonREAD.setOnClickListener{
            val file = File(filesDir, FILE_NAME)
            val textInFile = file.readText()
            textViewRead.text = textInFile
        }
    }

    private fun saveText() {
        buttonSAVE.setOnClickListener{
            if(editTextSave.text.isNotEmpty()){
                val text = editTextSave.text.toString()
                val fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
                fileOutputStream.write(text.toByteArray())
            }else{
                Toast.makeText(this@MainActivity, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }
    }
}