package com.anmp.a160420121_uts_anmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.model.Kos
import com.anmp.a160420121_uts_anmp.util.loadImage
import kotlinx.android.synthetic.main.layout_item_list_kos.view.*

class DetailFilterAdapter(val kosList: ArrayList<Kos>) :
    RecyclerView.Adapter<DetailFilterAdapter.SortDetailViewHolder>() {
    class SortDetailViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_item_list_kos, parent, false)
        return SortDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: SortDetailViewHolder, position: Int) {
        holder.view.txtNamaKos.text = kosList[position].nama
        holder.view.txtAlamatKos.text = kosList[position].alamat
        holder.view.txtTipe.text = kosList[position].tipekos?.capitalize()
        holder.view.imageViewKos.loadImage(kosList[position].url,holder.view.progressBarKos)
        holder.view.btnDetailKos.setOnClickListener {
            val action = DetailFilterFragmentDirections.sortDetailToDetailKos(kosList[position].idkos.toString())
            Navigation.findNavController(it).navigate(action)
        }
        holder.view.imageViewKos.setOnClickListener(){
            val action = DetailFilterFragmentDirections.viewPictureSort(kosList[position].url.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return kosList.size
    }

    fun updateList(newKosList: ArrayList<Kos>) {
        kosList.clear()
        kosList.addAll(newKosList)
        notifyDataSetChanged()
    }
}