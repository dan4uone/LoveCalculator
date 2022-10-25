package com.example.mylovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.mylovecalculator.databinding.FragmentHomeBinding
import com.example.mylovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController

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

    private fun initClickers() {
        with(binding) {
            btnRequest.setOnClickListener {
                val fName = firstEt.text.toString()
                val sName = secondEt.text.toString()
                App.api.calculateName(fName,sName)
                    .enqueue(object :
                    Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            Log.e("lolol","Response:${response.body()!!.percentage}")
                            val bundle = Bundle()

                           bundle.putString("fName", response.body()?.fName)
                            bundle.putString("sName", response.body()?.sName)
                            bundle.putString("percentage", response.body()?.percentage)
                            bundle.putString("result", response.body()?.result)


                                navController.navigate(R.id.secondFragment,bundle)

                        }
                    }
                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("lolol","onFailure: ${t.message}")
                        }


                })
            }
        }
    }

}