package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentShoeListBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
        binding.fbAddShoe.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))
            viewModel.shoesList.observe(this.viewLifecycleOwner, Observer {
                for (i in 0 until it.size)
                {
                    val param=LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                    val params=LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                    param.setMargins(8,24,0,0)
                    params.setMargins(8,0,0,0)
                    val name = TextView(this.context)
                    name.textSize= 20F
                    name.layoutParams=param
                    name.text= it[i].name
                    val company = TextView(this.context)
                    company.textSize=20F
                    company.layoutParams=params
                    company.text= it[i].company
                    val size = TextView(this.context)
                    size.textSize=20F
                    size.layoutParams=params
                    size.text= it[i].size
                    val description = TextView(this.context)
                    description.textSize=20F
                    description.layoutParams=params
                    description.text= it[i].description
                    binding.listLinearLayout.addView(name)
                    binding.listLinearLayout.addView(company)
                    binding.listLinearLayout.addView(size)
                    binding.listLinearLayout.addView(description)
                }
            })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(R.id.logout==item.itemId)
            findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }
}