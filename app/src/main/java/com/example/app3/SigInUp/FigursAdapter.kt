package com.example.app3.SigInUp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app3.R
import com.example.app3.databinding.FigursBinding

class FigursAdapter : RecyclerView.Adapter<FigursAdapter.FigursHolder>() {

    val figursList = ArrayList<Figurs_Item>()

    class FigursHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val binding =FigursBinding.bind(itemView)
            fun bind(figurs: Figurs_Item)= with(binding){
                    imfigure.setImageResource(figurs.img)
                    namesScore.text="${figurs.name}. Score=${figurs.score}"
            }
    }
//вА
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FigursHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.figurs,parent,false)
        return FigursHolder(view)
    }

    override fun onBindViewHolder(holder: FigursHolder, position: Int) {
        holder.bind(figursList[position])
    }

    override fun getItemCount(): Int {
        return figursList.size
    }

    fun addFigurs(figurs: Figurs_Item){
        figursList.add(figurs)
        notifyDataSetChanged()
    }

}