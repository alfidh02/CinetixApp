package com.koma.cinetixapp.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.core.view.isInvisible
import com.koma.cinetixapp.R
import kotlinx.android.synthetic.main.activity_top_up.*

class TopUp : AppCompatActivity() {

    private var status10K : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_up)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        btn_topup.setOnClickListener {
            startActivity(Intent(this,TopUpSuccessActivity::class.java))
        }

        tv_10k.setOnClickListener {
            if (status10K) {
                deselectedMoney(tv_10k)
            } else {
                selectedMoney(tv_10k)
            }
        }
    }

    private fun selectedMoney(textView: TextView){
        textView.setTextColor(resources.getColor(R.color.colorPink))
        textView.setBackgroundResource(R.drawable.shape_line_pink)
        status10K = true

        btn_topup.visibility = View.VISIBLE
        editText2.isCursorVisible = false
    }

    private fun deselectedMoney(textView: TextView){
        textView.setTextColor(resources.getColor(android.R.color.white))
        textView.setBackgroundResource(R.drawable.shape_line_white)
        status10K = false

        btn_topup.visibility = View.INVISIBLE
        editText2.isCursorVisible = true
    }
}
