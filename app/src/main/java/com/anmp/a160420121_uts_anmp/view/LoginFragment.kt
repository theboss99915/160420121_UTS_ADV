package com.anmp.a160420121_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.anmp.a160420121_uts_anmp.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.layout_item_list_kos.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    val username = "username"
    val password = "password"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonLogin.setOnClickListener(){
            if(inputUsername.text.toString() == username && inputPassword.text.toString() == password) {
                val action = LoginFragmentDirections.backToProfile(inputUsername.text.toString())
                Navigation.findNavController(it).navigate(action)
            }
            else{
                Toast.makeText(this.context,"Username and/or password is wrong. Please try again.",Toast.LENGTH_SHORT).show()
            }
        }

    }

}