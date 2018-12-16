package com.example.laxman.findnearbyplaces.bean

import com.google.gson.annotations.SerializedName

data class Geometry(@SerializedName("location")
                    val location: Location)