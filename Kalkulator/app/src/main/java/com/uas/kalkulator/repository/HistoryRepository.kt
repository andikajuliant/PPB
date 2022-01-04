package com.uas.kalkulator.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.uas.kalkulator.database.History
import com.uas.kalkulator.database.HistoryDao
import com.uas.kalkulator.database.HistoryDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class HistoryRepository(application: Application) {
    private val mHistoryDao: HistoryDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = HistoryDatabase.getDatabase(application)
        mHistoryDao = db.historyDao()
    }

    fun insertHistory(history: History) {
        executorService.execute {
            mHistoryDao.insertHistory(history)
        }
    }

    fun deleteHistory(history: History) {
        executorService.execute {
            mHistoryDao.deleteHistory(history)
        }
    }

    fun getAllHistory(): LiveData<List<History>> = mHistoryDao.getAllHistory()
}