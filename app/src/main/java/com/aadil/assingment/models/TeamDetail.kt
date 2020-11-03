package com.aadil.assingment.models

import androidx.room.Entity
import androidx.room.PrimaryKey


const val CURRENT_USER_ID = 0

@Entity
data class TeamDetail(
    var Name_Full: String? = null,
    var Iscaptain: Boolean? = null,
    var Iskeeper: Boolean? = null
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_USER_ID
}