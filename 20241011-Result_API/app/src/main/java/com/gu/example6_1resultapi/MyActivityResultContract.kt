package com.gu.example6_1resultapi

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

//定義協議:
class MyActivityResultContract: ActivityResultContract<String, String>() {
    //1.建構Intent及夾帶資料
    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context,SecondActivity::class.java).apply {
            putExtra("dataInput",input)
        }
    }
    //2.接收回傳資料
    override fun parseResult(resultCode: Int, intent: Intent?): String {
        val data = intent?.getStringExtra("dataReturn")
        return  if(resultCode == Activity.RESULT_OK && data != null) data
        else ""
    }

}