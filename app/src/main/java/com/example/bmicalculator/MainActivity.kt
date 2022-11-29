package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val oneftMeter:Float = 0.3048f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.apply {
            btSubmit.setOnClickListener {
                cvResult.visibility = View.VISIBLE
                showBmiResult()
            }
        }

    }

    private fun calculateBMI():Float{
        var bmi = 0f

        binding.apply {
            btSubmit.setOnClickListener {
                val height:Float= etHeight.text.toString().toFloat()*oneftMeter
                val weight = etWeight.text.toString().toFloat()
                bmi = weight/(height*height)
            }
        }
        return bmi
    }

    private fun showBmiResult(){
        val bmiValue =  calculateBMI()
        Log.d("lalit", bmiValue.toString())
        if(bmiValue < 18.5) {
            binding.apply {
                tvBmiValue.text = bmiValue.toString()
                tvBmiValue.setTextColor(Color.parseColor("#FF0000"))
            }
        }
    }
}