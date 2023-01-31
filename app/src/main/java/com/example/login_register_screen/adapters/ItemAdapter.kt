package com.example.login_register_screen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.login_register_screen.databinding.Itemlayout1Binding
import com.example.login_register_screen.databinding.Itemlayout2Binding
import com.example.login_register_screen.models.DataModel

class ItemAdapter(val context: Context, val items:ArrayList<DataModel>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val VIEW_ONE=1
        const val VIEW_TWO=2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(viewType== VIEW_ONE)
            return ViewHolder(Itemlayout1Binding.inflate(LayoutInflater.from(parent.context),parent,false))
        else
        {
            return SecondViewHolder(Itemlayout2Binding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item=items.get(position)
        if(holder is ViewHolder)
        {
                holder.txItemId.text=item.itemName
                holder.imgItem.setImageResource(item.imgId)
        }
        else if(holder is SecondViewHolder)
        {
            holder.txItemId2.text=item.itemName
            holder.imgItem2.setImageResource(item.imgId)
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    class ViewHolder(binding: Itemlayout1Binding):RecyclerView.ViewHolder(binding.root)
    {
        val imgItem: ImageView =binding.imgItemId
        val txItemId=binding.txItemId
    }

    class SecondViewHolder(binding2:Itemlayout2Binding):RecyclerView.ViewHolder(binding2.root)
    {
        val imgItem2=binding2.imgIdItem2
        val txItemId2=binding2.txIdItem2
    }

}