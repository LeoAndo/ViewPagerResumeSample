package com.template.viewpagerresumesample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment : Fragment(R.layout.fragment_page) {

    private val page by lazy(LazyThreadSafetyMode.NONE) {
        requireArguments().getInt(PAGE)
    }

    override fun onResume() {
        super.onResume()
        val text =
            "No.$page fragment is resumed. userVisibleHint: $userVisibleHint isResumed: $isResumed"
        outPutLog(text)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        val text =
            "No.$page fragment is called setUserVisibleHint. userVisibleHint: $userVisibleHint isResumed: $isResumed isVisibleToUser: $isVisibleToUser"
        outPutLog(text)
    }

    override fun onPause() {
        super.onPause()
        val text =
            "No.$page fragment is paused. userVisibleHint: $userVisibleHint isResumed: $isResumed"
        outPutLog(text)
    }

    /**
     * androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT 使用時のログ
     * W/PageFragment: No.0 fragment is resumed. userVisibleHint: true isResumed: true ★1ページ目表示時
     * W/PageFragment: No.0 fragment is paused. userVisibleHint: true isResumed: false ★2ページ目表示時
     * W/PageFragment: No.1 fragment is resumed. userVisibleHint: true isResumed: true ★2ページ目表示時
     * W/PageFragment: No.1 fragment is paused. userVisibleHint: true isResumed: false ★3ページ目表示時
     * W/PageFragment: No.2 fragment is resumed. userVisibleHint: true isResumed: true ★3ページ目表示時
     *
     * androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT 使用時のログ
     * W/PageFragment: No.0 fragment is called setUserVisibleHint. userVisibleHint: false isResumed: false isVisibleToUser: false ★1ページ目表示時
     * W/PageFragment: No.1 fragment is called setUserVisibleHint. userVisibleHint: false isResumed: false isVisibleToUser: false ★1ページ目表示時
     * W/PageFragment: No.0 fragment is called setUserVisibleHint. userVisibleHint: true isResumed: false isVisibleToUser: true ★1ページ目表示時
     * W/PageFragment: No.0 fragment is resumed. userVisibleHint: true isResumed: true ★1ページ目表示時
     * W/PageFragment: No.1 fragment is resumed. userVisibleHint: false isResumed: true ★1ページ目表示時
     * W/PageFragment: No.2 fragment is called setUserVisibleHint. userVisibleHint: false isResumed: false isVisibleToUser: false ★2ページ目表示時
     * W/PageFragment: No.0 fragment is called setUserVisibleHint. userVisibleHint: false isResumed: true isVisibleToUser: false ★2ページ目表示時
     * W/PageFragment: No.1 fragment is called setUserVisibleHint. userVisibleHint: true isResumed: true isVisibleToUser: true ★2ページ目表示時
     * W/PageFragment: No.2 fragment is resumed. userVisibleHint: false isResumed: true ★2ページ目表示時
     * W/PageFragment: No.3 fragment is called setUserVisibleHint. userVisibleHint: false isResumed: false isVisibleToUser: false ★3ページ目表示時
     * W/PageFragment: No.1 fragment is called setUserVisibleHint. userVisibleHint: false isResumed: true isVisibleToUser: false ★3ページ目表示時
     * W/PageFragment: No.2 fragment is called setUserVisibleHint. userVisibleHint: true isResumed: true isVisibleToUser: true ★3ページ目表示時
     * W/PageFragment: No.0 fragment is paused. userVisibleHint: false isResumed: false ★3ページ目表示時
     * W/PageFragment: No.3 fragment is resumed. userVisibleHint: false isResumed: true ★3ページ目表示時
     */
    private fun outPutLog(text: String) {
        if (context != null) Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
        Log.w("PageFragment", text)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        page_no_text.text = page.toString()
    }

    companion object {
        private const val PAGE = "page"

        fun newInstance(page: Int): PageFragment = PageFragment()
            .apply {
                arguments = bundleOf(PAGE to page)
            }
    }
}