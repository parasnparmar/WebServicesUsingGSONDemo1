package com.example.webservicesusinggsondemo1

import android.util.Log
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WebUtil {
    companion object{
        fun getUsers(pageNumber: Int): APIResponse{
            var getUserAPIURL = URL("https://reqres.in/api/users?page=$pageNumber")
            var httpURLConnection = getUserAPIURL.openConnection() as HttpURLConnection

            httpURLConnection.requestMethod = "GET"
            httpURLConnection.connect()

            var resReader = InputStreamReader(httpURLConnection.inputStream)
            var gson = Gson()
            var apiResponse = gson.fromJson<APIResponse>(resReader, APIResponse::class.java)

            Log.e("tag", apiResponse.toString())
            for (eachUser in apiResponse.UsersArray){
                Log.e("eachUser Object","${eachUser.toString()}")
            }
            return apiResponse
        }
    }
}