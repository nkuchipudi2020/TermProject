package com.example.termproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [list.newInstance] factory method to
 * create an instance of this fragment.
 */
class list : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var selfCareModelList : ArrayList<SelfCareTaskModel>
    private lateinit var selfCareBannerImageView : ImageView
    private lateinit var adapter : SelfCareTasksAdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        selfCareBannerImageView = view.findViewById(R.id.selfCareBannerImageView)
        recyclerView = view.findViewById(R.id.selfCareTasksRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        selfCareModelList = setupModelList()
        adapter = SelfCareTasksAdapterClass(selfCareModelList, SelfCareTasksAdapterClass.OnClickListener { aTask ->
            Toast.makeText(context, aTask.getTaskName(), Toast.LENGTH_SHORT).show()
        })
        recyclerView.adapter = adapter
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    private fun setupModelList():ArrayList<SelfCareTaskModel>{
        val noteModelListTemp = ArrayList<SelfCareTaskModel>()
        for (i in 1..21){
            noteModelListTemp.add(SelfCareTaskModel(false,"9/$i/2022"))
        }
        return noteModelListTemp
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment list.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            list().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}