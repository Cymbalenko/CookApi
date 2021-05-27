package com.example.cookapi.ua.dish.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cookapi.R
import com.example.cookapi.model.api.responses.Recept
import com.example.cookapi.module.AppNameGlideModule
import com.google.android.material.textview.MaterialTextView

class DishAdapter(
    private val clickListener: (Recept) -> Unit
) : ListAdapter<Recept, DishAdapter.DishViewHolder>(DishDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return DishViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        getItem(position)?.let { dish ->
            holder.bind(dish,holder)
        }
    }

    class DishViewHolder(
        itemView: View,
        private val clickListener: (Recept) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(recept: Recept,holder: DishViewHolder) {

            itemView.setOnClickListener {
                clickListener(recept)
            }

            val dishEditText = itemView.findViewById<MaterialTextView>(R.id.disg_description_textview)
            val dishImageView = itemView.findViewById<ImageView>(R.id.image_view)
            dishEditText.setText(recept.title.trim().toString())
            Glide .with(holder.itemView.getContext())
                .load(recept.imageUrl)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_image_error)
                .centerCrop()
                .into(dishImageView)

        }
    }

    class DishDiffUtil : DiffUtil.ItemCallback<Recept>() {
        override fun areItemsTheSame(oldItem: Recept, newItem: Recept): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recept, newItem: Recept): Boolean {
            return oldItem == newItem
        }
    }
}