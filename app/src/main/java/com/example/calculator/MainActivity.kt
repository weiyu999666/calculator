package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        var flag : String = "sum"
        val spinnerVal : Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("sum","multiply","minus","divide")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{ view ->
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();

            //I used when statement here
            when (flag =="sum") {
                true -> resultTV.text = sum(x,y).toString()
                false -> print("Nothing to do here")
            }
            when (flag =="multiply") {
                true -> resultTV.text = multiply(x,y).toString()
                false -> print("Nothing to do here")
            }
            when (flag =="minus") {
                true -> resultTV.text = minus(x,y).toString()
                false -> print("Nothing to do here")
            }
            when (flag =="divide") {
                true -> resultTV.text = divide(x,y).toString()
                false -> print("Nothing to do here")
            }

        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }





}



fun sum(a: Int, b: Int): Int {
    return a+b
}
fun multiply(a: Int, b: Int): Int {
    return a*b
}
fun minus(a: Int, b: Int): Int {
    return a-b
}
fun divide(a: Int, b: Int): Int {
    return a/b
}

