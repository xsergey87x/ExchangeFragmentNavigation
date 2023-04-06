package com.example.testexchangefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import com.example.testexchangefragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonFirstFragment.setOnClickListener {

            val currentFragment =
                binding.fragmentContainer.findNavController().currentDestination?.id
            if (currentFragment == R.id.secondFragment) {
                binding.fragmentContainer.findNavController()
                    .navigate(R.id.action_secondFragment_to_firstFragment, null)
            }
        }

        binding.buttonSecondFragment.setOnClickListener {

            val currentFragment =
                binding.fragmentContainer.findNavController().currentDestination?.id
            if (currentFragment == R.id.firstFragment) {
                binding.fragmentContainer.findNavController()
                    .navigate(R.id.action_firstFragment_to_secondFragment, null)
            }
        }
    }
}