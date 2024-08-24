package com.example.testshoppinglist.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testshoppinglist.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:MainViewModel
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            Log.d("MyShopList", it.toString())
            if(count == 0){
                count++
                val item = it[0]
                //viewModel.removeShopList(item)
                viewModel.editShopList(item)
            }
        }
    }
}
