package com.example.dhanangharyo.testkotlinretro

import retrofit.http.GET
import retrofit.http.Path
import rx.Observable


interface  Service{
    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Observable<Savings>
}