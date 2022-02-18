package com.liangguo.easyingorientationdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.liangguo.easyingorientation.listenOnOrientationChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listenOnOrientationChanged {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}