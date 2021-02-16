package edu.itesm.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var tiros = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("edu.itesm.daec", "demostración log")
        tira_dado()
    }

    fun tira_dado(){
        roll_dice.setOnClickListener {
            val rand = Random.nextInt(1, 6)
            mensaje.text = "$rand tiro #${tiros++}"
        }
    }
}