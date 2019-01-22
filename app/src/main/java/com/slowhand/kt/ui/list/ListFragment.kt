package com.slowhand.kt.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.slowhand.kt.R
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: Fragment() {

    private var userList: MutableList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // RecyclerView
        activity?.also { activity ->
            recyclerView.adapter = ListAdapter(activity, userList)
            recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

            val viewModel = ViewModelProviders.of(activity).get(ListViewModel::class.java)
            viewModel.getUsersLiveData().observe(activity, Observer { data ->
                userList.clear()
                data.map { userList.add(it.name) }
                recyclerView.adapter?.notifyDataSetChanged()
            })
        }
    }
}