package com.anmp.a160420121_uts_anmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anmp.a160420121_uts_anmp.R
import com.anmp.a160420121_uts_anmp.viewmodel.FilterViewModel
import kotlinx.android.synthetic.main.fragment_detail_filter.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFilterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFilterFragment : Fragment() {
    private lateinit var viewModel: FilterViewModel
    private val kosListAdapter = DetailFilterAdapter(arrayListOf())
    var property = ""
    var value = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            property = DetailFilterFragmentArgs.fromBundle(requireArguments()).property
            value = DetailFilterFragmentArgs.fromBundle(requireArguments()).value
        }

        viewModel = ViewModelProvider(this).get(FilterViewModel::class.java)
        viewModel.refresh(property,value)

        val recView = view.findViewById<RecyclerView>(R.id.recViewFilterDetail)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = kosListAdapter
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.kosList.observe(viewLifecycleOwner, Observer {
            kosListAdapter.updateList(it)
        })

        viewModel.kosLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.textErrorFilterDetail)
            if(it == true) {
               txtError?.visibility = View.VISIBLE
            } else { txtError?.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadFilterDetail)
            val recView = view?.findViewById<RecyclerView>(R.id.recViewFilterDetail)
            if(it == true) {
                recView?.visibility = View.GONE
                progressLoad?.visibility = View.VISIBLE
            } else {
                recView?.visibility = View.VISIBLE
                progressLoad?.visibility = View.GONE
            }
        })

    }

}