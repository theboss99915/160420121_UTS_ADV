package com.anmp.a160420121_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.util.loadImage
import com.anmp.a160420121_uts_anmp.util.loadImageNoBar
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var username = ""

        if(arguments != null) {

            username = ProfileFragmentArgs.fromBundle(requireArguments()).username.toString()

            if(username.equals("blank"))
            {
                txtUsername.text = "Not logged in"
                imageViewProfile.isVisible == false
            }
            else {
                txtUsername.text = "Logged in as " + username
                imageViewProfile.isVisible == true
                imageViewProfile.loadImageNoBar("https://www.nicepng.com/png/detail/933-9332131_profile-picture-default-png.png")
            }
        }
        fabLogin.setOnClickListener(){
            val action = ProfileFragmentDirections.toLogin()
            Navigation.findNavController(it).navigate(action)
        }
    }
}