package com.example.spacexlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexlist.data.repository.SpaceXDataRepositoryImpl
import com.example.spacexlist.domain.EventItem
import com.example.spacexlist.domain.EventMapper
import com.example.spacexlist.domain.Interactor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoricalViewModel @Inject constructor(
   private var interactor: Interactor
) : ViewModel() {
//    private val spaceXDataRepositoryImpl: SpaceXDataRepositoryImpl = SpaceXDataRepositoryImpl()
//       private val eventMapper: EventMapper = EventMapper()
//    private var interactor: Interactor = Interactor(spaceXDataRepositoryImpl, eventMapper)

    private val _eventsList = MutableStateFlow(emptyList<EventItem>())
    val eventsList: StateFlow<List<EventItem>> = _eventsList

    fun getHistoricalEvents() {
        viewModelScope.launch {
            val list: List<EventItem> = interactor.getEventItemList()
            _eventsList.update {
                list
            }
        }
    }
}