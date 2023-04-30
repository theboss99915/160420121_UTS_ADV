package com.anmp.a160420121_uts_anmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.model.Kos
import com.anmp.a160420121_uts_anmp.model.Sort
import com.anmp.a160420121_uts_anmp.util.loadImage
import kotlinx.android.synthetic.main.layout_item_list_kamar.view.*
import kotlinx.android.synthetic.main.layout_item_list_kos.view.*
import kotlinx.android.synthetic.main.layout_list_filter.view.*

class SortAdapter(val sortList: ArrayList<Sort>) :
    RecyclerView.Adapter<SortAdapter.SortViewHolder>() {
    class SortViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_list_filter, parent, false)
        return SortViewHolder(view)
    }

    override fun onBindViewHolder(holder: SortViewHolder, position: Int) {
        holder.view.buttonSort.text = sortList[position].nama
        holder.view.buttonSort.setOnClickListener{
            var action = SortFragmentDirections.toDetailSort(sortList[position].value.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return sortList.size
    }

    fun updateList(newSortList: ArrayList<Sort>) {
        sortList.clear()
        sortList.addAll(sortList)
        notifyDataSetChanged()
    }
}