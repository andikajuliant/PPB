package com.uas.kalkulator.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.uas.kalkulator.viewmodel.HomeViewModel
import com.uas.kalkulator.R
import com.uas.kalkulator.database.History
import com.uas.kalkulator.databinding.ActivityHomeBinding
import com.uas.kalkulator.helper.ViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var calculationResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        calculationResult = binding.tvResult

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            calculationResult.text = result
        }

        homeViewModel = obtainViewModel(this)

        binding.btnHistory.setOnClickListener {
            Intent(this, HistoryActivity::class.java).apply {
                startActivity(this)
            }
        }

        val operators = resources.getStringArray(R.array.operators)
        val spinner = binding.spinnerOperators
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, operators)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        binding.apply {
                            btnCalculate.setOnClickListener {
                                val numberOne = edtInputOne.text.toString().trim()
                                val numberTwo = edtInputTwo.text.toString().trim()

                                if (numberOne.isEmpty()) {
                                    edtInputOne.error =
                                        resources.getString(R.string.field_cannot_be_empty)
                                }

                                if (numberTwo.isEmpty()) {
                                    edtInputTwo.error =
                                        resources.getString(R.string.field_cannot_be_empty)
                                }

                                if (numberOne.isNotEmpty() && numberTwo.isNotEmpty()) {
                                    val result = numberOne.toDouble() + numberTwo.toDouble()
                                    calculationResult.text = result.toString()

                                    val history = History(
                                        numberOne = numberOne,
                                        operator = "+",
                                        numberTwo = numberTwo,
                                        result = result.toString()
                                    )

                                    homeViewModel.insert(history)
                                }
                            }
                        }
                    }
                    1 -> {
                        binding.apply {
                            btnCalculate.setOnClickListener {
                                val numberOne = edtInputOne.text.toString().trim()
                                val numberTwo = edtInputTwo.text.toString().trim()

                                if (numberOne.isEmpty()) {
                                    edtInputOne.error =
                                        resources.getString(R.string.field_cannot_be_empty)
                                }

                                if (numberTwo.isEmpty()) {
                                    edtInputTwo.error =
                                        resources.getString(R.string.field_cannot_be_empty)
                                }

                                if (numberOne.isNotEmpty() && numberTwo.isNotEmpty()) {
                                    val result = numberOne.toDouble() - numberTwo.toDouble()
                                    calculationResult.text = result.toString()

                                    val history = History(
                                        numberOne = numberOne,
                                        operator = "-",
                                        numberTwo = numberTwo,
                                        result = result.toString()
                                    )

                                    homeViewModel.insert(history)
                                }
                            }
                        }
                    }
                    2 -> {
                        binding.apply {
                            btnCalculate.setOnClickListener {
                                val numberOne = edtInputOne.text.toString().trim()
                                val numberTwo = edtInputTwo.text.toString().trim()

                                if (numberOne.isEmpty()) {
                                    edtInputOne.error =
                                        resources.getString(R.string.field_cannot_be_empty)
                                }

                                if (numberTwo.isEmpty()) {
                                    edtInputTwo.error =
                                        resources.getString(R.string.field_cannot_be_empty)
                                }

                                if (numberOne.isNotEmpty() && numberTwo.isNotEmpty()) {
                                    val result = numberOne.toDouble() * numberTwo.toDouble()
                                    calculationResult.text = result.toString()

                                    val history = History(
                                        numberOne = numberOne,
                                        operator = "*",
                                        numberTwo = numberTwo,
                                        result = result.toString()
                                    )

                                    homeViewModel.insert(history)
                                }
                            }
                        }
                    }
                    3 -> {
                        binding.apply {
                            btnCalculate.setOnClickListener {
                                val numberOne = edtInputOne.text.toString().trim()
                                val numberTwo = edtInputTwo.text.toString().trim()

                                if (numberOne.isEmpty()) {
                                    edtInputOne.error =
                                        resources.getString(R.string.field_cannot_be_empty)
                                }

                                if (numberTwo.isEmpty()) {
                                    edtInputTwo.error =
                                        resources.getString(R.string.field_cannot_be_empty)
                                }

                                if (numberOne.isNotEmpty() && numberTwo.isNotEmpty()) {
                                    val result = numberOne.toDouble() / numberTwo.toDouble()
                                    calculationResult.text = result.toString()

                                    val history = History(
                                        numberOne = numberOne,
                                        operator = "/",
                                        numberTwo = numberTwo,
                                        result = result.toString()
                                    )

                                    homeViewModel.insert(history)
                                }
                            }
                        }
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): HomeViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[HomeViewModel::class.java]
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, calculationResult.text.toString())
    }

    companion object {
        private const val STATE_RESULT = "state_result"
    }
}