package com.sv.sae

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.sv.sae.adapters.h_cryptech_adapter
import com.sv.sae.adapters.h_events_adapter
import com.sv.sae.adapters.h_webinar_adapter
import com.sv.sae.model.cryptechModel
import com.sv.sae.model.eventModel
import com.sv.sae.model.webinarModel
import kotlinx.coroutines.launch

class appviewmodel: ViewModel() {
    private lateinit var dref: DatabaseReference
    private lateinit var eventList: ArrayList<eventModel>
    lateinit var cryptechList:ArrayList<cryptechModel>
    private lateinit var webinarList:ArrayList<webinarModel>



         fun imCryptech() {

            cryptechList = arrayListOf<cryptechModel>()
            //var clist = arrayListOf<cryptechModel>()
            //  viewModelScope.launch {
            dref = FirebaseDatabase.getInstance().getReference("Cryptech")
            dref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (userSnapshot in snapshot.children) {
                            val cryptech = userSnapshot.getValue(cryptechModel::class.java)
                            cryptechList.add(cryptech!!)
                            // Log.i("pid", cryptechList.toString())
                        }
                        Log.i("pidif", cryptechList.toString())

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
            //return cryptechList
        Log.i("pid", cryptechList.toString())
        }


    private fun imEvents(): ArrayList<eventModel> {

        eventList = arrayListOf<eventModel>()
        viewModelScope.launch {
            dref = FirebaseDatabase.getInstance().getReference("Events")
            dref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (userSnapshot in snapshot.children) {
                            val event = userSnapshot.getValue(eventModel::class.java)
                            eventList.add(event!!)
                            Log.e("pid", "can not read")

                        }
                        //binding.eventsRecycler.adapter = h_events_adapter(eventList)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
        return eventList

    }

    private fun imWebinar(): ArrayList<webinarModel> {

        webinarList = arrayListOf<webinarModel>()
        viewModelScope.launch {
            dref = FirebaseDatabase.getInstance().getReference("Webinar")
            dref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (userSnapshot in snapshot.children) {
                            val webinar = userSnapshot.getValue(webinarModel::class.java)
                            webinarList.add(webinar!!)
                            Log.e("pid", "can not read cryptech")

                        }
                        //  binding.webinarRecycler.adapter = h_webinar_adapter(webinarList)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
        return webinarList
    }


}