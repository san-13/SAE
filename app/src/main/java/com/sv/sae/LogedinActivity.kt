package com.sv.sae

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_logedin.*


class LogedinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logedin)
        auth= FirebaseAuth.getInstance()
        val acct: GoogleSignInAccount = GoogleSignIn.getLastSignedInAccount(this)
        if(acct!=null) {
            val name = acct.displayName.toString()
            val photo = acct.photoUrl.toString()
            val navigationView: NavigationView = findViewById(R.id.nav_view)
            val headerView:View=navigationView.getHeaderView(0)
            val navName:TextView=headerView.findViewById(R.id.userName)
            val navImage:ImageView=headerView.findViewById(R.id.userImage)
            navName.text=name
            Picasso.get().load(photo).into(navImage)
        }
        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home2 -> replaceFragment(Home(),it.title.toString())
                R.id.team2 -> replaceFragment(Team(),it.title.toString())
                R.id.aboutUs -> replaceFragment(AboutUs(),it.title.toString())
                R.id.contactUs->replaceFragment(ContactUs(),it.title.toString())
                R.id.SignOut -> signout()


            }
            true
        }
    }
    private fun signout(){

        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
    private fun replaceFragment(fragment: Fragment, title: String){
         val fragmentManager = supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2,fragment).isAddToBackStackAllowed
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        //findNavController().navigate(R.id.action_home2_to_events_btm_sheet)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }

        return super.onOptionsItemSelected(item)

    }


}