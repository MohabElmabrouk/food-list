package com.example.foodlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.foodlist.databinding.FragmentFragmentsettingsBinding


class Fragmentsettings : Fragment(R.layout.fragment_fragmentsettings) {
    private var _binding: FragmentFragmentsettingsBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding =  FragmentFragmentsettingsBinding.bind(view)

       val pref = MySharedPref(requireContext())

       binding.run {
           savebutton.setOnClickListener {
               if (LargeButton.isChecked) {
                   pref.saveUserinf(80f)

               } else if (MidButton.isChecked) {
                   pref.saveUserinf(50f)

               } else {
                   pref.saveUserinf(20f)
               }
            Toast.makeText(context,"font is saved",Toast.LENGTH_LONG).show()
           }
       }

    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}