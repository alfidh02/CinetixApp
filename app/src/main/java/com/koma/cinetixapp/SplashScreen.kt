package com.koma.cinetixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.koma.cinetixapp.onboarding.PageOneActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        var handler = Handler()
        handler.postDelayed({
            val intent = Intent(this,PageOneActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}
