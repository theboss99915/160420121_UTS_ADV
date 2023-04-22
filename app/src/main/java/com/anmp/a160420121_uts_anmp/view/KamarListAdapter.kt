package com.anmp.a160420121_uts_anmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.model.Kamar
import com.anmp.a160420121_uts_anmp.util.loadImage
import kotlinx.android.synthetic.main.layout_item_list_kamar.view.*
import kotlinx.android.synthetic.main.layout_item_list_kos.view.txtNamaKos
import kotlinx.android.synthetic.main.layout_item_list_kos.view.txtAlamatKos

class KamarListAdapter(val kamarList: ArrayList<Kamar>,var kosid : String) :
    RecyclerView.Adapter<KamarListAdapter.KamarViewHolder>() {
    class KamarViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KamarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_item_list_kamar, parent, false)
        return KamarViewHolder(view)
    }

    override fun onBindViewHolder(holder: KamarViewHolder, position: Int) {
        holder.view.txtHargaKamar.text = "Rp. " + kamarList[position].hargaperbulan
        holder.view.txtLuasKamar.text = kamarList[position].luaskamar + " m2"
        holder.view.imageViewKamar.loadImage(kamarList[position].url,holder.view.progressBarKamar)
        holder.view.btnDetailKamar.setOnClickListener {
            val action = DetailKosFragmentDirections.openDetailKamar(kamarList[position].id.toString(),kosid)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return kamarList.size
    }

    fun updateList(newKamarList: ArrayList<Kamar>,kos: String) {
        kamarList.clear()
        kamarList.addAll(newKamarList)
        kosid = kos
        notifyDataSetChanged()
    }
}