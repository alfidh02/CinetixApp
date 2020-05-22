package com.koma.cinetixapp.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast

import com.koma.cinetixapp.R
import com.koma.cinetixapp.home.HomeActivity
import com.koma.cinetixapp.home.TiketActivity
import com.koma.cinetixapp.home.model.Film
import kotlinx.android.synthetic.main.activity_top_up_success.*


class TopUpSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_up_success)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val datapass = intent.getParcelableExtra<Film>("datafilm")

        btn_home.setOnClickListener {

            val intent = Intent(this@TopUpSuccessActivity,
                HomeActivity::class.java)
            startActivity(intent)
            finishAffinity()

        }

        btn_wallet.setOnClickListener {
            val intent = Intent(this@TopUpSuccessActivity,
                MyWallet::class.java)
            startActivity(intent)
            finishAffinity()
        }

    }

    override fun onBackPressed() {
        Toast.makeText(this,"Terima kasih telah mengisi saldo! Harap tunggu ya.",Toast.LENGTH_SHORT).show()
    }
}
