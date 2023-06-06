package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapp.constance.Constance
import com.example.myfirstapp.constance.ImageList
import com.example.myfirstapp.databinding.ActivityCreateCharacterBinding
import com.example.myfirstapp.databinding.ActivityMainBinding

class CreateCharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCharacterBinding
    private var imageIndex = 0
    private var imageId = ImageList.IMAGES[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        bPrevious.setOnClickListener {
            imageIndex--
            if(imageIndex<0) imageIndex = ImageList.IMAGES.size-1
            imageId = ImageList.IMAGES[imageIndex]
            imageView2.setImageResource(imageId)
        }
        bNext.setOnClickListener {
            imageIndex++
            if(imageIndex > ImageList.IMAGES.size-1 ) imageIndex = 0
            imageId = ImageList.IMAGES[imageIndex]
            imageView2.setImageResource(imageId)
        }
        bDone.setOnClickListener {
            val character = Character(imageId, edTitle.text.toString())
            val characterCreationIntent = Intent().apply {
                putExtra(Constance.INTENT_USER_CREATION, character)
            }
            setResult(RESULT_OK, characterCreationIntent)
            finish()
        }
    }
}