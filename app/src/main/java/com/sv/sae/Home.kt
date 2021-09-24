package com.sv.sae

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.sv.sae.adapters.h_cryptech_adapter
import com.sv.sae.adapters.h_events_adapter
import com.sv.sae.adapters.h_webinar_adapter
import com.sv.sae.adapters.latest_adapter
import com.sv.sae.databinding.FragmentHomeBinding
import com.sv.sae.databinding.NavHeaderBinding
import com.sv.sae.model.cryptechModel
import com.sv.sae.model.eventModel
import com.sv.sae.model.latestModel
import com.sv.sae.model.webinarModel


class Home : Fragment() {
    private lateinit var auth: FirebaseAuth
    private var _binding:FragmentHomeBinding?=null
    private val binding get()=_binding!!
    private lateinit var dref : DatabaseReference
    private lateinit var eventList : ArrayList<eventModel>
    private lateinit var cryptechList:ArrayList<cryptechModel>
    private lateinit var webinarList:ArrayList<webinarModel>
    private lateinit var latestList:ArrayList<latestModel>

 //   private val viewmodel: appviewmodel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        latestEvent()
        imCryptech()
        imEvents()
        imWebinar()

    }

    private fun latestEvent() {
        binding.latestRecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        latestList = arrayListOf<latestModel>()
        dref=FirebaseDatabase.getInstance().getReference("latest")
        dref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val latest = userSnapshot.getValue(latestModel::class.java)
                        latestList.add(latest!!)
                        // Log.e("pid","can not read cryptech")

                    }
                    binding.latestRecycler.adapter = latest_adapter(latestList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

    private fun imCryptech() {
        binding.cryptechRecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
       /* viewmodel.imCryptech()
        binding.cryptechRecycler.adapter = h_cryptech_adapter(viewmodel.cryptechList)
        Log.i("pidh",viewmodel.cryptechList.toString()) */
        cryptechList = arrayListOf<cryptechModel>()
        dref=FirebaseDatabase.getInstance().getReference("Cryptech")
        dref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val cryptech = userSnapshot.getValue(cryptechModel::class.java)
                        cryptechList.add(cryptech!!)
                       // Log.e("pid","can not read cryptech")

                    }
                    binding.cryptechRecycler.adapter = h_cryptech_adapter(cryptechList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun imEvents(){
        binding.eventsRecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        eventList = arrayListOf<eventModel>()
        dref=FirebaseDatabase.getInstance().getReference("Events")
        dref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val event = userSnapshot.getValue(eventModel::class.java)
                        eventList.add(event!!)
                      //  Log.e("pid","can not read")

                    }
                    binding.eventsRecycler.adapter = h_events_adapter(eventList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun imWebinar() {
        binding.webinarRecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        webinarList = arrayListOf<webinarModel>()
        dref=FirebaseDatabase.getInstance().getReference("Webinar")
        dref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val webinar = userSnapshot.getValue(webinarModel::class.java)
                        webinarList.add(webinar!!)
                      //  Log.e("pid","can not read cryptech")

                    }
                    binding.webinarRecycler.adapter = h_webinar_adapter(webinarList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}