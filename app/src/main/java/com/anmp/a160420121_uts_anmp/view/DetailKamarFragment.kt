package com.anmp.a160420121_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.model.Kamar
import com.anmp.a160420121_uts_anmp.util.loadImage
import com.anmp.a160420121_uts_anmp.viewmodel.KamarDetailModel
import com.anmp.a160420121_uts_anmp.viewmodel.KosDetailModel
import kotlinx.android.synthetic.main.fragment_detail_kamar.*
import kotlinx.android.synthetic.main.fragment_detail_kos.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [DetailKamarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailKamarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel: KamarDetailModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var kosid = ""
        var kamarid = ""
        if(arguments != null) {
            kosid = DetailKamarFragmentArgs.fromBundle(requireArguments()).idkos
            kamarid = DetailKamarFragmentArgs.fromBundle(requireArguments()).idkamar
        }
        viewModel = ViewModelProvider(this).get(KamarDetailModel::class.java)
        viewModel.refresh(kamarid,kosid)
        observeViewModel()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_kamar, container, false)
    }
    fun observeViewModel()
    {
        viewModel.kamarList.observe(viewLifecycleOwner, Observer {
            var kamarDetails = it
            txtDetailKamarMandi.text = it.kamarmandidalam?.capitalize()
            txtDetailHargaPerBulan.text = "Rp. " + it.hargaperbulan
            txtDetailLuasKamar.text = it.luaskamar + " m2"
            txtDetailListrik.text = it.termasuklistrik?.capitalize()
            txtDetailMaksKamar.text = it.maksperkamar + " orang"
            txtDetailAC.text = it.ac?.capitalize()
            imageViewDetailKamar.loadImage(it.url,progressBarDetailKamar)

        })
    }

}