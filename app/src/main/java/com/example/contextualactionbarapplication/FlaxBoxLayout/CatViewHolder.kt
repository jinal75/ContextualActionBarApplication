package com.example.contextualactionbarapplication.FlaxBoxLayout



import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.contextualactionbarapplication.R
import com.google.android.flexbox.FlexboxLayoutManager



class CatViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val mImageView: ImageView = itemView.findViewById<View>(R.id.imageview) as ImageView
    fun bindTo(drawable: Drawable?) {
        mImageView.setImageDrawable(drawable)
        val lp = mImageView.layoutParams

        if (lp is FlexboxLayoutManager.LayoutParams) {
            val flexboxLp: FlexboxLayoutManager.LayoutParams =
                lp as FlexboxLayoutManager.LayoutParams
            flexboxLp.flexGrow = 1.0f
        }
    }

}