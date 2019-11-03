package com.m.viewpager2examples

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var previousPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val colors = mutableListOf<Int>()
        colors.add(android.R.color.holo_green_dark)
        colors.add(android.R.color.holo_red_light)
        colors.add(android.R.color.holo_blue_dark)
        colors.add(android.R.color.holo_purple)

        val viewPagerAdapter = ViewPagerAdapter()
        viewPagerAdapter.setColor(colors)
        // view_pager2.orientation = ViewPager2.ORIENTATION_VERTICAL // swipe from bottom to top or vice verses
        view_pager2.adapter = viewPagerAdapter

        TabLayoutMediator(dots_layout, view_pager2) { _, _ ->
        }.attach()

//        view_pager2.setPageTransformer(CompositePageTransformer().also {
//            it.addTransformer(ViewPagerPageTransformation())
//        })
        with(view_pager2) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)

        view_pager2.setPageTransformer(CompositePageTransformer().also {
            it.addTransformer(
                ViewPagerPageTransformationMultiPagesInScreen(
                    pageMarginPx,
                    offsetPx
                )
            )
        })
    }
}
//onPageSelected: This method will be invoked when a new page becomes selected
//onPageScrollStateChange: Called when the scroll state changes
//onPageScrolled: This method will be invoked when the current page is scrolled