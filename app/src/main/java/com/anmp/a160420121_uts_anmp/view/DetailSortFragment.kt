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
import com.anmp.a160420121_uts_anmp.model.Kos
import com.anmp.a160420121_uts_anmp.viewmodel.ListViewModel

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
    private lateinit var viewModel: ListViewModel
    private val kosListAdapter = DetailSortAdapter(arrayListOf())
    var sort = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_sort, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            sort = DetailFilterFragmentArgs.fromBundle(requireArguments()).value
        }

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recViewSortDetail)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = kosListAdapter
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.kosLists.observe(viewLifecycleOwner, Observer {
            var listKos = it
            if(sort=="nama")
            {
                var sortedList = listKos.sortedBy{ it.nama }
                kosListAdapter.updateList(ArrayList(sortedList))
            }
            else if(sort=="wifi")
            {
                var sortedList = listKos.sortedByDescending{ it.wifi }
                kosListAdapter.updateList(ArrayList(sortedList))
            }
            else if(sort=="tipekos")
            {
                var sortedList = listKos.sortedBy{ it.tipekos }
                kosListAdapter.updateList(ArrayList(sortedList))
            }

        })

        viewModel.kosLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.textErrorSortDetail)
            if(it == true) {
                txtError?.visibility = View.VISIBLE
            } else {
                txtError?.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoadSortDetail)
            val recView = view?.findViewById<RecyclerView>(R.id.recView)
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