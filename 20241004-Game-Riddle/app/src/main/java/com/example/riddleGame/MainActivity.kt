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

        val tvRiddle = findViewById<TextView>(R.id.riddle)
        val edAnswer = findViewById<EditText>(R.id.ed_answer)
        val btnRiddle = findViewById<Button>(R.id.btn_riddle)
        val btnAnswer = findViewById<Button>(R.id.btn_answer)
        val btnReAnswer = findViewById<Button>(R.id.btn_reAnswer)
        val btnShowAnswer = findViewById<Button>(R.id.btn_showAnswer)
        val tvResult = findViewById<TextView>(R.id.Result)

        var index = 0
        val riddleList = mutableListOf(
            "0000，猜一句成語。:AAA",
            "人有他大，天沒他大。:BBB",
            "台灣女孩，猜一個字。:CCC",
            "九十九，猜一個字。:DDD",
            "0+0=1，猜一成語。:EEE。"
        )

        edAnswer.text = null
        tvResult.text = null

        btnRiddle.setOnClickListener {
            val countRiddle = riddleList.count()
            val (riddle, answer) = riddleList[index].split(":").map { it.trim() }
            tvRiddle.text = "謎題 : $riddle"
            index++
            if (index >= countRiddle) index = 0

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

            btnReAnswer.setOnClickListener {
                edAnswer.text = null
                tvResult.text = null
            }

            btnShowAnswer.setOnClickListener {
                tvResult.text = "謎底是：$answer"
            }
        }
    }
}
