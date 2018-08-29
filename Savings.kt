package com.example.dhanangharyo.testkotlinretro

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class Savings {

    @SerializedName("avatar_url")
    @Expose
    open var avatarURL: String? = null

    @SerializedName("name")
    @Expose
    open var name: String? = null

    @SerializedName("company")
    @Expose
    open var company: String? = null

    @SerializedName("location")
    @Expose
    open var location: String? = null

}