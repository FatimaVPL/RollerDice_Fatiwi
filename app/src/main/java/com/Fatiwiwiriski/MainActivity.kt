package com.Fatiwiwiriski

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etiqueta:TextView //así es en kotlin, se usa despues de esto mejor forma
    //var si puede cambiar
    lateinit var boton: Button
    lateinit var img: ImageView
    lateinit var img2: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)

      // etiqueta=findViewById(R.id.lblRoller) mejor forma
        // forma larga de crear esto
        boton = findViewById(R.id.btnClic)
        // boton.setOnClickListener(View.OnClickListener {
           // Toast.makeText(applicationContext,"Boton presionado", Toast.LENGTH_LONG).show()
        // })
        val label: TextView = findViewById(R.id.lblRoller)
        img  = findViewById(R.id.imgRoller)
        img2 = findViewById(R.id.imgRoller1)

        img.setImageResource(R.drawable.empty_dice)
        img2.setImageResource(R.drawable.empty_dice)
        val dra = resources.getDrawable(R.drawable.dice_3)
        img.setImageDrawable(dra)
        img2.setImageDrawable(dra)
        //opcion corta
        boton.setOnClickListener{
            Toast.makeText(applicationContext,"Boton presionado", Toast.LENGTH_LONG).show()
           // label.text =  getString(R.string.fatiMensaje)
           val aleatorio = diceRoller() // no es necseraio tipo esta es inmutable constante
            val aleatorio2 = diceRoller()
            label.text = "Dadito" //mejor forma
            img.setImageResource(idAleatorio(aleatorio)) // Se pued eoptener mediante el id
            img2.setImageResource(idAleatorio(aleatorio2))
        }
    }
    //nivel de la clase
    fun diceRoller(par: Int = 0): Int{ //tipo de val que devuelve
       return (1..6).random() //rango y de esos hacerlo random
    }

    fun idAleatorio(aleatorio: Int = 0): Int{ //tipo de val que devuelve
        var imgNum =  when(aleatorio){
            1 -> R.drawable.dice_1    //Se sguarda el id
            2 ->  R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5-> R.drawable.dice_5
            else -> R.drawable.dice_6  //Siempre es necesario el else
        }
        return imgNum
    }
}