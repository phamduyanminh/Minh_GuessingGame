package com.profjk.guessinggamef20mid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.profjk.guessinggamef20mid.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var correctNumber = 0
    private var attemp : Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCheck.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun generateRandomNumber() {
        correctNumber = Random().nextInt(25)
    }

    private fun validateData() : Boolean{
        if (edtAnswer.text.isEmpty()){
            edtAnswer.setError("Please enter your guess!")
            return false
        }
        return true
    }

    override fun onClick(v: View?) {
        if (v != null){
            if (v.id == btnCheck.id){
                //checking attemp available left
                if (attemp > 0){
                    //checking validating input
                    if (this.validateData()){
                        if (edtAnswer.text.toString().toInt() != correctNumber){
                            if (edtAnswer.text.toString().toInt() < correctNumber){
                                attemp -= 1
                                Toast.makeText(applicationContext, "Sorry your guess is lower. Please try again!", Toast.LENGTH_LONG)
                            }else if (edtAnswer.text.toString().toInt() > correctNumber){
                                attemp -= 1
                                Toast.makeText(applicationContext, "Sorry your guess is higher. Please try again!", Toast.LENGTH_LONG)
                            }
                        }else  if (edtAnswer.text.toString().toInt() == correctNumber){
                            Toast.makeText(applicationContext, "You WON!", Toast.LENGTH_LONG)
                        }
                    }
                }
            }
        }
    }

}