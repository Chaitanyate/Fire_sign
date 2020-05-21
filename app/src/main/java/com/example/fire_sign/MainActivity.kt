package com.example.fire_sign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mAuth:FirebaseAuth?=null
    var mAuthListner:FirebaseAuth.AuthStateListener?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth=FirebaseAuth.getInstance()
        mAuthListner=FirebaseAuth.AuthStateListener {  }


    }
    fun signup(view:View){
        mAuth!!.createUserWithEmailAndPassword(user.text.toString(),pass.text.toString()).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(applicationContext,"User Created!!",Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage.toString(),Toast.LENGTH_LONG).show()
        }
    }
}
