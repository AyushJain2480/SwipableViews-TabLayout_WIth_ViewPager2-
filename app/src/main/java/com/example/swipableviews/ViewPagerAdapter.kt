package com.example.swipableviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

// we added our images in drawable than we can get those images with their id

class ViewPagerAdapter(val images : List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPageViewHolder>(){

    inner class ViewPageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPageViewHolder(view)
    }

    // we need to set our images to imageViews
    override fun onBindViewHolder(holder: ViewPageViewHolder, position: Int) {
        val currentImg = images[position]
        holder.itemView.findViewById<ImageView>(R.id.ivImage).setImageResource(currentImg)
    }

    override fun getItemCount(): Int {
     return images.size
    }
}