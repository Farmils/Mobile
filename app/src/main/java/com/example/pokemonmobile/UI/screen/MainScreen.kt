package com.example.pokemonmobile.UI.screen

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope

import com.example.pokemonmobile.R
import com.example.pokemonmobile.UI.adapters.PokemonAdapter
import com.example.pokemonmobile.UI.models.MainScreenViewModel
import com.example.pokemonmobile.databinding.FragmentMainScreenBinding
import kotlinx.coroutines.launch

@Suppress("UNREACHABLE_CODE")
class MainScreen : Fragment(R.layout.fragment_main_screen) {
    private var mainScreenViewBinding: FragmentMainScreenBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: MainScreenViewModel by viewModels {MainScreenViewModel.Factory}
        mainScreenViewBinding = FragmentMainScreenBinding.bind(view)
        viewModel.getPokemons()
        lifecycleScope.launch {
            viewModel.stateMainScreen.collect {
                if (it.isNumberSorted) {
                    setSortByNumber(view)
                }
                if (it.isNameSorted) {
                    setSortByName(view)
                }
                if (!it.pokemonList.isNullOrEmpty()){
                    val adaptor = PokemonAdapter(it.pokemonList){}
                    mainScreenViewBinding?.pokemonlist?.adapter = adaptor
                }
            }
        }

            val dialog = ChangeStateFragmentDialog()
            mainScreenViewBinding?.changeMode?.setOnClickListener {
                dialog.show(childFragmentManager, "ChangeState")
            }
        }

    }

    fun setSortByName(view: View) {
        val imageButton = view.findViewById<ImageButton>(R.id.changeMode)
        imageButton.setImageResource(R.drawable.ic_sort_by_name)
    }

    fun setSortByNumber(view: View) {
        val imageButton = view.findViewById<ImageButton>(R.id.changeMode)
        imageButton.setImageResource(R.drawable.vector)
    }

        
        
        


