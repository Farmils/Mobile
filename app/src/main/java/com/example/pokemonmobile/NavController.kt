package com.example.pokemonmobile

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.pokemonmobile.UI.screen.AboutScreen
import com.example.pokemonmobile.data.model.PokemonResponse

class NavController:FragmentManager() {
    fun navigateToAboutScreen(){
        commit {
            add<AboutScreen>(R.id.host_fragment)
        }
    }
}