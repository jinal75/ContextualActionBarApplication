package com.example.contextualactionbarapplication.changelayout


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.contextualactionbarapplication.R


class ItemAdapter(private val mItems: List<Item>, private val mLayoutManager: StaggeredGridLayoutManager) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        val spanCount = mLayoutManager.spanCount
        return if (spanCount == SPAN_COUNT_ONE) {
            VIEW_TYPE_BIG
        } else {
            VIEW_TYPE_SMALL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View
        if (viewType == VIEW_TYPE_BIG) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_big, parent, false)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_small, parent, false)
        }
        return ItemViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = mItems[position % 2]
        holder.title!!.text = item.title
        holder.iv!!.setImageResource(item.imgResId)
        if (getItemViewType(position) == VIEW_TYPE_BIG) {
            holder.info!!.text = item.likes.toString() + " likes  ·  " + item.comments + " comments"
        }
    }

    override fun getItemCount(): Int {
        return 30
    }

    inner class ItemViewHolder(itemView: View, viewType: Int) :
        RecyclerView.ViewHolder(itemView) {
        var iv: ImageView? = null
        var title: TextView? = null
        var info: TextView? = null

        init {
            if (viewType == VIEW_TYPE_BIG) {
                iv = itemView.findViewById<View>(R.id.image_big) as ImageView
                title = itemView.findViewById<View>(R.id.title_big) as TextView
                info = itemView.findViewById<View>(R.id.tv_info) as TextView
            } else {
                iv = itemView.findViewById<View>(R.id.image_small) as ImageView
                title = itemView.findViewById<View>(R.id.title_small) as TextView
            }
        }
    }

    companion object {
        const val SPAN_COUNT_ONE = 1
        const val SPAN_COUNT_TWO = 2

        const val SPAN_COUNT_THREE = 3
        private const val VIEW_TYPE_SMALL = 1
        private const val VIEW_TYPE_BIG = 2
    }
}