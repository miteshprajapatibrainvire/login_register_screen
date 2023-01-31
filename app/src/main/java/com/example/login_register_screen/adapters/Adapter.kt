package com.example.login_register_screen.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login_register_screen.ItemActivity
import com.example.login_register_screen.models.ImageModel
import com.example.login_register_screen.databinding.RecyclerItemBinding

class Adapter(var context: Context, var slist: ArrayList<ImageModel>) :
    RecyclerView.Adapter<Adapter.viewHolder>() {

    class viewHolder(binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgName: ImageView = binding.imgDataId
        val txName: TextView = binding.txItem
        val InnerRecy: RecyclerView = binding.innerImgRecy
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding =
            RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.imgName.setImageResource(slist[position].imgDrawableId)
        holder.txName.text = slist[position].imgName

        holder.imgName.setOnClickListener {
            val intentData = Intent(context, ItemActivity::class.java)
            intentData.putExtra("passItem", slist[position])
            holder.itemView.context.startActivity(intentData)
        }

        val InnerAdp = InnerAdapter(slist[position].arrayModel!!)
        holder.InnerRecy.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.InnerRecy.adapter = InnerAdp

    }

    override fun getItemCount(): Int {
        return slist.size
    }

}