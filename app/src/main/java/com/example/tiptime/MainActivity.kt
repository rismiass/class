package com.example.tiptime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.tiptime.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cost = binding.editCost
        val round = binding.roundup
        val group = binding.radiogroup
        val res = binding.result

        binding.button1.setOnClickListener {
            var text = 0.0
            when (group.checkedRadioButtonId) {
                binding.excellent.id -> text = cost.text.toString().toInt() * 0.2
                binding.good.id -> text = cost.text.toString().toInt() * 0.18
                binding.ok.id -> text = cost.text.toString().toInt() * 0.15
            }
            if (round.isChecked) {
                text = ceil(text)
            }
            res.text = "Величина чаевых:$text"
        }



    }
}