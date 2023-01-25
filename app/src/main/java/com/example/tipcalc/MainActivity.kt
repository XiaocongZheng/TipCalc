package com.example.tipcalc

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InfotextView.visibility = View.INVISIBLE

        SubmitButton.setOnClickListener{
            //Get total bill number
            val bill = editBillNumber.text.toString().toDouble()

            //Get Tip percentage
            val tipPercent = editTipNumber.text.toString().toDouble()

            //Calculate Tip and Total and round them to decimal
            val df = DecimalFormat("#.##")
            val total = df.format(bill * (1+tipPercent/100))
            val tip = df.format(bill * tipPercent/100)
            InfotextView.text = "Tip:\$"+tip.toString()+" Total:\$"+total.toString()
            InfotextView.visibility = View.VISIBLE
        }
    }
}