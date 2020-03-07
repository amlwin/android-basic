package com.amlwin.vm_basic

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * a touch of amlwin on 07/03/2020.
 * made with <3
 */

class MainViewModel : ViewModel() {
    val inputData = MutableLiveData<String>()

    fun setData(data: String) {
        Log.d("MainViewModel", "data is $data")
        inputData.value = data
    }
}