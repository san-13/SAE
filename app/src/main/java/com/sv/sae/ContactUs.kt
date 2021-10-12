package com.sv.sae

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sv.sae.databinding.FragmentContactUsBinding
import com.sv.sae.databinding.FragmentHomeBinding

class ContactUs : Fragment() {

    private var _binding:FragmentContactUsBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentContactUsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number1 = binding.number.text.toString()
        val callIntent: Intent = Uri.parse(number1).let { number->
            Intent(Intent.ACTION_DIAL,number)
        }
        binding.number.setOnClickListener{
            startActivity(callIntent)
        }
        binding.emailid.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(binding.emailid.text.toString())))
        }
        val number2 = binding.number2.text.toString()
        val callIntent2: Intent = Uri.parse(number2).let { number->
            Intent(Intent.ACTION_DIAL,number)
        }
        binding.number.setOnClickListener{
            startActivity(callIntent2)
        }
        binding.emailid2.setOnClickListener{
            startActivity(Intent(Intent.ACTION_SEND, Uri.parse(binding.emailid2.text.toString())))
        }
    }


}