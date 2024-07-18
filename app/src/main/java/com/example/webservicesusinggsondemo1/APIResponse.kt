package com.example.webservicesusinggsondemo1

import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("page")
    var pageNumber : Int,

    @SerializedName("per_page")
    var perPage : Int,

    var total : Int,

    @SerializedName("total_pages")
    var totalPages: Int,

    @SerializedName("data")
    var UsersArray: ArrayList<User>
){
    override fun toString(): String {
        return "page number -- $pageNumber"
    }
}
