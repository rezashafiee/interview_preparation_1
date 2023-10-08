package com.tilda.interviewpreparation1

import com.tilda.data.Price

sealed class UiEvent {
    data class AddPriceToTheList(val price: Price) : UiEvent()
    data class ShowMessage(val message: String) : UiEvent()
    data object ShowLoading : UiEvent()
    data object HideLoading : UiEvent()
}