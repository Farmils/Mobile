package com.example.pokemonmobile.UI.models

import android.content.res.Resources
import android.graphics.Color
import com.example.pokemonmobile.R
import com.example.pokemonmobile.data.model.PokemonResponse

data class AboutScreenState(
    var color:String="White",
    var pokemonResponse: PokemonResponse? = null
)