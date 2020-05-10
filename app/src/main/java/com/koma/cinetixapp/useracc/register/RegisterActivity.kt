package com.koma.cinetixapp.useracc.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.database.*
import com.koma.cinetixapp.R
import com.koma.cinetixapp.useracc.login.User
import com.koma.cinetixapp.utils.Preferences
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var sUsername:String
    lateinit var sPassword:String
    lateinit var sNama:String
    lateinit var sEmail:String

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mFirebaseInstance = FirebaseDatabase.getInstance()
//        mDatabase = FirebaseDatabase.getInstance().getReference()
        mFirebaseDatabase = mFirebaseInstance.getReference("User")

        preferences = Preferences(this)

        btn_home.setOnClickListener {
            sUsername = et_username.text.toString()
            sPassword = et_password.text.toString()
            sNama = et_nama.text.toString()
            sEmail = et_email.text.toString()

            if (sUsername.equals("")) {
                et_username.error = "KOSONG?!"
                et_username.requestFocus() //fokus ke yang error
            } else if (sPassword.equals("")) {
                et_password.error = "KOSONG?!"
                et_password.requestFocus()
            } else if (sNama.equals("")) {
                et_nama.error = "KOSONG?!"
                et_nama.requestFocus()
            } else if (sEmail.equals("") || !Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
                et_email.error = "Harap isi alamat email dengan benar"
                et_email.requestFocus()
            } else {
                saveUser(sUsername, sPassword, sNama, sEmail)
            }
        }
    }

    private fun saveUser(sUsername: String, sPassword: String, sNama: String, sEmail: String) {

        val user = User()
        user.email = sEmail
        user.username = sUsername
        user.nama = sNama
        user.password = sPassword

        if (sUsername != null) {
            checkingUsername(sUsername, user)

        }

    }

    private fun checkingUsername(iUsername: String, data: User) {
        mFirebaseDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(User::class.java)
                if (user == null) {
                    mFirebaseDatabase.child(iUsername).setValue(data)

                    preferences.setValues("nama", data.nama.toString())
                    preferences.setValues("user", data.username.toString())
                    preferences.setValues("url", "")
                    preferences.setValues("saldo", "")
                    preferences.setValues("email", data.email.toString())
                    preferences.setValues("status", "1")

                    val intent = Intent(this@RegisterActivity,
                        RegisterPhotoActivity::class.java).putExtra("nama", data.nama)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@RegisterActivity, "User sudah terdaftar", Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@RegisterActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

}
