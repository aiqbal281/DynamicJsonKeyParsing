package com.aadil.assingment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aadil.assingment.R
import com.aadil.assingment.databinding.TeamRowItemBinding
import com.aadil.assingment.models.TeamDetail
import kotlinx.android.synthetic.main.team_row_item.view.*

class HeatAdapter(private val teamDetail: List<TeamDetail>) :
    RecyclerView.Adapter<HeatAdapter.MyViewHolder>() {

    override fun getItemCount(): Int = teamDetail.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.team_row_item,
        parent,
        false)
    )


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        when {
            teamDetail[position].Iscaptain!= null && teamDetail[position].Iscaptain!! -> holder.txtPlayers.text = teamDetail[position].Name_Full + " (C)"
            teamDetail[position].Iskeeper!= null && teamDetail[position].Iskeeper!! -> holder.txtPlayers.text = teamDetail[position].Name_Full + " (WK)"
            else -> holder.txtPlayers.text = teamDetail[position].Name_Full
        }
    }

    class MyViewHolder(recylerViewTeamRowItemBinding: TeamRowItemBinding) : RecyclerView.ViewHolder(recylerViewTeamRowItemBinding.root) {
        val txtPlayers : TextView = itemView.txtPlayers

    }
}