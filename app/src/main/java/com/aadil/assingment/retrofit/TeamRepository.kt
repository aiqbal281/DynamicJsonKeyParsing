package com.aadil.assingment.retrofit

import com.aadil.assingment.db.AppDatabase


class TeamRepository(
    private val api: CommonApi
) : SafeApiRequest() {

    private val db: AppDatabase? = null


    suspend fun getTeam() = apiRequest { api.getTeam() }

//    suspend fun saveTeam(teamDetail: ArrayList<TeamDetail>) = db!!.getTeamDo().upsert(teamDetail)

//    fun getTeamData() = db!!.getTeamDo().getTeams()

}