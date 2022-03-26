package com.example.bookshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val priceTV: TextView=findViewById(R.id.bookPrice)
        val button: Button=findViewById(R.id.buttonBT)

        var flag: String="book"
        var flag2: String= "method"


        val spinnerVal:Spinner=findViewById(R.id.spSelect)
        val spinnerVal2: Spinner=findViewById(R.id.spSelect2)

        var options= arrayOf("Bulletproof Problem Solving","Atomic Habits","The Wok","Atlas of the Heart")
        var methods= arrayOf("Rent 2 weeks","Rent 1 month","Rent 3 months","Buy book")

        spinnerVal.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        spinnerVal2.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,methods)

        spinnerVal.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag= options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spinnerVal2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag2= methods.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        var price: Float= 0F

        button.setOnClickListener {
            if(flag=="Bulletproof Problem Solving") price= 20.66F
            else if(flag=="Atomic Habits") price= 27.00F
            else if(flag=="The Wok") price=31.22F
            else price=23.56F

            if(flag2=="Rent 2 weeks") price= (price*0.10).toFloat()
            else if(flag2=="Rent 1 month") price= (price*0.20).toFloat()
            else if(flag2=="Rent 3 months") price= (price*0.30).toFloat()

            priceTV.text=price.toString()+ "$"


        }




    }
}