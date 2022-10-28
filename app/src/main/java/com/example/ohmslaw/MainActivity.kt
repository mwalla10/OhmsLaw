package com.example.ohmslaw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spin: Spinner = findViewById(R.id.selSpin)
        val view1: TextView = findViewById(R.id.view1)
        val view2: TextView = findViewById(R.id.view2)
        val num1: EditText = findViewById(R.id.num1)
        val num2: EditText = findViewById(R.id.num2)
        val calc: Button = findViewById(R.id.calcB)
        val result: TextView = findViewById(R.id.resV)
        var flag: String = "resistance"
        var options = arrayOf("resistance","current", "voltage")
        spin.adapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options)
        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
                if(options.get(p2) == "resistance"){
                    view1.text = options[1]
                    view2.text = options[2]
                }
                else if(options.get(p2) == "current"){
                    view1.text = options[0]
                    view2.text = options[2]
                }
                else{
                    view1.text = options[0]
                    view2.text = options[1]
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        calc.setOnClickListener { view ->
            var x: Float = num1.text.toString().toFloat()
            var y: Float = num2.text.toString().toFloat()
            if(flag == "resistance"){
                result.text = resistance(y,x).toString()
            }
            else if(flag == "current"){
                result.text = current(y,x).toString()
            }
            else{
                result.text = voltage(x,y).toString()
            }
        }


    }
}

public fun voltage(i:Float, r:Float): Float{
    return i*r;
}
public fun current(v:Float, r:Float): Float{
    return v/r;
}
public fun resistance(v:Float, i:Float):Float{
    return v/i;
}