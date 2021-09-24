package com.sv.sae

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.sv.sae.databinding.FragmentLoginBinding

class Login : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private var _binding: FragmentLoginBinding?=null
    private val binding get()=_binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gso =GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient=GoogleSignIn.getClient(context,gso)
        auth= FirebaseAuth.getInstance()
        if(auth.currentUser!=null){
            //findNavController().navigate(R.id.action_login_to_home2)
            val intent=Intent(getActivity(),LogedinActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* val email = binding.email.text.toString()
        val pass=binding.pass.text.toString()


        binding.loginBtn.setOnClickListener{
            val email = binding.email.text.toString()
            val pass=binding.pass.text.toString()
            if(isEntryValid(email,pass)){
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(requireActivity()){task->
                    if(task.isSuccessful){
                        //findNavController().navigate(R.id.action_login_to_home2)
                        val intent=Intent(getActivity(),LogedinActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        val toast =Toast.makeText(requireActivity(),"Authentication Failed: {task.exception?.message}",Toast.LENGTH_SHORT)
                        toast.show()
                    }
                }

            }
        } */
        binding.googlebtn.setOnClickListener{
            val intent=googleSignInClient.signInIntent
            startActivityForResult(intent,RC_SIGN_IN)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                   //findNavController().navigate(R.id.action_login_to_home2)
                    val intent=Intent(getActivity(),LogedinActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    val toast =Toast.makeText(requireActivity(),"Authentication Failed: {task.exception?.message}",Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
    }
   /* fun isEntryValid(email:String,pass:String):Boolean{
        var status = true
        if(email.isBlank()||pass.isBlank()){
            status =false
        }
        return status
    }*/
    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }

}