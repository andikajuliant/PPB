package com.uas.kalkulator.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uas.kalkulator.database.History
import com.uas.kalkulator.repository.HistoryRepository

class HistoryViewModel(application: Application) : ViewModel() {
    private val mHistoryRepository: HistoryRepository = HistoryRepository(application)

    fun getAllHistory(): LiveData<List<History>> = mHistoryRepository.getAllHistory()

    fun deleteHistory(history: History) {
        mHistoryRepository.deleteHistory(history)
    }
}