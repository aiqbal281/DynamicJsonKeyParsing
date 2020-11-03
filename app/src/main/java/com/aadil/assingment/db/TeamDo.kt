package com.aadil.assingment.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aadil.assingment.models.CURRENT_USER_ID
import com.aadil.assingment.models.TeamDetail

@Dao
interface TeamDo{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(teamDetail: ArrayList<TeamDetail>) : Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getTeams() : LiveData<TeamDetail>

}