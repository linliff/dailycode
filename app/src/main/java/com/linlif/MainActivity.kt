package com.linlif

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.linlif.coroutines.CoroutineDemo
import com.linlif.coroutines.coroutineScopeDemo
import com.linlif.kotlindemo.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class MainActivity : AppCompatActivity() {

    lateinit var mBtn1: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //顶层函数
//        val dp = 2f.dp(this)
//
//        GlobalScope.launch { }//不推荐使用，生命周期不好控制

        mBtn1 = btn1
        mBtn1.setOnClickListener {
//            CoroutineDemo.launchMain()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.btn2).setOnClickListener(View.OnClickListener {
            CoroutineDemo.launchIO()
        })

        findViewById<View>(R.id.btn3).setOnClickListener(View.OnClickListener {
            CoroutineDemo.launchBlock()
        })

        findViewById<View>(R.id.btn4).setOnClickListener(View.OnClickListener {
            CoroutineDemo.launchTakeTimeChuan()
        })

        findViewById<View>(R.id.btn5).setOnClickListener(View.OnClickListener {
            CoroutineDemo.launchTakeTimeWithLaunch()
        })

        findViewById<View>(R.id.btn6).setOnClickListener(View.OnClickListener {
            CoroutineDemo.launchTakeTimeWithAsync()
        })

        findViewById<View>(R.id.btn7).setOnClickListener(View.OnClickListener {

            coroutineScopeDemo.async(Dispatchers.Main) {

                //内部切换到IO线程
                val result = CoroutineDemo.okHttpRequest()

                Log.e(
                    com.linlif.coroutines.TAG,
                    "${result.code()} 当前线程为：${Thread.currentThread().name}"
                )

            }

            //或者这样写
//            coroutineScopeDemo.async(Dispatchers.Main) {
//
//                //外部切换到IO线程
//                val result = withContext(Dispatchers.IO) {
//                    CoroutineDemo.okHttpRequest()
//                }
//
//                Log.e(
//                    com.linlif.coroutines.TAG,
//                    "${result.code()} 当前线程为：${Thread.currentThread().name}"
//                )
//
//            }


            Log.e(
                com.linlif.coroutines.TAG,
                "okhttp click request"
            )

        })

    }


}
