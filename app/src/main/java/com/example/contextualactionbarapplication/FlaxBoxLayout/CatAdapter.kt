package com.example.contextualactionbarapplication.FlaxBoxLayout



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.contextualactionbarapplication.R



class CatAdapter internal constructor(private val mContext: Context) :
    RecyclerView.Adapter<CatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val pos = position % CAT_IMAGE_IDS.size
        val drawable = ResourcesCompat.getDrawable(mContext.resources,
            CAT_IMAGE_IDS[pos], null)
        holder.bindTo(drawable)
    }

    override fun getItemCount(): Int {
        return CAT_IMAGE_IDS.size
    }

    companion object {
        private val CAT_IMAGE_IDS = intArrayOf(
            R.drawable.eight, R.drawable.one, R.drawable.two, R.drawable.image1, R.drawable.three,
            R.drawable.eight, R.drawable.image2, R.drawable.cat_2, R.drawable.cat_3, R.drawable.cat_4,
            R.drawable.img, R.drawable.image3, R.drawable.img_3, R.drawable.eight, R.drawable.img_2,
            R.drawable.cat_7, R.drawable.cat_8, R.drawable.cat_9, R.drawable.cat_10, R.drawable.cat_11,
            R.drawable.image2, R.drawable.six, R.drawable.eight, R.drawable.seven, R.drawable.img_1,
            R.drawable.six, R.drawable.seven, R.drawable.cat_1, R.drawable.cat_5, R.drawable.cat_6,
            R.drawable.cat_12, R.drawable.cat_13, R.drawable.cat_14, R.drawable.cat_15, R.drawable.cat_16,
            R.drawable.cat_17, R.drawable.cat_18, R.drawable.cat_19



        )
    }
}