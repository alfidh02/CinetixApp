package com.koma.cinetixapp.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.koma.cinetixapp.R
import com.koma.cinetixapp.useracc.login.LoginActivity
import com.koma.cinetixapp.utils.Preferences
import kotlinx.android.synthetic.main.activity_page_one.*

class PageOneActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_one)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        preferences = Preferences(this)

        if (preferences.getValues("onboarding").equals("1")) {

            val intent = Intent(this@PageOneActivity,
                LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finishAffinity()
        }


        btn_home.setOnClickListener {
            val intent = Intent(this@PageOneActivity,PageTwoActivity::class.java)
            startActivity(intent)
        }

        btn_daftar.setOnClickListener {
            val intent = Intent(this@PageOneActivity,
                LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}
