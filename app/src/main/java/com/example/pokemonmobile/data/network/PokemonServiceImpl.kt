package com.example.pokemonmobile.data.network

import com.example.pokemonmobile.data.model.PokemonItemsResponse
import okhttp3.Response

class PokemonServiceImpl( private val pokemonApi: PokemonApi) {
    suspend fun getPokemons():retrofit2.Response<PokemonItemsResponse> =pokemonApi.getPokemons()

}