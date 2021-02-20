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
                    val rand = Random.nextInt(1, 7)                                     //Números random entre 1 y 6
                if (tiros.rem(2) == 1) {                                                      //Se usa el operador módulo para identificar al jugador
                        jugador = 1
                        cont1 += rand                                                               //Contador de puntuación del jugador 1
                    } else {
                        jugador = 2
                        cont2 += rand                                                               //Contador de puntuación del jugador 2
                    }
                    mensaje.text = "Jugador: $jugador, Tiro #${tiros++}: $rand"                     //Display de tiro actual
                } else {
                    if (cont1 > cont2){
                        mensaje.text ="Gana el Jugador 1: $cont1"
                    } else if (cont1 < cont2){
                        mensaje.text ="Gana el Jugador 2: $cont2"
                    } else {
                        mensaje.text ="Empate"
            }                                                                                       //Reinicio del juego
                    tiros = 1
                    cont1 = 0
                    cont2 = 0
                }
            }
    }
}
