package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val oneftMeter:Float = 0.3048f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
    }

    private fun calculateBMI():Float{
        var bmi = 0f

        binding.apply {
            btSubmit.setOnClickListener {
                val height:Float= etHeight.text.toString().toFloat()*oneftMeter
                Log.d("lalit", height.toString())
                val weight = etWeight.text.toString().toFloat()
                bmi = weight/(height*height)
            }
        }
        return String.format("%.1f", bmi).toFloat()
    }

    private fun showBmiResult(){

    }
}