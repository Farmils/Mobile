package com.example.pokemonmobile.screen

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
import com.example.pokemonmobile.R


class ChangeStateFragmentDialog (): DialogFragment() {
    private var onCheckedChangeListener: RadioGroup.OnCheckedChangeListener?=null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.create()
        } ?: throw IllegalStateException()
        val view = layoutInflater.inflate(R.layout.fragment_change_state_dialog, null)
        dialog.setView(view)
        dialog.context.setTheme(R.style.StateAlertDialog)
         dialog.window?.attributes.let {
             it?.gravity= Gravity.TOP or  Gravity.END
             it?.verticalMargin= 0.2f
         }
        val radioGroup = view.findViewById<RadioGroup>(R.id.ChangeStateGroup)
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener)
        return dialog
        }
        fun setonCheckedChangeListener(listener: RadioGroup.OnCheckedChangeListener) {
            onCheckedChangeListener = listener

        }
}

