package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentStartBinding
import com.example.cupcake.model.OrderViewModel

class StartFragment : Fragment() {
    private val sharedViewModel:OrderViewModel by activityViewModels()
    private var binding:FragmentStartBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding=FragmentStartBinding.inflate(inflater,container,false)
        binding=fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment=this
    }

     fun orderCupcake(number:Int){
        Toast.makeText(activity,"Order $number Cupcake(s)",Toast.LENGTH_SHORT).show()
        sharedViewModel.setQuantity(number)
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }
        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}