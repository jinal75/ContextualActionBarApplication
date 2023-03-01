package com.example.contextualactionbarapplication.ViewPagerRecycler

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.contextualactionbarapplication.R


class ViewPagerRewcyclerActivity : AppCompatActivity() {
    var viewPager2: ViewPager2? = null
    var viewPagerItemArrayList: ArrayList<ViewPagerItem>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_rewcycler)
        viewPager2 = findViewById(R.id.viewpager)
        val images =
            intArrayOf(R.drawable.cat_14, R.drawable.cat_5, R.drawable.cat_10, R.drawable.cat_15, R.drawable.cat_6)
        val heading = arrayOf("Baked", "Grilled", "Dessert", "Italian", "Shakes")
        val desc = arrayOf(getString(R.string.a_desc),
            getString(R.string.b_desc),
            getString(R.string.c_desc),
            getString(R.string.d_desc), getString(R.string.e_desc))
        viewPagerItemArrayList = ArrayList()
        for (i in images.indices) {
            val viewPagerItem = ViewPagerItem(images[i], heading[i], desc[i])
            viewPagerItemArrayList!!.add(viewPagerItem)
        }
        val vpAdapter = RecyclerAdapter(viewPagerItemArrayList!!)
        viewPager2!!.setAdapter(vpAdapter)
        viewPager2!!.setClipToPadding(false)
        viewPager2!!.setClipChildren(false)
        viewPager2!!.setOffscreenPageLimit(2)
        viewPager2!!.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
    }
}