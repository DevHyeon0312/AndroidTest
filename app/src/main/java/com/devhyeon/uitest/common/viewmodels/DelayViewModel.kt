package com.devhyeon.uitest.common.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DelayViewModel : ViewModel() {
    val delayTime = 2000L
    private var _delay = MutableLiveData<Boolean>(false)
    val delay : LiveData<Boolean> get() = _delay

    fun startDelay() {
        _delay.postValue(false)
        CoroutineScope(Dispatchers.Main).launch {
            delay(delayTime)
            _delay.postValue(true)
        }
    }
}