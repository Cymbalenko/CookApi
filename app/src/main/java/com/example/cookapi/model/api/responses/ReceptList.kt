package com.example.cookapi.model.api.responses

import com.google.gson.annotations.SerializedName

data class ReceptList (
    @SerializedName("recipes")
    val listRecept :List<Recept>
)