package com.example.mylovecalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.mylovecalculator.databinding.ItemOnboardBinding
import com.example.mylovecalculator.board.OnBoardModel

class OnBoardAdapter(private val list: ArrayList<OnBoardModel>) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {
   inner class OnBoardViewHolder(private val binding: ItemOnboardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: OnBoardModel) {
            binding.animationView.setAnimation(model.image)
            binding.tvTittle.text = model.tittle
            binding.tvDescription.text = model.description
binding.btnGo.isVisible=adapterPosition==list.size

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.onBind (list[position])
    }

    override fun getItemCount(): Int{
        return list.size
    }


}




