package com.example.splashscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class companyAdapter(private val companylist: List<company>): RecyclerView.Adapter<companyAdapter.companyViewHolder>() {

    class companyViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        val companyimgView: ImageView =itemView.findViewById(R.id.imgcompany)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): companyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.company_row,parent,false)
        return companyViewHolder(view)
    }

    override fun onBindViewHolder(holder: companyViewHolder, position: Int) {
        val company=companylist[position]
        holder.companyimgView.setImageResource(company.companyimg)
    }

    override fun getItemCount(): Int {
        return companylist.size
    }
}