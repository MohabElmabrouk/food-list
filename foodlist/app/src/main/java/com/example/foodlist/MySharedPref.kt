package com.example.foodlist

import android.content.Context

class MySharedPref(context: Context) {

    companion object {
        private const val FILE_KEY = "user_settings"
        private const val FONT_SIZE = "font_size"
    }
    private val sharedPref = context.getSharedPreferences(FILE_KEY,Context.MODE_PRIVATE)

    fun saveUserinf(size: Float){
        sharedPref.edit()
            .putFloat(FONT_SIZE, size)
            .apply()
    }

    fun getUsersetings(): Float {
        return sharedPref.getFloat(FONT_SIZE,30f)
    }

}