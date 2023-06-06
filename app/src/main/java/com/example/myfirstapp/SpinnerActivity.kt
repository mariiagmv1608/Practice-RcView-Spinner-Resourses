package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.myfirstapp.constance.Constance
import com.example.myfirstapp.databinding.ActivityMainBinding
import com.example.myfirstapp.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {
    lateinit var binding: ActivitySpinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Constance.SPINNER_OPTIONS)

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.textView.text = Constance.SPINNER_OPTIONS.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.textView.text = "Please Select Item"
            }

        }
    }
}