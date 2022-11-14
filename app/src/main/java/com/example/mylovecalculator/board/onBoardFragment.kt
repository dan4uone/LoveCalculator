package com.example.mylovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.mylovecalculator.databinding.FragmentOnBoardBinding
import com.example.mylovecalculator.board.OnBoardModel
import com.example.mylovecalculator.prefs.Prefs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(){

    private lateinit var binding: FragmentOnBoardBinding
    private val list = arrayListOf<OnBoardModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.add(
            OnBoardModel(
                R.drawable.love_calculate1,
                " hello",
                " hi"
            )
        )
        list.add(
            OnBoardModel(
                R.drawable.love_calculate2,
                "any",
                "go"
            )
        )
        list.add(
            OnBoardModel(
                R.drawable.love_calculate3,
                "text",
                "net",

            )

        )
        list.add(
            OnBoardModel(
                R.drawable.love_calculate1,
                "text",
                "" +
                        "look"
            )
        )
        binding.vpOnBoarding.adapter = OnBoardAdapter(list)
        binding.dotsIndicator.attachTo(binding.vpOnBoarding)
    }




}

