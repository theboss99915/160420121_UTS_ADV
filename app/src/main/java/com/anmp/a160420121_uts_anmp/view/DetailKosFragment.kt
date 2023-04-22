package com.anmp.a160420121_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.model.Kamar
import com.anmp.a160420121_uts_anmp.model.Kos
import com.anmp.a160420121_uts_anmp.util.loadImage
import com.anmp.a160420121_uts_anmp.viewmodel.KosDetailModel
import com.anmp.a160420121_uts_anmp.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_detail_kos.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [DetailKosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailKosFragment : Fragment() {
    // TODO: Rename and change types of parameter
    private lateinit var viewModel: KosDetailModel
    private val kamarListAdapter = KamarListAdapter(arrayListOf(),kosid = "")
    var kosid = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_kos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            kosid = DetailKosFragmentArgs.fromBundle(requireArguments()).id
        }
        viewModel = ViewModelProvider(this).get(KosDetailModel::class.java)
        viewModel.refresh(kosid)

        val recView = view.findViewById<RecyclerView>(R.id.recViewDetail)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = kamarListAdapter
        observeViewModel()
    }

    fun observeViewModel()
    {
        viewModel.kosList.observe(viewLifecycleOwner, Observer {
            var kosDetails = it
            txtDetailNama.text = kosDetails.nama
            txtDetailAlamat.text = kosDetails.alamat
            txtDetailTipe.text = kosDetails.tipekos?.capitalize()
            txtDetailWifi.text = kosDetails.wifi?.capitalize()
            txtDetailDeskripsi.text = kosDetails.deskripsi
            imageDetailView.loadImage(kosDetails.url,progressBarDetail)
            kamarListAdapter.updateList(kosDetails.kamar as ArrayList<Kamar>,kosid)
        })
    }
}