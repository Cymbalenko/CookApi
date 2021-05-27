package com.example.cookapi.model.api.responses

import com.google.gson.annotations.SerializedName

data class Recept(
    @SerializedName("recipe_id")
    val id:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("image_url")
    val imageUrl:String
)
