package com.example.apkbelajar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apkbelajar.R
import com.example.apkbelajar.models.Beruang

class AdapterAngkaGames(val listAngka: ArrayList<Beruang>) :
    RecyclerView.Adapter<AdapterAngkaGames.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_belajar, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (angka) = listAngka[position]
        holder.imgBelajar.setImageResource(R.drawable.answer_right)
        holder.txtAngka.text = angka.toString()
    }

    override fun getItemCount(): Int {
        return listAngka.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgBelajar: ImageView = itemView.findViewById(R.id.belajar1)
        var txtAngka: TextView = itemView.findViewById(R.id.txtxAngka)
    }
}
