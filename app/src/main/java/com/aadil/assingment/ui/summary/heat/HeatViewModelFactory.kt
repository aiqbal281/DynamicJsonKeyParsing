package com.aadil.assingment.ui.summary.heat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aadil.assingment.retrofit.TeamRepository

class HeatViewModelFactory(private val repository: TeamRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HeatViewModel(repository) as T
    }
}