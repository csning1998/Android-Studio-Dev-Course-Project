package com.gu.example6_2userdefinecontract

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //連結物件
        var btnMeal=findViewById<Button>(R.id.btn_meal)
        var btnDrink=findViewById<Button>(R.id.btn_drink)
        var tableNo=findViewById<EditText>(R.id.ed_tableNo)
        var tvMeal=findViewById<TextView>(R.id.tv_meal)
        var txtTableNo=tableNo.text
        var tvDrink=findViewById<TextView>(R.id.tv_drink)

        //註冊協議2以取得回傳主餐名稱，及第２頁啟動器
        val myActivityLauncher2 = registerForActivityResult(MyActivityResultContract2()){result ->
            tvMeal.text="主餐： $result"
        }

        //註冊協議3以取得回傳飲料名稱，及第３頁啟動器
        val myActivityLauncher3 = registerForActivityResult(MyActivityResultContract3()){result ->

            //tvDrink.text = String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n", "$result")
            tvDrink.text = "飲料：$result"
        }
        //點按主餐
        btnMeal.setOnClickListener {
            //判斷是否沒輸入桌次
            if (tableNo.length()<1)
                tableNo.hint = "請輸入桌號!"
            else {
                // 跳轉至主餐頁,並傳送桌號
                myActivityLauncher2.launch("$txtTableNo")
            }
        }

        //點按飲料
        btnDrink.setOnClickListener {
            // 跳轉至飲料頁,並傳送桌號
            myActivityLauncher3.launch("$txtTableNo")
        }
    }
}