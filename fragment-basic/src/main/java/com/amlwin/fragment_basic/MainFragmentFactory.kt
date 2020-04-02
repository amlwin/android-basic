package com.amlwin.fragment_basic

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

/**
 * a touch of amlwin on 02/04/2020.
 * made with <3
 */

class MainFragmentFactory : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == MainFragment::class.java.name) {
            val targetFragment = loadFragmentClass(classLoader, className)
            return targetFragment.newInstance()
        }
        return super.instantiate(classLoader, className)
    }
}