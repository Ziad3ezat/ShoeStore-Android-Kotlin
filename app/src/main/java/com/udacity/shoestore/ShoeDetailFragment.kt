package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.Navigation.createNavigateOnClickListener
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentShoeDetailBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        binding.btCancel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment))
        binding.lifecycleOwner = viewLifecycleOwner
        binding.shoeViewModel=viewModel
        binding.btSave.setOnClickListener{
            viewModel.createShoe()
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return binding.root
    }

}