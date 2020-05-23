package com.koma.cinetixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.koma.cinetixapp.home.TiketActivity
import com.koma.cinetixapp.home.dashboard.ComingSoonAdapter
import com.koma.cinetixapp.home.model.Film
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    private var dataList = ArrayList<Film>()
    lateinit var hDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        hDatabase = FirebaseDatabase.getInstance().getReference("Film")

        imageView3.setOnClickListener {
            finish()
        }

        rc_history.layoutManager = LinearLayoutManager(this)
        getDataHistory()
    }

    private fun getDataHistory() {
        hDatabase.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()){
                    val film = getdataSnapshot.getValue(Film::class.java)
                    dataList.add(film!!)
                }

                rc_history.adapter = ComingSoonAdapter(dataList){
                    val intent = Intent (applicationContext,
                        TiketActivity::class.java).putExtra("data",it)
                    startActivity(intent)
                }

                textView37.setText(dataList.size.toString() + " Movies")
            }


            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, ""+error.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}
