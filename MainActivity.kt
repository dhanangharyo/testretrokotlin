package com.example.dhanangharyo.testkotlinretro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gson = GsonBuilder().create()

        //initialized retrofit
        val retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.github.com/")
                .build()

        val service: Service = retrofit.create(
                Service::class.java)

        //get data from github by username
        service.getUser("dhanangharyo")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { user ->
                            getData(user)
                        },
                        { error ->
                            Log.e("Error", error.message)
                        }
                )
    }

   private fun getData(user: Savings?){
       val image = findViewById<ImageView>(R.id.image1)
       val text1 = findViewById<TextView>(R.id.text1)
       val text2 = findViewById<TextView>(R.id.text2)
       val text3 = findViewById<TextView>(R.id.text3)
       Glide.with(this).load(user?.avatarURL).into(image)
       text1.text= user?.name
       text2.text= user?.company
       text3.text= user?.location

   }
}
