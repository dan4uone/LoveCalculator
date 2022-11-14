package com.example.mylovecalculator.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mylovecalculator.App
import com.example.mylovecalculator.databinding.FragmentHistoryBinding
import com.example.mylovecalculator.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class HistoryFragment : Fragment() {
private lateinit var adapter: HistoryAdapter
    private lateinit var binding: FragmentHistoryBinding
//lateinit var SharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showHistory()

    }
    @SuppressLint("FragmentLiveDataObserve")
   private fun showHistory(){
        App.appDataBase.loveDao().getLove().observe(this, Observer{ historyList->
            var history = ""
            historyList.forEach{model->
                history += "${model.fName}\n${model.sName}\n${model.percentage}\n${model.result}"
                App.appDataBase.loveDao().sort().observe(viewLifecycleOwner){
                    adapter = HistoryAdapter(it)
                    binding.rvHistory.adapter = this.adapter
                    Log.e("ololo","initClicker")
                }




            }

        })

    }

}