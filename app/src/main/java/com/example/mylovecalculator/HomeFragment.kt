package com.example.mylovecalculator

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
import com.example.mylovecalculator.databinding.FragmentHomeBinding



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
            btnRequest.setOnClickListener {
                viewModel.getLiveModel(firstEt.text.toString(), secondEt.text.toString())
                    .observe(this@HomeFragment, Observer { loveModel ->
                        Log.e("ololo","initClicker${loveModel}")
                        val bundle = Bundle()
                        bundle.putSerializable("key",loveModel)
                        navController.navigate(R.id.secondFragment,bundle)
                    })


            }
            /* val fName = firstEt.text.toString()
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


             })*/

        }

    }

}


