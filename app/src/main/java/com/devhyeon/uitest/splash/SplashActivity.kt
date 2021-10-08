package com.devhyeon.uitest.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import com.devhyeon.uitest.R
import com.devhyeon.uitest.common.utils.isResumed
import com.devhyeon.uitest.common.viewmodels.DelayViewModel
import com.devhyeon.uitest.databinding.ActivitySplashBinding
import com.devhyeon.uitest.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var _binding : ActivitySplashBinding
    val binding : ActivitySplashBinding get() = _binding

    private val delayViewModel : DelayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this@SplashActivity
        binding.delayViewModel = delayViewModel
        addObserver()
    }

    override fun onResume() {
        super.onResume()
        delayViewModel.startDelay()
    }

    private fun addObserver() {
        delayViewModel.delay.observe(this@SplashActivity , Observer {
            if (it == true && lifecycle.isResumed()) {
                Intent(applicationContext, MainActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }
        })
    }
}