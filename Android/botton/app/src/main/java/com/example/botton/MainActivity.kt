package com.example.botton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate : called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById<EditText>(R.id.editText)
        val button: Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView) //通过ID绑定
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod() //当textview满了以后可以滚动查看

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick : called")
                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.text.clear() //清空输入框的内容
                // userInput.setText("") //清空输入框的内容，如果输入框有提示的话可以用这个清理掉
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart : called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState : called")
        super.onRestoreInstanceState(savedInstanceState)
        val savedString = savedInstanceState?.getString(TEXT_CONTENTS, "") //旋转手机后 可以通过读取TEXT—CONTENT重现数据
        textView?.text = savedString
        //textView?.text = savedInstanceState?.getString(TEXT_CONTENTS, "") 这个更加简洁
    }

    override fun onResume() {
        Log.d(TAG, "onResume : called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause : called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState : called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString()) //保存数据到TEXT—CONTENT
    }

    override fun onStop() {
        Log.d(TAG, "onStop : called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart : called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy : called")
        super.onDestroy()
    }
}