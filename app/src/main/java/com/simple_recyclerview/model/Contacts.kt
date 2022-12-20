package com.simple_recyclerview.model

import com.google.gson.annotations.SerializedName

class Contacts {
    @SerializedName("country")
    private val country:String? = null

    fun getCountry():String?{
        return country
    }
}