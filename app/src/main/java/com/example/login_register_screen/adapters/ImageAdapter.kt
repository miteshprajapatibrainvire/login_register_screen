package com.example.login_register_screen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.login_register_screen.R
import com.example.login_register_screen.models.ViewModelData
import com.google.android.material.textview.MaterialTextView

class ImageAdapter(
    private val mContext: Context,
    private var
    itemData: ArrayList<ViewModelData>,
   ) : PagerAdapter()
{
    private var layoutInflater: LayoutInflater? = null
    override fun instantiateItem(container: ViewGroup, p: Int): Any {

        layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater!!.inflate(R.layout.image_container, container, false)
        val img: ImageView = view.findViewById(R.id.imgView)
        img.setImageResource(itemData[p].imgId)
        val tx:MaterialTextView=view.findViewById(R.id.txImgTitle)
        tx.setText(itemData[p].txImg)
        container.addView(view, p)
        return view

    }

    override fun getCount(): Int {
        return itemData.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

}