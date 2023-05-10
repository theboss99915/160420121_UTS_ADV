package com.anmp.a160420121_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.anmp.a160420121_uts_anmp.R
import kotlinx.android.synthetic.main.fragment_filter.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [SortFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilterFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonPutra.setOnClickListener(){
            val action = FilterFragmentDirections.toDetailFilter("putra","tipekos")
            Navigation.findNavController(it).navigate(action)
        }
        buttonPutri.setOnClickListener(){
            val action = FilterFragmentDirections.toDetailFilter("putri","tipekos")
            Navigation.findNavController(it).navigate(action)
        }
        buttonYes.setOnClickListener(){
            val action = FilterFragmentDirections.toDetailFilter("yes","wifi")
            Navigation.findNavController(it).navigate(action)
        }
        buttonNo.setOnClickListener(){
            val action = FilterFragmentDirections.toDetailFilter("no","wifi")
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

}