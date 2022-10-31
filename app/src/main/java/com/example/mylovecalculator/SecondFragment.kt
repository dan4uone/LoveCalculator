package com.example.mylovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mylovecalculator.databinding.FragmentSecondBinding
import com.example.mylovecalculator.model.LoveModel

@Suppress("DEPRECATION")
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
        val model: LoveModel = arguments?.getSerializable("key") as LoveModel
        with(binding) {
            firstName.text = model.fName
            secondName.text = model.sName
            result.text = model.result
            percent.text = model.percentage

        }
    }


}