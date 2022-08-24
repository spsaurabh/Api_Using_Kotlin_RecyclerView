package com.example.api_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var  myAdapter : MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var reclrview : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reclrview = findViewById(R.id.recl)
        reclrview.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        reclrview.layoutManager = linearLayoutManager
        getMyData()
    }
    private fun getMyData() {

        //retrofit bridge (Connection with Retrofit)
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/") //Base Url
            .addConverterFactory(GsonConverterFactory.create())
            .build()

            val service : Interf = retrofitBuilder.create(Interf::class.java)
            val retrofitData = service.getData()

                retrofitData.enqueue(object : Callback<Data_class> {
                                        override fun onResponse(
                        call: Call<Data_class>,
                        response: Response<Data_class>
                    ) {

                      //  val responseBody = response.body()
                        Log.d("saum",""+response.body())

                     //   val res = Data_class()

                        myAdapter = MyAdapter(baseContext, response.body()!!.data)
                        reclrview.adapter = myAdapter
                        myAdapter.notifyDataSetChanged()
                    }

                    override fun onFailure(call: Call<Data_class>, t: Throwable) {
                        Log.d("hello",""+t.message)

                    }
                })
    }
}