package com.koma.cinetixapp.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.koma.cinetixapp.HistoryActivity

import com.koma.cinetixapp.R
import com.koma.cinetixapp.home.dashboard.ComingSoonAdapter
import com.koma.cinetixapp.home.model.Film
import com.koma.cinetixapp.utils.Preferences
import kotlinx.android.synthetic.main.fragment_tiket.*

/**
 * A simple [Fragment] subclass.
 */
class TiketFragment : Fragment() {

    private lateinit var preferences: Preferences
    lateinit var mDatabase: DatabaseReference

    private var dataList = ArrayList<Film>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tiket, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(activity!!.applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("Film")

        rc_tiket.layoutManager = LinearLayoutManager(context!!.applicationContext)
        getData()

        iv_history.setOnClickListener {
            startActivity(Intent(context,HistoryActivity::class.java))
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()) {

                    val film = getdataSnapshot.getValue(Film::class.java!!)
                    dataList.add(film!!)
                }

                rc_tiket.adapter = ComingSoonAdapter(dataList) {
                    val intent= Intent(context,
                        TiketActivity::class.java).putExtra("data", it)
                    startActivity(intent)
                }

                tv_total.setText(dataList.size.toString() +" Movies")

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }

}
