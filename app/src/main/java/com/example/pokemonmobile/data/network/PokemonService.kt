package com.example.pokemonmobile.data.network


import com.example.pokemonmobile.data.model.PokemonResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object PokemonService {
    val BASE_URL = "https://pokeapi.co/"
    private val inteceptor = HttpLoggingInterceptor()
        .apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    private val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(inteceptor)
        .build()
    private fun createService() = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    val PokemonService by lazy {
        createService().create(PokemonApi::class.java)
       }

}