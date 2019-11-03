package com.m.viewpager2examples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_page.view.*

class ViewPagerAdapter : RecyclerView.Adapter<PagerVH>() {

    //array of colors to change the background color of screen

    private var colors = mutableListOf<Int>()

    fun setColor(colors: List<Int>) {
        this.colors.clear()
        this.colors.addAll(colors)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))

    //get the size of color array
    override fun getItemCount(): Int = colors.size

    //binding the screen with view
    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        tvAbout.text = "Position $position"
        if (position == 0) {
            container.setBackgroundResource(colors[position])
        }
        if (position == 1) {
            container.setBackgroundResource(colors[position])
        }
        if (position == 2) {
            container.setBackgroundResource(colors[position])
        }
        if (position == 3) {
            container.setBackgroundResource(colors[position])
        }
    }
}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)