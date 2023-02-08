package com.example.recyclerviewapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlist.FragmentFoodDirections
import com.example.foodlist.MySharedPref
import com.example.foodlist.databinding.FooditemBinding

class FoodAdapter(val onItemClick:(item:Food)->Unit) : ListAdapter<Food, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Food>() {
            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem.name == newItem.name && oldItem.imageUrl == newItem.imageUrl
            }
        }
    }

    private lateinit var binding: FooditemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = FooditemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val item = getItem(position)
            holder.bind(item)

        }
    }

    inner class ViewHolder(val itemBinding: FooditemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Food) {
            var op = MySharedPref(itemBinding.tvName.context)

            if (item.name == "pizza")
                itemBinding.tvName.setTextColor(Color.RED)


            itemBinding.tvName.text = item.name
            itemBinding.tvName.textSize = op.getUsersetings()

            itemBinding.contenarItem.setOnClickListener {
                onItemClick(item)
            }

            itemBinding.ivAvatar.setImageResource(item.imageUrl)
            itemBinding.ivAvatar.setColorFilter(Color.RED)
        }
    }
}