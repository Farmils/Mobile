package com.example.pokemonmobile.UI.screen

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.pokemonmobile.R
import com.example.pokemonmobile.UI.adapters.TypeAdapter
import com.example.pokemonmobile.UI.models.MainScreenViewModel
import com.example.pokemonmobile.data.model.PokemonResponse
import com.example.pokemonmobile.data.model.TypeModel
import com.example.pokemonmobile.databinding.FragmentAboutScreenBinding
import com.google.android.material.color.MaterialColors.getColor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class AboutScreen : Fragment(R.layout.fragment_about_screen) {
    private var aboutScreenBinding: FragmentAboutScreenBinding? = null
    private val viewModel: MainScreenViewModel by activityViewModels()
    private val mapColor:MutableMap<String,Int> = mutableMapOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aboutScreenBinding = FragmentAboutScreenBinding.bind(view)
        initColor()
        lifecycleScope.launch {
            viewModel.stateAboutScreen.collect{ state ->
                state.pokemonResponse?.let { pokemon -> setPokemon(pokemonResponse = pokemon) }
            }
        }
    }

    fun setPokemon(pokemonResponse: PokemonResponse) {
        val typeAdapter = TypeAdapter(pokemonResponse.types.map {
           mapColor[it.type.name].let {color -> TypeModel(color!!,it.type.name)  }

        })
        val color = mapColor[pokemonResponse.types[0].type.name]
        if (color!=null){
            setGlobalColor(color)
        }
        if (aboutScreenBinding != null) {
            aboutScreenBinding!!.apply {
                TypeList.adapter = typeAdapter
                PokeImage.load(pokemonResponse.sprites.other.official_artwork.front_default)
                PrimaryAbilityTextView.text = pokemonResponse.abilities[0].ability.name
                SecondaryAbilityTextView.text = pokemonResponse.abilities[1].ability.name
                PokemonNameTitle.text = pokemonResponse.name
                PokemonNumberTitle.text=pokemonResponse.order.toString()
                WeightTextView.text = pokemonResponse.weight.toString()
                HeightTextView.text = pokemonResponse.height.toString()

            }
        }

    }
    fun setGlobalColor(color:Int){
if (aboutScreenBinding !=null){
    aboutScreenBinding?.MainLayout?.setBackgroundColor(color)
    aboutScreenBinding?.PokemonStats?.setBackgroundColor(color)
    aboutScreenBinding?.AboutPOkem?.setTextColor(color)
    aboutScreenBinding?.BaseStats?.setTextColor(color)
    aboutScreenBinding?.StatsItem?.setBackgroundColor(color)

}
    }
    fun initColor(){
        mapColor.set("white",requireContext().getColor( R.color.white))
        mapColor.set("grass", requireContext().getColor(R.color.grass))
        mapColor.set("ground",requireContext().getColor(R.color.ground))
        mapColor.set("bug",requireContext().getColor(R.color.bug))
        mapColor.set("dark",requireContext().getColor(R.color.dark))
        mapColor.set("dragon",requireContext().getColor(R.color.dragon))
        mapColor.set("electric",requireContext().getColor(R.color.electric))
        mapColor.set("fairy",requireContext().getColor(R.color.fairy))
        mapColor.set("fighting",requireContext().getColor(R.color.fighting))
        mapColor.set("fire",requireContext().getColor(R.color.fire))
        mapColor.set("flying",requireContext().getColor(R.color.flying))
        mapColor.set("ghost",requireContext().getColor(R.color.ghost))
        mapColor.set("normal",requireContext().getColor(R.color.normal))
        mapColor.set("ground",requireContext().getColor(R.color.ground))
        mapColor.set("ice",requireContext().getColor(R.color.ice))
        mapColor.set("poison",requireContext().getColor(R.color.poison))
        mapColor.set("psychic",requireContext().getColor(R.color.psychic))
        mapColor.set("rock",requireContext().getColor(R.color.rock))
        mapColor.set("steel",requireContext().getColor(R.color.steel))
        mapColor.set("water",requireContext().getColor(R.color.water))
    }

}