package com.example.mylovecalculator.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylovecalculator.databinding.ItemHistoryBinding
import com.example.mylovecalculator.model.LoveModel

class HistoryAdapter(var list:List<LoveModel>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    class HistoryViewHolder(var binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            binding.historyFname.text = loveModel.fName
            binding.historySname.text = loveModel.sName
            binding.tvPercentage.text = loveModel.percentage
            binding.tvResult.text = loveModel.result
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )


    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
return list.size
    }
}