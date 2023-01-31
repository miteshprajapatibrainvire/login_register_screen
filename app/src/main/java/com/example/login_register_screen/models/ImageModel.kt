package com.example.login_register_screen.models

import android.os.Parcel
import android.os.Parcelable
import kotlin.collections.ArrayList

data class ImageModel(val imgDrawableId:Int, val imgName:String, val arrayModel: ArrayList<ImageModel>?):Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        arrayListOf<ImageModel>().apply {
            parcel.readList(this, ImageModel::class.java.classLoader)
        }
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imgDrawableId)
        parcel.writeString(imgName)
        parcel.writeTypedList(arrayModel)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageModel> {

        override fun createFromParcel(parcel: Parcel): ImageModel {
            return ImageModel(parcel)
        }

        override fun newArray(size: Int): Array<ImageModel?> {
            return arrayOfNulls(size)
        }

    }


}
