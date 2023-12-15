package com.sharkdroid.bmicalculator

import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sharkdroid.bmicalculator.ui.theme.BMICalculatorTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        locating UI Button,views, etc

        val btnCalculate=findViewById<Button>(R.id.BtnCalculate)
        val weightTxt=findViewById<EditText>(R.id.editWeight)
        val heightTxtF=findViewById<EditText>(R.id.editHeight_F)
        val heightTxtIn=findViewById<EditText>(R.id.editHeight_IN)
        val resultView=findViewById<TextView>(R.id.textResult)
        val main=findViewById<LinearLayout>(R.id.llMain)

        btnCalculate.setOnClickListener{

            if(!weightTxt.text.toString().equals("") && ! heightTxtF.text.toString().equals("") && ! heightTxtIn.text.toString().equals("") ){

//                Setting value to variable

               val wt = (weightTxt.text.toString()).toDouble()
                val htF=(heightTxtF.text.toString()).toDouble()
                val htIn=(heightTxtIn.text.toString()).toDouble()

                val totalInch=(htF*12) + htIn
                val totalCm=totalInch*2.54

                val totalMeter=totalCm/100

                val bmi=wt/(totalMeter*totalMeter)

                resultView.text = "${bmi.toInt()}"

                when {
                    bmi > 25 -> {

                        Toast.makeText(applicationContext, "You are over Weight", Toast.LENGTH_SHORT).show()
                        main.setBackgroundColor(resources.getColor(R.color.Red))
                    }
                    bmi < 18 -> {

                        Toast.makeText(applicationContext, "You are under Weight", Toast.LENGTH_SHORT).show()
                        main.setBackgroundColor(resources.getColor(R.color.Yellow))
                    }
                    else -> {

                        Toast.makeText(applicationContext, "You are Healthy", Toast.LENGTH_SHORT).show()
                        main.setBackgroundColor(resources.getColor(R.color.Green))
                    }
                }

            }else{

                Toast.makeText(applicationContext, "Please fill up the required blanks !", Toast.LENGTH_SHORT).show()
            }
        }



    }
}

