package com.tamimapps.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemsRecyclerAdapter(
    private val mContext: Context,
    private val mData: ArrayList<Items>
) : RecyclerView.Adapter<ItemsRecyclerAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemsRecyclerAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_row_view, parent, false)
        return MyViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ItemsRecyclerAdapter.MyViewHolder, position: Int) {
        holder.itemName.text = mData.get(position).slug
        holder.itemPrice.text = mData.get(position).profit
        val x = mData.get(position).thumb
        Glide.with(mContext)
            .load(x)
            .into(holder.img)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView
        val itemPrice: TextView
val img:ImageView
        init {
            itemName = itemView.findViewById(R.id.textViewName)
            itemPrice = itemView.findViewById(R.id.textViewPrice)
            img=itemView.findViewById(R.id.imageView)
        }
    }
}