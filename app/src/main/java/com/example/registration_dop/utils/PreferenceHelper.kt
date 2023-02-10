package com.example.registration_dop.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }

    var saveName: String?
        get() = sharedPreferences.getString("key", "")
        set(value) = sharedPreferences.edit().putString("key", value).apply()

    var savePassword: String?
        get() = sharedPreferences.getString("admin", "")
        set(value) = sharedPreferences.edit().putString("admin", value).apply()
}