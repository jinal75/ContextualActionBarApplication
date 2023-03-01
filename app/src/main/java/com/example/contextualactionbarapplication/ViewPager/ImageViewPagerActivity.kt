package com.example.contextualactionbarapplication.ViewPager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.contextualactionbarapplication.R


class ImageViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view_pager)
        val images: MutableList<Int> = ArrayList()
        images.add(R.drawable.image1)
        images.add(R.drawable.image2)
        images.add(R.drawable.image3)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this, images)
    }

    protected inner class ViewPagerAdapter internal constructor(
        private val context: Context,
        private val imageList: List<Int>,
    ) :
        PagerAdapter() {
        override fun getCount(): Int {
            return imageList.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val inflater = LayoutInflater.from(context)
            val layout = inflater.inflate(R.layout.item_view_pager, container,
                false) as ViewGroup
            val imageView = layout.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(imageList[position])
            container.addView(layout)
            return layout
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }
    }
}
