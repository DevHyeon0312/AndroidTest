package com.devhyeon.uitest.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _text = MutableLiveData<String>()
    val text : LiveData<String> get() = _text

    fun buttonClick() {
        _text.value = "DevHyeon"
    }
}