package com.anmp.a160420121_uts_anmp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*
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
    var usertf: Boolean = false

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        observeViewModel()

        buttonLogin.setOnClickListener(){
            viewModel.refresh(inputUsername.text.toString(),inputPassword.text.toString())
            observeViewModel()

            if(usertf==true)
            {
                val action = LoginFragmentDirections.backToProfile(inputUsername.text.toString())
                Navigation.findNavController(it).navigate(action)
            }
            else{
                Toast.makeText(context,"Username and/or password is wrong. Please try again!",Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun observeViewModel() {
        viewModel.userLog.observe(viewLifecycleOwner, Observer {
            if(it==true)
            {
                setSomeVariable(true)
            }
        })
    }

    fun setSomeVariable(someVariable: Boolean) {
        this.usertf = someVariable
    }

}