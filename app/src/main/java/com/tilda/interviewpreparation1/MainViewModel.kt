package com.tilda.interviewpreparation1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilda.data.Api
import com.tilda.data.Repository
import com.tilda.data.RetrofitObject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private lateinit var timer: Job

    private val _uiEventState = MutableStateFlow<UiEvent>(UiEvent.HideLoading)
    val uiEventState: Flow<UiEvent> = _uiEventState

    private suspend fun getPrice() {
        val api = RetrofitObject.getInstance().create(Api::class.java)
        val price = repository.getPrice(api)
        _uiEventState.update {
            UiEvent.AddPriceToTheList(price)
        }
    }

    fun startTimer() {
        timer = viewModelScope.launch {
            flow {
                emit(Unit)
                while (true) {
                    delay(timeMillis = 10000)
                    emit(Unit)
                }
            }.collect {
                showLoading()
                getPrice()
                hideLoading()
            }
        }
    }

    fun stopTimer() {
        if (this::timer.isInitialized && timer.isActive) {
            timer.cancel()
        }
    }

    private fun showLoading() {
        _uiEventState.value = UiEvent.ShowLoading
    }

    private fun hideLoading() {
        _uiEventState.value = UiEvent.HideLoading
    }
}