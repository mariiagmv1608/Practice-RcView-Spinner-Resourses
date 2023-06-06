package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.databinding.CharacterItemBinding


class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {
    val characters = ArrayList<Character>()

    class CharacterHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = CharacterItemBinding.bind(item)
        fun bind(character: Character) = with(binding){
            imageView.setImageResource(character.imageId)
            textViewTitle.text = character.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterHolder(view)
    } //используется тогда, когда нужно создать новый элемент. основной параметр - праент, с которого мы можем взять контекст

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(characters[position])
    } //используется, чтоб обновить элемент списка. приходит позиция по которой мы можем взять элемент списка и холдер, который это отрисует

    override fun getItemCount(): Int {
        return characters.size
    }

    fun addCharacter(character: Character){
        characters.add(character)
        notifyDataSetChanged()
    }
}

