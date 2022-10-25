package com.example.mylovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mylovecalculator.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)
        argumentsAndSet()
        initClick()
    }

    private fun initClick() {
        binding.tryAgainBtn.setOnClickListener{
            navController.navigateUp()
        }
    }

    private fun argumentsAndSet() {
        val fName = arguments?.getString("fName")
        val sName = arguments?.getString("sName")
        val percent = arguments?.getString("percentage")
        val result = arguments?.getString("result")


        binding.firstName.text = fName
        binding.secondName.text = sName
        binding.percent.text = "$percent%"
        binding.result.text = result

    }


}