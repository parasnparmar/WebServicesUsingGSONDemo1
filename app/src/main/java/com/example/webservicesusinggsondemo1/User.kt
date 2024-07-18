package com.example.webservicesusinggsondemo1

data class User(
    var id: Int,
    @SerializedName("first_name")
    var firstName : String,
    @SerializedName("last_name")
    var lastName : String,
    var email: String,
    var avatar: String
)
