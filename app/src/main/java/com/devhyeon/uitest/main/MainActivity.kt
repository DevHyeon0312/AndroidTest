package com.devhyeon.uitest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.devhyeon.uitest.R
import com.devhyeon.uitest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityMainBinding
    val binding : ActivityMainBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity
        binding.lifecycleOwner = this@MainActivity
    }

    fun textChange() {
        binding.textView.text = "DevHyeon"
    }
}