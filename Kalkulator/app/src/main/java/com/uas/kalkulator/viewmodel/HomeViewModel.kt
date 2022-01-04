package com.uas.kalkulator.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.uas.kalkulator.database.History
import com.uas.kalkulator.repository.HistoryRepository

class HomeViewModel(application: Application) : ViewModel() {
    private val mHistoryRepository: HistoryRepository = HistoryRepository(application)

    fun insert(history: History) {
        mHistoryRepository.insertHistory(history)
    }
}