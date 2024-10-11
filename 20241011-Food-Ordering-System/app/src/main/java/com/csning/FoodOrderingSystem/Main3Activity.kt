package com.csning.FoodOrderingSystem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Main3Activity : AppCompatActivity() {

    var iceGroup: RadioGroup? = null
    var sugarGroup: RadioGroup? = null

    lateinit var ice: RadioButton
    lateinit var sugar: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var tvTable3=findViewById<TextView>(R.id.tv_table3)
        var btnDrinkConfirm=findViewById<Button>(R.id.btn_drinkConfirm)

        //輸入飲料名稱
        var edDrink=findViewById<EditText>(R.id.ed_drink)
        var drink=edDrink.text

        //
        sugarGroup = findViewById(R.id.radioGroup1)
        iceGroup = findViewById(R.id.radioGroup2)

        //接收並顯示由主頁intent傳來之桌次
        tvTable3.text= intent.getStringExtra("dataTransfer")

        btnDrinkConfirm.setOnClickListener {
            // 由單選清單 radioGroup 取得選項ID
            var selectedOption: Int = iceGroup!!.checkedRadioButtonId
            // 由選項ID取得冰塊量
            ice = findViewById(selectedOption)
            //Toast.makeText(baseContext, ice.text, Toast.LENGTH_SHORT).show()
            selectedOption = sugarGroup!!.checkedRadioButtonId
            // 由選項ID取得冰塊量
            sugar = findViewById(selectedOption)
            //Toast.makeText(baseContext, sugar.text, Toast.LENGTH_SHORT).show()

            val finalDrink = "$drink \n\n甜度：${sugar.text} \n\n冰塊：${ice.text}"
            val intent = Intent().apply {
                putExtra("result", "$finalDrink")

            }

            //透過setResult將資料回傳
            setResult(Activity.RESULT_OK, intent)
            //結束Main2Activity
            finish()
        }
    }
}