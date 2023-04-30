package com.anmp.a160420121_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.model.Sort

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [SortFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SortFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sortList = arrayListOf<Sort>()
        sortList.add(Sort("1","Nama","nama"))
        sortList.add(Sort("2","Tipe Kos","tipekos"))
        sortList.add(Sort("3","WiFi","wifi"))

        var sortListAdapter = SortAdapter(sortList)
        val recView = view.findViewById<RecyclerView>(R.id.recViewSort)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = sortListAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sort, container, false)
    }

}