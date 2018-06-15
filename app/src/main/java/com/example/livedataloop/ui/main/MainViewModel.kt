package com.example.livedataloop.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val readingText = MutableLiveData<String>()

    init {
        readingText.value = "100"
    }
}
