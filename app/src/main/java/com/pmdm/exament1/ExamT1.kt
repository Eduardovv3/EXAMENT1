package com.pmdm.exament1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatEditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExamT1 : AppCompatActivity() {
    //He intentado pasar el nombre pero no se el fallo de porque no me da el nombre y los botones de la hora no me ha dado tiempo ha intentar hacerlo

    private var is_2_asientos: Boolean = true
    private var is_4_asientos: Boolean = true
    private var is_8_asientos: Boolean = true
    private var personas: String = ""
    private var name: String = ""
    private var hora: String = "21:00"

    private lateinit var mesa_2_asientos: CardView
    private lateinit var mesa_4_asientos: CardView
    private lateinit var mesa_8_asientos: CardView
    private lateinit var horaMenos: FloatingActionButton
    private lateinit var horaMas: FloatingActionButton
    private lateinit var check: FloatingActionButton





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_t1)
        val etName: AppCompatEditText = findViewById(R.id.etName)
        name = etName.text.toString()
        initComponents()
        initListeners()
    }


    private fun initComponents(){
        mesa_2_asientos = findViewById(R.id.mesa_2_asientos)
        mesa_4_asientos = findViewById(R.id.mesa_4_asientos)
        mesa_8_asientos = findViewById(R.id.mesa_8_asientos)
        horaMenos = findViewById(R.id.horaMenos)
        horaMas = findViewById(R.id.horaMas)
        check = findViewById(R.id.check)

    }

    private fun initListeners(){
        mesa_2_asientos.setOnClickListener() {
            is_2_asientos = true
            is_4_asientos = false
            is_8_asientos = false
            setGenderColor()
            personas = "2 personas"
        }
        mesa_4_asientos.setOnClickListener() {
            is_2_asientos = false
            is_4_asientos = true
            is_8_asientos = false
            setGenderColor()
            personas = "4 personas"
        }
        mesa_8_asientos.setOnClickListener() {
            is_2_asientos = false
            is_4_asientos = false
            is_8_asientos = true
            setGenderColor()
            personas = "8 personas"
        }
        horaMenos.setOnClickListener {

        }
        horaMas.setOnClickListener {

        }
        check.setOnClickListener {
            nextActivity()
        }
    }

    private fun setGenderColor(){
        val FColorT = R.color.elemento_selec
        val FColorF = R.color.elemento
        if (is_2_asientos == true){
            mesa_2_asientos.setCardBackgroundColor(ContextCompat.getColor(this,FColorT))
            mesa_4_asientos.setCardBackgroundColor(ContextCompat.getColor(this,FColorF))
            mesa_8_asientos.setCardBackgroundColor(ContextCompat.getColor(this,FColorF))
        }else if(is_4_asientos == true){
            mesa_2_asientos.setCardBackgroundColor(ContextCompat.getColor(this,FColorF))
            mesa_4_asientos.setCardBackgroundColor(ContextCompat.getColor(this,FColorT))
            mesa_8_asientos.setCardBackgroundColor(ContextCompat.getColor(this,FColorF))
        }else{
            mesa_2_asientos.setCardBackgroundColor(ContextCompat.getColor(this,FColorF))
            mesa_4_asientos.setCardBackgroundColor(ContextCompat.getColor(this,FColorF))
            mesa_8_asientos.setCardBackgroundColor(ContextCompat.getColor(this,FColorT))
        }
    }


    private fun nextActivity(){
        val intentGA = Intent(this, Resultado::class.java)
        intentGA.putExtra("name", name)
        intentGA.putExtra("personas", personas)
        intentGA.putExtra("hora", hora)
        startActivity(intentGA)
    }


}