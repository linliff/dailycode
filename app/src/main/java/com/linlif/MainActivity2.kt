package com.linlif

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.linlif.kotlindemo.R

class MainActivity2 : AppCompatActivity() {

    lateinit var mBtn1: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //顶层函数
//        val dp = 2f.dp(this)
//
//        GlobalScope.launch { }//不推荐使用，生命周期不好控制

        findViewById<View>(R.id.btn1).setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        })
    }


}
