package com.template.viewpagerresumesample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

internal class Adapter(
    fragmentManager: FragmentManager,
    behavior: Int
) : FragmentStatePagerAdapter(fragmentManager, behavior) {

    override fun getItem(position: Int): Fragment = PageFragment.newInstance(position)

    override fun getCount(): Int = 6
}