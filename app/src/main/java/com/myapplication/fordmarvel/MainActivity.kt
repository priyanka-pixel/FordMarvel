package com.myapplication.fordmarvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapplication.fordmarvel.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: CharacterViewModel by viewModels()
    private val adapter = MovieAdapter()
lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchMarvels()
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.adapter= adapter

        viewModel.marvelLiveData.observe(this){
            Log.i("List", ""+ it.data.results.get(1).name)
              adapter.setMovies(it.data.results)
//
        }
    }
}