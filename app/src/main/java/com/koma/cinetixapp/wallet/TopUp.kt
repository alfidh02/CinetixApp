package com.koma.cinetixapp.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.koma.cinetixapp.R
import kotlinx.android.synthetic.main.activity_top_up.*

class TopUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_up)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        btn_topup.setOnClickListener {
            startActivity(Intent(this,TopUpSuccessActivity::class.java))
        }
    }
}
