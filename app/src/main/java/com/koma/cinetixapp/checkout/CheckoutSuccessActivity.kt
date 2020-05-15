package com.koma.cinetixapp.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast

import com.koma.cinetixapp.R
import com.koma.cinetixapp.home.HomeActivity
import com.koma.cinetixapp.home.TiketActivity
import com.koma.cinetixapp.home.model.Film
import kotlinx.android.synthetic.main.activity_checkout_success.*


class CheckoutSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_success)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val datapass = intent.getParcelableExtra<Film>("datafilm")

        btn_home.setOnClickListener {

            val intent = Intent(this@CheckoutSuccessActivity,
                HomeActivity::class.java)
            startActivity(intent)
            finishAffinity()

        }

        btn_tiket.setOnClickListener {
            val intent = Intent(this@CheckoutSuccessActivity,
                TiketActivity::class.java).putExtra("data",datapass)
            startActivity(intent)
            finishAffinity()
        }

    }

    override fun onBackPressed() {
        Toast.makeText(this,"Terima kasih telah membeli tiket!",Toast.LENGTH_SHORT).show()
    }
}
