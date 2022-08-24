package com.example.api_kotlin

import retrofit2.Call
import retrofit2.http.GET

interface Interf {

    @GET("users?page=1")
    fun getData() : Call<Data_class>
}