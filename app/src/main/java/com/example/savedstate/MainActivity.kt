package com.example.savedstate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)

        click.setOnClickListener {
            viewModel.saveCurrentUserState("vinh113")
            viewModel.saveCurrentUserViewModel("hoang")
        }
        viewModel.name.observe(this, Observer {
            nameViewModel.text = it
        })

        viewModel.getCurrentUser().observe(this, Observer {
            nameState.text = it
        })
    }
}