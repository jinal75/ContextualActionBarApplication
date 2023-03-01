package com.example.contextualactionbarapplication.ViewPagerRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contextualactionbarapplication.R


class RecyclerAdapter(viewPagerItemArrayList: ArrayList<ViewPagerItem>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var viewPagerItemArrayList: ArrayList<ViewPagerItem> = viewPagerItemArrayList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewpager_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewPagerItem: ViewPagerItem = viewPagerItemArrayList[position]
        holder.imageView.setImageResource(viewPagerItem.imageID)
        holder.tcHeading.setText(viewPagerItem.heading)
        holder.tvDesc.setText(viewPagerItem.description)
    }

    override fun getItemCount(): Int {
        return viewPagerItemArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var tcHeading: TextView
        var tvDesc: TextView

        init {
            imageView = itemView.findViewById(R.id.ivimage)
            tcHeading = itemView.findViewById(R.id.tvHeading)
            tvDesc = itemView.findViewById(R.id.tvDesc)
        }
    }

}














