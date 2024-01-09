package com.example.spacexlist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spacexlist.domain.Interactor
import com.example.spacexlist.presentation.HistoricalViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val interactor: Interactor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HistoricalViewModel(
            interactor = interactor
        ) as T
    }
}
