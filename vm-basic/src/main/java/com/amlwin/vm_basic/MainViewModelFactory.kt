package com.amlwin.vm_basic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * a touch of amlwin on 07/03/2020.
 * made with <3
 */

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }
}