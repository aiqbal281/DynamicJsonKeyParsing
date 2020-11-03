package com.aadil.assingment.ui.summary.heat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aadil.assingment.models.TeamDetail
import com.aadil.assingment.retrofit.TeamRepository
import com.aadil.assingment.util.Coroutines
import kotlinx.coroutines.Job
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class HeatViewModel(private val repository: TeamRepository) : ViewModel() {
    private lateinit var job: Job

    private val _teams = MutableLiveData<ResponseBody>()
    val team: LiveData<ResponseBody>
        get() = _teams

    fun getTeams() {
        job = Coroutines.ioThenMain(
            { repository.getTeam() },
            { _teams.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

//    suspend fun saveTeams(teamDetail: ArrayList<TeamDetail>) = repository.saveTeam(teamDetail)

}
