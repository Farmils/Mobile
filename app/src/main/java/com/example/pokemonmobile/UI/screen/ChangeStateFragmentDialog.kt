package com.example.pokemonmobile.UI.screen

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pokemonmobile.R
import com.example.pokemonmobile.UI.models.MainScreenStateSort
import com.example.pokemonmobile.UI.models.MainScreenViewModel
import com.example.pokemonmobile.databinding.FragmentChangeStateDialogBinding
import kotlinx.coroutines.launch


class ChangeStateFragmentDialog (): DialogFragment() {
private  var changeStateBinding: FragmentChangeStateDialogBinding? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.create()
        } ?: throw IllegalStateException()
        val viewModel by activityViewModels<MainScreenViewModel>()
        val view = layoutInflater.inflate(R.layout.fragment_change_state_dialog, null)
        dialog.setView(view)
        changeStateBinding = FragmentChangeStateDialogBinding.bind(view)
        dialog.context.setTheme(R.style.StateAlertDialog)
         dialog.window?.attributes.let {
             it?.gravity= Gravity.TOP or  Gravity.END
             it?.verticalMargin= 0.2f
         }
        lifecycleScope.launch {
            viewModel.stateMainScreen.collect {
                changeStateBinding?.NameCheck?.isChecked = it.isNameSorted
                changeStateBinding?.NumberCheck?.isChecked = it.isNumberSorted
            }
        }
        val radioGroup = view.findViewById<RadioGroup>(R.id.ChangeStateGroup)
       radioGroup.setOnCheckedChangeListener{group, checkedId ->
           when(checkedId){
               R.id.NumberCheck -> {
                   viewModel.changeStateSort(MainScreenStateSort.NUMBER)
               }
               R.id.NameCheck -> {
                   viewModel.changeStateSort(MainScreenStateSort.NAME)
               }
           }
           dismiss()
       }
        return dialog
        }

}

