package com.koma.cinetixapp.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.koma.cinetixapp.R
import com.koma.cinetixapp.useracc.LoginActivity
import kotlinx.android.synthetic.main.activity_page_one.*

class PageOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_one)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        btn_home.setOnClickListener {
            val intent = Intent(this@PageOneActivity,PageTwoActivity::class.java)
            startActivity(intent)
        }

        btn_daftar.setOnClickListener {
            val intent = Intent(this@PageOneActivity,LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}
