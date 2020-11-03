package com.aadil.assingment.ui.summary.scochers

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.aadil.assingment.R
import com.aadil.assingment.adapter.HeatAdapter
import com.aadil.assingment.db.AppDatabase
import com.aadil.assingment.models.TeamDetail
import com.aadil.assingment.retrofit.CommonApi
import com.aadil.assingment.retrofit.TeamRepository
import com.aadil.assingment.ui.summary.heat.HeatViewModel
import com.aadil.assingment.ui.summary.heat.HeatViewModelFactory
import kotlinx.android.synthetic.main.heat_fragment.*
import org.json.JSONException
import org.json.JSONObject

class ScorchersFragment : Fragment() {

    private lateinit var factory: HeatViewModelFactory

    private lateinit var viewModel: HeatViewModel
    private lateinit var players: ArrayList<TeamDetail>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.scorchers_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var i = 0
        var index = 0
        players = ArrayList()
        val api = CommonApi()
        val repository = TeamRepository(api)

        factory = HeatViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(HeatViewModel::class.java)

        viewModel.getTeams()

        viewModel.team.observe(viewLifecycleOwner, Observer { teamDetail ->
            val jsonObject = JSONObject(teamDetail.string().toString())

            val teamJSONObject = jsonObject.getJSONObject("Teams")

            teamJSONObject.keys().forEach { it ->

                val teamDetailsJSONObject = teamJSONObject.getJSONObject(it)

                val playerJSONObject = teamDetailsJSONObject.getJSONObject("Players")

                if (i == index) {
                    i = 200
                    playerJSONObject.keys().forEach {
                        val playerDetailJSONObject = playerJSONObject.getJSONObject(it)

                        var teamData = TeamDetail()
                        teamData.Name_Full = playerDetailJSONObject.getString("Name_Full")

                        try {
                            teamData.Iscaptain = playerDetailJSONObject.getBoolean("Iscaptain")!!
                        } catch (e: JSONException) {

                        }

                        try {
                            teamData.Iskeeper = playerDetailJSONObject.getBoolean("Iskeeper")!!
                        }catch (e : JSONException){

                        }


                        players.add(teamData)
                    }
                    index++
                }
            }

            recylerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = HeatAdapter(players)

            }
        })
    }

}
