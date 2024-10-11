package com.example.riddleGame

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.riddleGame.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 綁定變數與畫面元件
        val tvRiddle = findViewById<TextView>(R.id.riddle)
        val edAnswer = findViewById<EditText>(R.id.ed_answer)
        val btnRiddle = findViewById<Button>(R.id.btn_riddle)
        val btnAnswer = findViewById<Button>(R.id.btn_answer)
        val btnReAnswer = findViewById<Button>(R.id.btn_reAnswer)
        val btnShowAnswer = findViewById<Button>(R.id.btn_showAnswer)
        val tvResult = findViewById<TextView>(R.id.Result)

        // 用 list 儲存謎題及答案
        var index = 0 // 初始化出題指標
        val riddleList = mutableListOf(
            "0000，猜一句成語。:AAA",
            "人有他大，天沒他大。:BBB",
            "台灣女孩，猜一個字。:CCC",
            "九十九，猜一個字。:DDD",
            "0+0=1，猜一成語。:EEE。"
        )

        // 按出題鍵
        edAnswer.text = null
        tvResult.text = null

        btnRiddle.setOnClickListener {
            val countRiddle = riddleList.count()
            val (riddle, answer) = riddleList[index].split(":").map { it.trim() }
            tvRiddle.text = "謎題 : $riddle"
            index++
            if (index >= countRiddle) index = 0

            // 按答題鍵
            btnAnswer.setOnClickListener {
                val ans = edAnswer.text
                if (ans.toString() == answer) {
                    println("Answer:$answer")
                    tvResult.text = "好棒，您答對了！"
                    Toast.makeText(this, edAnswer.text, Toast.LENGTH_SHORT).show()
                } else {
                    tvResult.text = "沒猜中，再試一下吧!"
                }
            }

            // 按重答鍵
            btnReAnswer.setOnClickListener {
                edAnswer.text = null
                tvResult.text = null
            }

            // 按顯示答案鍵
            btnShowAnswer.setOnClickListener {
                tvResult.text = "謎底是：$answer"
            }
        }
    }
}
