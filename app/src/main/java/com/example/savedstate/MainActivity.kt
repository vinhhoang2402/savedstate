package com.example.savedstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private var NAME : String = "hoang"
    var bundle : Bundle?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bundle=savedInstanceState
        val viewModel  = ViewModelProvider(this)
            .get(MainViewModel::class.java)

        viewModel.saveCurrentUser("vinh113")
        viewModel.userId.observe(this, Observer {
            Log.d("vinh",it)
        })
        Log.d("vinh1",viewModel.getCurrentUser())
        val ten=bundle?.getString(NAME)
        Log.d("vinh2",ten.toString())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NAME,"vinhhoang")
    }

    fun vinh(){
        Log.d("vinh","ffffffff")
    }

    fun vinh2(){
        Log.d("vinh2","2222222222")
    }
}