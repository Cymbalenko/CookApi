package com.example.cookapi.ua.dish.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.cookapi.R
import com.example.cookapi.ua.dish.DishFragment

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.fragments.isEmpty()) {
            addHomeFragment()
        }
    }

    private fun addHomeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DishFragment.newInstance())
            .commit()

    }
}