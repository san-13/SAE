package com.sv.sae

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.sv.sae.adapters.*
import com.sv.sae.databinding.FragmentHomeBinding
import com.sv.sae.databinding.FragmentTeamBinding
import com.sv.sae.model.cryptechModel
import com.sv.sae.model.eventModel
import com.sv.sae.model.teamModel
import com.sv.sae.model.webinarModel

class Team : Fragment() {

    private var _binding: FragmentTeamBinding?=null
    private val binding get()=_binding!!
    private lateinit var dref : DatabaseReference
    private lateinit var olist:ArrayList<teamModel>
    private lateinit var fList:ArrayList<teamModel>
    private lateinit var tList:ArrayList<teamModel>
    private lateinit var slist:ArrayList<teamModel>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentTeamBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imoffice()
        imfinal()
        imthird()
        imsecond()

    }

    private fun imoffice() {
        binding.officeRecycler.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        olist = arrayListOf<teamModel>()
        dref= FirebaseDatabase.getInstance().getReference("FinalYear")
        dref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val office = userSnapshot.getValue(teamModel::class.java)
                        olist.add(office!!)
                        // Log.e("pid","can not read cryptech")

                    }
                    binding.officeRecycler.adapter = office_adapter(olist)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun imfinal(){
        binding.finalRecycler.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        fList = arrayListOf<teamModel>()
        dref= FirebaseDatabase.getInstance().getReference("FinalYear")
        dref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val final = userSnapshot.getValue(teamModel::class.java)
                        fList.add(final!!)
                        //  Log.e("pid","can not read")

                    }
                    binding.finalRecycler.adapter = final_adapter(fList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun imthird() {
        binding.thirdRecycler.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        tList = arrayListOf<teamModel>()
        dref= FirebaseDatabase.getInstance().getReference("FinalYear")
        dref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val third = userSnapshot.getValue(teamModel::class.java)
                        tList.add(third!!)
                        //  Log.e("pid","can not read cryptech")

                    }
                    binding.thirdRecycler.adapter = third_adapter(tList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun imsecond() {
        binding.secondRecycler.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        slist = arrayListOf<teamModel>()
        dref= FirebaseDatabase.getInstance().getReference("FinalYear")
        dref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val second = userSnapshot.getValue(teamModel::class.java)
                        slist.add(second!!)
                        //  Log.e("pid","can not read cryptech")

                    }
                    binding.secondRecycler.adapter = second_adapter(slist)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }






}