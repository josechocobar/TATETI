package com.cuty.tateti


import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var cellID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

     fun buClick(view: View) {
         //Toast.makeText(this,"no sirve PlayGame",Toast.LENGTH_SHORT).show()
        try{var buSelected = view as Button

            //Toast.makeText(this,"entro al try",Toast.LENGTH_SHORT).show()


            when (buSelected.id) {
                R.id.bu1 -> cellID = 1
                R.id.bu2 -> cellID = 2
                R.id.bu3 -> cellID = 3
                R.id.bu4 -> cellID = 4
                R.id.bu5 -> cellID = 5
                R.id.bu6 -> cellID = 6
                R.id.bu7 -> cellID = 7
                R.id.bu8 -> cellID = 8
                R.id.bu9 -> cellID = 9
            }
            PlayGame(cellID, buSelected)

        }
        catch (e:Exception){Toast.makeText(this,"no sirve el try",Toast.LENGTH_SHORT).show()}

        /*


        }
        Toast.makeText(this,"funciona buClick",Toast.LENGTH_SHORT).show()
        */



    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1




    fun PlayGame(cellID: Int, buSelected: Button) {
        if (activePlayer == 1) {
            buSelected.text = "x"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activePlayer = 2
        } else {
            buSelected.text = "o"
            buSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellID)
            activePlayer = 1
        }

        buSelected.isEnabled = false
        CheckWinner()

    }

    fun CheckWinner() {
        var winner = -1
        //fila1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        //fila2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        //fila3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        //columna1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //columna2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        //columna3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //diagonal1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        //diagonal2
        if (player1.contains(7) && player1.contains(5) && player1.contains(3)) {
            winner = 1
        }

        if (player2.contains(7) && player2.contains(5) && player2.contains(3)) {
            winner = 2
        }
    if( winner !=-1){
            if (winner==1){
                Toast.makeText(this,"Jugador 1 ganó", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Jugador 2 ganó", Toast.LENGTH_LONG).show()
            }
        //resetear()
        val intent = intent
        finish()
        startActivity(intent)

    }

    }





}

