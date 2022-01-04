package com.uas.kalkulator.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.uas.kalkulator.database.History
import com.uas.kalkulator.databinding.ItemListCalculatorBinding
import com.uas.kalkulator.helper.HistoryDiffCallback

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: IOnItemClickCallback

    private val listHistory = ArrayList<History>()

    fun setOnItemClickCallback(onItemClickCallback: IOnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setListHistory(listHistory: List<History>) {
        val diffCallback = HistoryDiffCallback(this.listHistory, listHistory)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listHistory.clear()
        this.listHistory.addAll(listHistory)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemListCalculatorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: History) {
            binding.apply {
                tvNumberOne.text = history.numberOne
                tvOperator.text = history.operator
                tvNumberTwo.text = history.numberTwo
                tvResult.text = history.result
                btnDelete.setOnClickListener {
                    onItemClickCallback.itemClicked(listHistory[bindingAdapterPosition])
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ItemListCalculatorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .run {
                ViewHolder(this)
            }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHistory[position])
    }

    override fun getItemCount(): Int = listHistory.size

    interface IOnItemClickCallback {
        fun itemClicked(history: History)
    }
}