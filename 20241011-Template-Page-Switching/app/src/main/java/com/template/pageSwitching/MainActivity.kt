package com.template.pageSwitching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.template.pageSwitching.R
import com.template.pageSwitching.R.id.MsgfromPage2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //連結物件
        var btn=findViewById<Button>(R.id.btn1to2)
        var callbackMsg=findViewById<TextView>(MsgfromPage2)

        //註冊協議以取得回傳資料
        val myActivityLauncher = registerForActivityResult(MyActivityResultContract()){ result ->
            //顯示回傳資料
            callbackMsg.text="回傳的資料：$result"
            //也可寫成
            //"回傳資料：$result".also { msg1.text = it }
        }

        btn.setOnClickListener {
            // 取得啟動器，開啟頁面跳轉,傳送資料
            myActivityLauncher.launch("這是第1頁傳送的資料")
        }

    }
}


