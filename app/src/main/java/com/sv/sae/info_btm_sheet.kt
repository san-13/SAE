package com.sv.sae

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sv.sae.databinding.FragmentHomeBinding
import com.sv.sae.databinding.FragmentLoginBinding
import com.sv.sae.databinding.InfoBtmSheetBinding
import java.net.URL

class info_btm_sheet: BottomSheetDialogFragment() {

    private var _binding:InfoBtmSheetBinding?=null
    private val binding get()=_binding!!
    private val navigationArgs: info_btm_sheetArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= InfoBtmSheetBinding.inflate(inflater,container,false)
        return binding.root
        return inflater.inflate(R.layout.info_btm_sheet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.test.text=navigationArgs.name
        binding.desc.text=navigationArgs.description
        binding.playBtn.setOnClickListener{
            val uri= navigationArgs.ytlink
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
        }

    }
}