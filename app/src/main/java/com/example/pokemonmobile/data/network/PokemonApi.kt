package com.example.pokemonmobile.data.network

import com.example.pokemonmobile.data.model.PokemonItemsResponse
import com.example.pokemonmobile.data.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("api/v2/pokemon/")
    suspend fun getPokemons():Response<PokemonItemsResponse>

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemon(@Path("name")name:String):Response<PokemonResponse>
}