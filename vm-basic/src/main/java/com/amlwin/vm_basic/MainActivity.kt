package com.amlwin.vm_basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var vmFactory: MainViewModelFactory
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vmFactory = MainViewModelFactory()
        vm = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]

        vm.inputData.observe(this, Observer {
            tv_title.text = it
        })

        btn_submit.setOnClickListener {
            vm.setData(et_input.text.toString())
        }

    }
}
