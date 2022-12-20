package com.simple_recyclerview.remote

import com.simple_recyclerview.model.Contacts
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    //for live data search
    @GET("retrofit/getcountry.php")
    abstract fun getContact(
    ): Call<List<Contacts?>?>?
}