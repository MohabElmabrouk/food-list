package com.example.foodlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.foodlist.databinding.FragmentFoodBinding
import com.example.foodlist.databinding.FragmentFoodDetailsBinding


class food_Details : Fragment(R.layout.fragment_food__details) {
    private var _binding: FragmentFoodDetailsBinding ?= null
    private val binding get() = _binding!!
    private val args by navArgs<food_DetailsArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodDetailsBinding.bind(view)
//Toast.makeText(requireContext(),"$args",Toast.LENGTH_LONG).show()
binding.textView.text=args.type
        binding.imageView.load(args.imgedetails)

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}