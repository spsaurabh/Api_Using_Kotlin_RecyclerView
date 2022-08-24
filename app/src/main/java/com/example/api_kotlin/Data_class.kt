package com.example.api_kotlin

data class Data_class(
        val page : Int,
        val per_page : Int,
        val total : Int,
        val total_pages : Int,
        val data: ArrayList<Data_class_01>

)
