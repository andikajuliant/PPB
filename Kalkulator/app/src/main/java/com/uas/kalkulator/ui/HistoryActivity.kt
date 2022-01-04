package com.uas.kalkulator.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uas.kalkulator.viewmodel.HistoryViewModel
import com.uas.kalkulator.database.History
import com.uas.kalkulator.databinding.ActivityHistoryBinding
import com.uas.kalkulator.helper.ViewModelFactory

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val historyViewModel = obtainViewModel(this)
        historyViewModel.getAllHistory().observe(this, { historyList ->
            if (historyList.isNotEmpty()) {
                binding.apply {
                    val adapter = HistoryAdapter()
                    rvCalculator.layoutManager = LinearLayoutManager(this@HistoryActivity)
                    rvCalculator.setHasFixedSize(true)
                    adapter.setListHistory(historyList)
                    rvCalculator.adapter = adapter
                    adapter.setOnItemClickCallback(object : HistoryAdapter.IOnItemClickCallback {
                        override fun itemClicked(history: History) {
                            historyViewModel.deleteHistory(history)
                        }
                    })
                }
            } else {
                binding.apply {
                    rvCalculator.visibility = View.GONE
                    historyAnimation.visibility = View.VISIBLE
                    tvNotHistory.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun obtainViewModel(activity: AppCompatActivity): HistoryViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[HistoryViewModel::class.java]
    }
}