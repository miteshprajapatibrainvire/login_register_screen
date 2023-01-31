package com.example.login_register_screen.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.login_register_screen.ItemActivity
import com.example.login_register_screen.databinding.InnerRecyImageBinding
import com.example.login_register_screen.models.ImageModel

class InnerAdapter(val arrInnerList:ArrayList<ImageModel>):RecyclerView.Adapter<InnerAdapter.ViewHolder>() {

    class ViewHolder(binding: InnerRecyImageBinding):RecyclerView.ViewHolder(binding.root)
    {
        val imgView=binding.imgCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=   InnerRecyImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgView.setImageResource(arrInnerList[position].imgDrawableId)
        holder.imgView.setOnClickListener {
            val intPass= Intent(holder.itemView.context,ItemActivity::class.java)
            intPass.putExtra("passItem",arrInnerList[position])
            intPass.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK
            holder.itemView.context.startActivity(intPass)
        }
    }

    override fun getItemCount(): Int {
        return arrInnerList.size
    }

}