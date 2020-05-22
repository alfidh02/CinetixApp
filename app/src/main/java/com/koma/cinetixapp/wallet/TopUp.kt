package com.koma.cinetixapp.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.koma.cinetixapp.R
import kotlinx.android.synthetic.main.activity_top_up.*

class TopUp : AppCompatActivity() {

    private var status10K : Boolean = false
    private var status25K : Boolean = false
    private var status50K : Boolean = false
    private var status100K : Boolean = false
    private var status200K : Boolean = false
    private var status500K : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_up)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        imageView3.setOnClickListener {
            finish()
        }

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

        tv_25k.setOnClickListener {
            if (status25K) {
                deselectedMoney(tv_25k)
            } else {
                selectedMoney(tv_25k)
            }
        }

        tv_50k.setOnClickListener {
            if (status50K) {
                deselectedMoney(tv_50k)
            } else {
                selectedMoney(tv_50k)
            }
        }

        tv_100k.setOnClickListener {
            if (status100K) {
                deselectedMoney(tv_100k)
            } else {
                selectedMoney(tv_100k)
            }
        }

        tv_200k.setOnClickListener {
            if (status200K) {
                deselectedMoney(tv_200k)
            } else {
                selectedMoney(tv_200k)
            }
        }

        tv_500k.setOnClickListener {
            if (status500K) {
                deselectedMoney(tv_500k)
            } else {
                selectedMoney(tv_500k)
            }
        }
    }

    private fun selectedMoney(textView: TextView){
        textView.setTextColor(resources.getColor(R.color.colorPink))
        textView.setBackgroundResource(R.drawable.shape_line_pink)
        status10K = true
        status25K = true
        status50K = true
        status100K = true
        status200K = true
        status500K = true

        btn_topup.visibility = View.VISIBLE
        editText2.isCursorVisible = false
    }

    private fun deselectedMoney(textView: TextView){
        textView.setTextColor(resources.getColor(android.R.color.white))
        textView.setBackgroundResource(R.drawable.shape_line_white)
        status10K = false
        status25K = false
        status50K = false
        status100K = false
        status200K = false
        status500K = false

        btn_topup.visibility = View.INVISIBLE
        editText2.isCursorVisible = true
    }
}
