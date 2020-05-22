package com.koma.cinetixapp.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.koma.cinetixapp.R
import com.koma.cinetixapp.wallet.adapter.WalletAdapter
import com.koma.cinetixapp.wallet.model.Wallet
import kotlinx.android.synthetic.main.activity_my_wallet.*

class MyWallet : AppCompatActivity() {

    private var dataList = ArrayList<Wallet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_wallet)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        imageView3.setOnClickListener {
            finish()
        }

        dataList.add(
            Wallet("Tenki No Ko",
            "Sabtu 2 Mei, 2020",
            22000.0,
            "0")
        )
        dataList.add(
            Wallet("Top Up",
            "Sabtu 2 Mei, 2020",
            22000.0,
            "1")
        )
        dataList.add(
            Wallet("Tenki No Ko",
            "Sabtu 2 Mei, 2020",
            22000.0,
            "0")
        )

        rv_transaksi.layoutManager = LinearLayoutManager(this)
        rv_transaksi.adapter = WalletAdapter(dataList){

        }

        btn_topup.setOnClickListener {
            startActivity(Intent(this,TopUp::class.java))
        }

    }
}
