package com.sv.sae.model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sv.sae.R
import com.sv.sae.databinding.EventsBtmSheetBinding
import com.sv.sae.databinding.InfoBtmSheetBinding
import com.sv.sae.info_btm_sheetArgs

class events_btm_sheet: BottomSheetDialogFragment() {
    private var _binding: EventsBtmSheetBinding?=null
    private val binding get()=_binding!!
    private val navigationArgs: events_btm_sheetArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= EventsBtmSheetBinding.inflate(inflater,container,false)
        return binding.root
        return inflater.inflate(R.layout.events_btm_sheet,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.text=navigationArgs.name
        binding.desc.text=navigationArgs.desc

    }
}