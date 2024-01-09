package com.example.spacexlist.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.spacexlist.App
import com.example.spacexlist.R
import com.example.spacexlist.appComponent
import com.example.spacexlist.databinding.FragmentHistoricalEventsBinding
import com.example.spacexlist.di.AppComponent
import com.example.spacexlist.di.ViewModelFactory
import com.example.spacexlist.domain.EventItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoricalEventsFragment : Fragment(R.layout.fragment_historical_events) {
    private lateinit var historicalEventsAdapter: HistoricalEventsAdapter
    private lateinit var binding: FragmentHistoricalEventsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var historicalViewModel: HistoricalViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        historicalViewModel = ViewModelProvider(this, viewModelFactory)
            .get(HistoricalViewModel::class.java)

        binding = FragmentHistoricalEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historicalEventsAdapter = HistoricalEventsAdapter()
        binding.recyclerView.adapter = historicalEventsAdapter

        historicalViewModel.getHistoricalEvents()
        viewLifecycleOwner.lifecycleScope.launch {
            historicalViewModel.eventsList.collect {
                showHistoricalEvents(it)
            }
        }
    }

    private fun showHistoricalEvents(list: List<EventItem>) {
        historicalEventsAdapter.setEventsList(list)
    }
}