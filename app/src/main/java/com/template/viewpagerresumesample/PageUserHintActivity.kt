package com.template.viewpagerresumesample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_pager.*

class PageUserHintActivity : AppCompatActivity(R.layout.activity_pager) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view_pager.adapter = Adapter(
            supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT
        )
    }

    companion object {
        fun newIntent(context: Context) {
            context.startActivity(Intent(context, PageUserHintActivity::class.java))
        }
    }
}