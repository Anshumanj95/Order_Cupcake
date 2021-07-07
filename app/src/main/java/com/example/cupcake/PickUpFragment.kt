package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentPickUpBinding
import com.example.cupcake.model.OrderViewModel


class PickUpFragment : Fragment() {
    private val sharedViewModel:OrderViewModel by activityViewModels()
    private var binding: FragmentPickUpBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding= FragmentPickUpBinding.inflate(inflater,container,false)
        binding=fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel=sharedViewModel
            lifecycleOwner=viewLifecycleOwner
            pickUpFragment=this@PickUpFragment
        }
    }

    fun gotonextScreen(){
        Toast.makeText(activity,"Next Screen", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_pickUpFragment_to_summaryFragment)
    }
    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_pickUpFragment_to_startFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}