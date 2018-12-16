package com.example.laxman.findnearbyplaces.bean

import com.google.gson.annotations.SerializedName

data class PlacesBean(@SerializedName("results")
                      val results: MutableList<ResultsItem>?)
