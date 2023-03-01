package com.example.contextualactionbarapplication.ViewPager



import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.contextualactionbarapplication.R


class ImageAdpter internal constructor(private val mContext: Context) : PagerAdapter() {
    private val mImageIds = intArrayOf(R.drawable.cat_1,
        R.drawable.img_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_5,
        R.drawable.cat_6,
        R.drawable.cat_7,
        R.drawable.cat_8,
        R.drawable.cat_9,
        R.drawable.cat_10,
        R.drawable.cat_11,
        R.drawable.cat_12,
        R.drawable.cat_13,
        R.drawable.cat_14,
        R.drawable.cat_15)

    override fun getCount(): Int {
        return mImageIds.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(mContext)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        imageView.setImageResource(mImageIds[position])
        container.addView(imageView, 0)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }
}