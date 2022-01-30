package com.elbek.delline.adapters

import android.graphics.Color
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elbek.delline.R
import com.elbek.delline.models.BrandModel
import com.elbek.delline.models.CategoriesModel


class CategoriesAdapter(
    var list: ArrayList<CategoriesModel>,
    var onItemClickListener: OnItemClickListener,
) :
    RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {
    var row_index = -1

    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun onBinding(categoriesModel: CategoriesModel, position: Int) {
            val categoriesName = itemView.findViewById<TextView>(R.id.productName)
            val productNumber = itemView.findViewById<TextView>(R.id.productNumber)
            val iconImage = itemView.findViewById<ImageView>(R.id.imageIcon)
            iconImage.setImageResource(categoriesModel.iconimage)
            categoriesName.text = categoriesModel.categorieName
            productNumber.text = categoriesModel.productNumber.toString()
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(categoriesModel, position)
                row_index = position
                notifyDataSetChanged()
            }
            val rowLayout = itemView.findViewById<RelativeLayout>(R.id.cardImage)
            val rootView = itemView.findViewById<View>(R.id.viewRoot)
            if (row_index == position) {
                rowLayout.setBackgroundResource(R.drawable.categories_active)
                rootView.visibility = View.VISIBLE
            } else {
                rowLayout.setBackgroundResource(R.drawable.categories_rectangle)
                rootView.visibility = View.INVISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.categories_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBinding(list[position], position)
    }

    override fun getItemCount() = list.size

    interface OnItemClickListener {
        fun onItemClick(categoriesModel: CategoriesModel, position: Int)
    }

    fun filterList(filteredList: ArrayList<CategoriesModel>) {
        list = filteredList
        notifyDataSetChanged()
    }
}