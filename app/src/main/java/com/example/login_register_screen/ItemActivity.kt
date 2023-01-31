package com.example.login_register_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login_register_screen.R.layout.activity_item
import com.example.login_register_screen.adapters.ItemAdapter
import com.example.login_register_screen.databinding.ActivityHomeBinding
import com.example.login_register_screen.databinding.ActivityItemBinding
import com.example.login_register_screen.models.DataModel
import com.example.login_register_screen.models.ImageModel

class ItemActivity : AppCompatActivity() {

    lateinit var recyAdapter:ItemAdapter
    private lateinit var bindingItem: ActivityItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingItem = ActivityItemBinding.inflate(layoutInflater)
        setContentView(bindingItem?.root)

        supportActionBar?.hide()

        val indData: ImageModel? =intent.getParcelableExtra<ImageModel>("passItem")
        bindingItem.itemTxId.text=indData?.imgName
        Log.i("image data=",indData?.imgDrawableId.toString())
        indData?.imgDrawableId?.let { bindingItem.itemImageId.setImageResource(it) }

        recyAdapter= ItemAdapter(this,getItemsList())
        bindingItem.recyInner.layoutManager=LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        ResourcesCompat.getDrawable(resources, R.drawable.divider_drawable, null)
            ?.let { drawable -> dividerItemDecoration.setDrawable(drawable) }
        bindingItem.recyInner.addItemDecoration(dividerItemDecoration)
        bindingItem.recyInner.adapter=recyAdapter

    }

    private fun getItemsList(): ArrayList<DataModel> {
        val list = ArrayList<DataModel>()
        list.add(DataModel(R.drawable.naturehand,"Nature Hand", ItemAdapter.VIEW_ONE))
        list.add(DataModel(R.drawable.naturehand,"Whether it is watching blue, rolling waves crash against the sandy shore or hearing birds chirping in a green, luscious forest, there is something so remarkable and beautiful about being immersed in nature. It’s easy to be swept away with today’s technology and fast-paced living, but no matter where you are, nature always has a way of bringing peace to the mind and grounding a person.", ItemAdapter.VIEW_TWO))
        list.add(DataModel(R.drawable.sunsetrose,"Sunset Rose", ItemAdapter.VIEW_ONE))
        list.add(DataModel(R.drawable.sunsetrose,"Whether it is watching blue, rolling waves crash against the sandy shore or hearing birds chirping in a green, luscious forest, there is something so remarkable and beautiful about being immersed in nature. It’s easy to be swept away with today’s technology and fast-paced living, but no matter where you are, nature always has a way of bringing peace to the mind and grounding a person.", ItemAdapter.VIEW_TWO))
        list.add(DataModel(R.drawable.riverhill,"River Hill", ItemAdapter.VIEW_ONE))
        list.add(DataModel(R.drawable.riverhill,"Whether it is watching blue, rolling waves crash against the sandy shore or hearing birds chirping in a green, luscious forest, there is something so remarkable and beautiful about being immersed in nature. It’s easy to be swept away with today’s technology and fast-paced living, but no matter where you are, nature always has a way of bringing peace to the mind and grounding a person.", ItemAdapter.VIEW_TWO))
        list.add(DataModel(R.drawable.waterbeach,"Water beach", ItemAdapter.VIEW_ONE))
        list.add(DataModel(R.drawable.waterbeach,"Whether it is watching blue, rolling waves crash against the sandy shore or hearing birds chirping in a green, luscious forest, there is something so remarkable and beautiful about being immersed in nature. It’s easy to be swept away with today’s technology and fast-paced living, but no matter where you are, nature always has a way of bringing peace to the mind and grounding a person.", ItemAdapter.VIEW_TWO))
        list.add(DataModel(R.drawable.riverhill,"River hill", ItemAdapter.VIEW_ONE))
        list.add(DataModel(R.drawable.riverhill,"Whether it is watching blue, rolling waves crash against the sandy shore or hearing birds chirping in a green, luscious forest, there is something so remarkable and beautiful about being immersed in nature. It’s easy to be swept away with today’s technology and fast-paced living, but no matter where you are, nature always has a way of bringing peace to the mind and grounding a person.", ItemAdapter.VIEW_TWO))
        list.add(DataModel(R.drawable.mothernature,"Mother nature", ItemAdapter.VIEW_ONE))
        list.add(DataModel(R.drawable.mothernature,"Whether it is watching blue, rolling waves crash against the sandy shore or hearing birds chirping in a green, luscious forest, there is something so remarkable and beautiful about being immersed in nature. It’s easy to be swept away with today’s technology and fast-paced living, but no matter where you are, nature always has a way of bringing peace to the mind and grounding a person.", ItemAdapter.VIEW_TWO))
        return list
    }
}