package com.template.viewpagerresumesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_1.setOnClickListener {
            PageResumeActivity.newIntent(this)
        }
        button_2.setOnClickListener {
            PageUserHintActivity.newIntent(this)
        }

    }
}
