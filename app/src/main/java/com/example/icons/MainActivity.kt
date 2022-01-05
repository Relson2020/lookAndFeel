package com.example.icons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.icons.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButtonToggleGroup

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.toggleButton.addOnButtonCheckedListener(
            object: MaterialButtonToggleGroup.OnButtonCheckedListener {
            override fun onButtonChecked(group: MaterialButtonToggleGroup?, selectBtnInt: Int,
                isChecked: Boolean
            ) {
                val theme = when(selectBtnInt){
                    R.id.buttonDark -> AppCompatDelegate.MODE_NIGHT_YES
                    R.id.buttonLight -> AppCompatDelegate.MODE_NIGHT_NO
                    else -> {AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM}
                }
                AppCompatDelegate.setDefaultNightMode(theme)
            }
        })


    }
}