package fr.dot.sephora.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import fr.dot.sephora.feature.main.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.recycler.adapter = viewModel.adapter
        binding.recycler.addItemDecoration(ProductItemDecoration())
    }

}