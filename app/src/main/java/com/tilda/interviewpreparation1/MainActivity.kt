package com.tilda.interviewpreparation1

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleUiEvents()

        viewModel.startTimer()
    }

    private fun handleUiEvents() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEventState.collect {
                    when (it) {
                        is UiEvent.AddPriceToTheList -> {
                            // Add to the list
                            Log.d("TAG", "handleUiEvents: ${it.price.bpi?.eur?.rate}")
                        }

                        is UiEvent.ShowLoading -> {
                            // Todo
                        }

                        is UiEvent.ShowMessage -> {
                            // Todo
                        }

                        is UiEvent.HideLoading -> {
                            // Todo
                        }
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.stopTimer()
    }
}