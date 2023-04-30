package com.anmp.a160420121_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.util.loadImage
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_detail_kamar.*
import kotlinx.android.synthetic.main.fragment_detail_kos.*
import kotlinx.android.synthetic.main.fragment_view_picture.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ViewPictureFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ViewPictureFragment : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var url = ""

        if(arguments != null) {
            url = ViewPictureFragmentArgs.fromBundle(requireArguments()).url
        }
        imagePreview.loadImage(url,progressBarPreview)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_picture, container, false)
    }


}