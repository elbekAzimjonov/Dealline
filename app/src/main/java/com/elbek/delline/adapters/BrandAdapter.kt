package com.elbek.delline.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.elbek.delline.R
import com.elbek.delline.databinding.BrendItemBinding
import com.elbek.delline.models.BrandModel

class BrandAdapter(
    var brandList: ArrayList<BrandModel>,
    var onItemClickListener: OnItemClickListener,
) :
    RecyclerView.Adapter<BrandAdapter.BrandViewHolder>() {
    inner class BrandViewHolder(var itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun onBinding(brandModel: BrandModel, position: Int) {
            val imageView = itemView.findViewById<ImageView>(R.id.imageBrand)
            imageView.setImageResource(brandModel.brandImage)
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(brandModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.brend_item, parent, false)
        return BrandViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        holder.onBinding(brandList[position], position)
    }

    override fun getItemCount() = brandList.size

    interface OnItemClickListener {
        fun onItemClick(brandModel: BrandModel)
    }

    fun filterList(filteredList: ArrayList<BrandModel>) {
        brandList = filteredList
        notifyDataSetChanged()
    }
}