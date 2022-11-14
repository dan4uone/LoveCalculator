package com.example.mylovecalculator.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mylovecalculator.App
import com.example.mylovecalculator.R
import com.example.mylovecalculator.databinding.FragmentHomeBinding
import com.example.mylovecalculator.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        navController = NavHostFragment.findNavController(this)

    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun initClickers() {
        with(binding) {
             btnHistory.setOnClickListener{

                navController.navigate(R.id.historyFragment)
        }
            btnRequest.setOnClickListener {
                viewModel.getLiveModel(firstEt.text.toString(), secondEt.text.toString())
                    .observe(this@HomeFragment, Observer { loveModel ->
                        Log.e("ololo", "initClicker${loveModel}")
                        App.appDataBase.loveDao().insert(loveModel)
                       val bundle = Bundle()
                        bundle.putSerializable("key", loveModel)
                        navController.navigate(R.id.secondFragment, bundle)
                    })


            }


        }

    }

}


