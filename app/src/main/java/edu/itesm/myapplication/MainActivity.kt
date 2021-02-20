package edu.itesm.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var tiros = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("edu.itesm.daec", "demostración log")
        mensaje.text ="Inicio"

        tira_dado()
    }

    fun tira_dado(){
        var cont1 = 0
        var cont2 = 0
            roll_dice.setOnClickListener {
                if (tiros <= 6) {
                    var jugador: Int
                    val rand = Random.nextInt(1, 7)
                    if (tiros.rem(2) == 1) {
                        jugador = 1
                        cont1 += rand
                    } else {
                        jugador = 2
                        cont2 += rand
                    }
                    mensaje.text = "Jugador: $jugador, Tiro #${tiros++}: $rand"
                } else {
                    if (cont1 > cont2){
                        mensaje.text ="Gana el Jugador 1: $cont1"
                    } else if (cont1 < cont2){
                        mensaje.text ="Gana el Jugador 2: $cont2"
                    } else {
                        mensaje.text ="Empate"
                    }
                    tiros = 1
                    cont1 = 0
                    cont2 = 0
                }
            }
    }
}
