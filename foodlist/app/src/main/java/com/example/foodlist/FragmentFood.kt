package com.example.foodlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import com.example.foodlist.databinding.FragmentFoodBinding
import com.example.recyclerviewapplication.Food
import com.example.recyclerviewapplication.FoodAdapter

class FragmentFood : Fragment(R.layout.fragment_food) {
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)

        var ffood = MySharedPref(requireContext())
        binding.textView2.textSize = ffood.getUsersetings()
        val list = mutableListOf(
            Food("pizza", R.drawable.baseline_local_pizza_24),
            Food("fast food", R.drawable.baseline_fastfood_24),
            Food("burger", R.drawable.lunch_dining_fill0_wght400_grad0_opsz48),
            Food("fish", R.drawable.set_meal_fill0_wght400_grad0_opsz48),
            Food("rice", R.drawable.rice_bowl_fill0_wght400_grad0_opsz48),
            Food("eggs", R.drawable.egg_fill0_wght400_grad0_opsz48),
            Food("kabab", R.drawable.kebab_dining_fill0_wght400_grad0_opsz48),
            )
        val adapter = FoodAdapter(){
            var action = FragmentFoodDirections.actionFragmentFoodToFoodDetails(it.imageUrl,it.name)
            view.findNavController().navigate(action)
        }
        binding.foodlist.adapter = adapter
        adapter.submitList(list)



    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}


