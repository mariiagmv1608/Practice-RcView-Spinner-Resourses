package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myfirstapp.constance.Constance
import com.example.myfirstapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = CharacterAdapter()
    private var launcher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
               adapter.addCharacter(it.data?.getSerializableExtra(Constance.INTENT_USER_CREATION ) as Character )
            }
        }

        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
            addButton.setOnClickListener {
                launcher?.launch(Intent(this@MainActivity, CreateCharacterActivity::class.java))
            }
        }
    }


}