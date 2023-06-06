package com.example.myfirstapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myfirstapp.databinding.ActivityMainBinding
import com.example.myfirstapp.databinding.ActivityResoursesBinding
import com.example.myfirstapp.databinding.ActivitySpinnerBinding

class ResoursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityResoursesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val green = ContextCompat.getColor(this, R.color.green_apple)
        super.onCreate(savedInstanceState)
        binding = ActivityResoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.button.isEnabled = isChecked
        }
        binding.button.setOnClickListener {
            binding.button.isSelected = !binding.button.isSelected
            binding.textView2.setTextColor(green)
            binding.textView2.setText(R.string.text_view_button_clicked)
        }
    }
}