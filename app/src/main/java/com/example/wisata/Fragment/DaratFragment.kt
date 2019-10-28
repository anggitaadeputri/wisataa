package com.example.wisata.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisata.R

class DaratFragment : Fragment() {
    private var items: MutableList<Item> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_darat, container, false)
        initView(view)
        return view
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.darat_name)
        val image = resources.obtainTypedArray(R.array.darat_image)

        items.clear()
        for (i in name.indices) {
            items.add(
                Item(
                    name[i],
                    image.getResourceId(i, 0)
                )
            )
        }

        image.recycle()
    }

    fun initView(view: View) {
        initData()
        val rv = view.findViewById<RecyclerView>(R.id.darat_list)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = activity?.let { RecyclerViewAdapter(it, items) }
    }
}