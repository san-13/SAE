package com.sv.sae

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sv.sae.databinding.FragmentAboutUsBinding

class AboutUs : Fragment() {

    private var _binding:FragmentAboutUsBinding?=null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentAboutUsBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val instagram="https://www.instagram.com/sae.nitd/"
        val facebook="https://www.facebook.com/SAENITD"
        val youtube="https://www.youtube.com/channel/UC9H4onmkThYbMHrce2PceQg"
        val twitter="https://twitter.com/saeindia_nitdgp"
        val linkedin="https://www.linkedin.com/company/sae-india-nit-dgp-collegiate-chapter/"
        binding.instagram.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(instagram)))
        }
        binding.youtube.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(youtube)))
        }
        binding.linkedin.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(linkedin)))
        }
        binding.facebook.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(facebook)))
        }
        binding.twitter.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(twitter)))
        }
    }

}