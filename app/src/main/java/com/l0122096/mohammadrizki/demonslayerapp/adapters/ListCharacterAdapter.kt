package com.l0122096.mohammadrizki.demonslayerapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122096.mohammadrizki.demonslayerapp.model.Character
import com.l0122096.mohammadrizki.demonslayerapp.R

class ListCharacterAdapter(private val listCharacter: ArrayList<Character>) : RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoImageView: ImageView = itemView.findViewById(R.id.img_item_photo)
        val nameTextView: TextView = itemView.findViewById(R.id.tv_item_name)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCharacter.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, img) = listCharacter[position]
        holder.photoImageView.setImageResource(img)
        holder.nameTextView.text = name
        holder.descriptionTextView.text = desc
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listCharacter[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Character)
    }
}