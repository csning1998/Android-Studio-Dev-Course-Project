package com.csning.FoodOrderingSystem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*

class Main3Activity : AppCompatActivity() {

    var iceGroup: RadioGroup? = null
    var sugarGroup: RadioGroup? = null

    lateinit var ice: RadioButton
    lateinit var sugar: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var tvTable3 = findViewById<TextView>(R.id.tv_table3)
        var btnDrinkConfirm = findViewById<Button>(R.id.btn_drinkConfirm)

        //輸入飲料名稱
        var edDrink = findViewById<EditText>(R.id.ed_drink)
        var drink = edDrink.text

        //
        sugarGroup = findViewById(R.id.radioGroup1)
        iceGroup = findViewById(R.id.radioGroup2)

        //接收並顯示由主頁intent傳來之桌次
        tvTable3.text= intent.getStringExtra("dataTransfer")

        edDrink.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty() || s.toString() == "無") {
                    iceGroup?.isEnabled = false
                    sugarGroup?.isEnabled = false
                } else {
                    iceGroup?.isEnabled = true
                    sugarGroup?.isEnabled = true
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        btnDrinkConfirm.setOnClickListener {

            val drink = if (edDrink.text.isEmpty()) "無" else edDrink.text.toString()

            var selectedIceText = "無"
            var selectedSugarText = "無"

            val selectedIceOption = iceGroup!!.checkedRadioButtonId
            if (selectedIceOption != -1) { // 确保有选择冰块
                ice = findViewById(selectedIceOption)
                selectedIceText = ice.text.toString()
            }

            val selectedSugarOption = sugarGroup!!.checkedRadioButtonId
            if (selectedSugarOption != -1) { // 确保有选择甜度
                sugar = findViewById(selectedSugarOption)
                selectedSugarText = sugar.text.toString()
            }

            if (drink == "無") {
                selectedIceText = "無"
                selectedSugarText = "無"
            }

            val finalDrink = "$drink \n\n甜度：$selectedSugarText \n\n冰块：$selectedIceText"
            val intent = Intent().apply {
                putExtra("result", finalDrink)
            }

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}