package com.example.laxman.findnearbyplaces

import com.example.laxman.findnearbyplaces.bean.PlacesBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesAPI {

    @GET("maps/api/place/nearbysearch/json?key=AIzaSyBd6iN-uMhUVHTQvMHhsnyCg2fWnSKlqRA")
    fun getPlaces(@Query("location") l:String,
                  @Query("radius") r:String,
                  @Query("type")  t:String) : Call<PlacesBean>
}