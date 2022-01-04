package com.uas.kalkulator.helper

import androidx.recyclerview.widget.DiffUtil
import com.uas.kalkulator.database.History

class HistoryDiffCallback(
    private val mOldHistoryList: List<History>,
    private val mNewHistoryList: List<History>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldHistoryList.size
    }

    override fun getNewListSize(): Int {
        return mNewHistoryList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldHistoryList[oldItemPosition].id == mNewHistoryList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldHistory = mOldHistoryList[oldItemPosition]
        val newHistory = mNewHistoryList[newItemPosition]

        return oldHistory.numberOne == newHistory.numberOne &&
                oldHistory.numberTwo == newHistory.numberTwo
                && oldHistory.operator == newHistory.operator &&
                oldHistory.result == newHistory.result
    }
}