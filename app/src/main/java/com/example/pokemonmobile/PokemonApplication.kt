package com.example.pokemonmobile

import android.app.Application
import com.example.pokemonmobile.data.network.PokemonService
import com.example.pokemonmobile.data.network.PokemonServiceImpl
import com.example.pokemonmobile.data.repository.PokemonRepository

class PokemonApplication:Application() {
    private val pokemonServiceImpl = PokemonServiceImpl(PokemonService.PokemonService)
    val repository = PokemonRepository(pokemonServiceImpl)
}