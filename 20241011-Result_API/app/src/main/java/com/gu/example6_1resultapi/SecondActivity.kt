package com.gu.example6_1resultapi

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var msg2=findViewById<TextView>(R.id.textPage2)
        var btn2=findViewById<Button>(R.id.button2)

        //接收由intent傳來之訊息
        val dataReceive = intent.getStringExtra("dataInput")
        //顯示接收到的訊息
        msg2.text = "接收的資料：$dataReceive"

        //回傳按鈕
        btn2.setOnClickListener {
            val intent = Intent().apply {
                putExtra("dataReturn","這是從第2頁回傳的資料！")
            }
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }
}