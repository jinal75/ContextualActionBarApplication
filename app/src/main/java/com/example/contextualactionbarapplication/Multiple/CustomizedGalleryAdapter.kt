package com.example.contextualactionbarapplication.Multiple

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView


class CustomizedGalleryAdapter(private val context: Context, private val images: IntArray) :
    BaseAdapter() {
    // returns the number of images, in our example it is 10
    override fun getCount(): Int {
        return images.size
    }

    // returns the Item of an item, i.e. for our example we can get the image
    override fun getItem(position: Int): Any {
        return position
    }

    // returns the ID of an item
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val imageView = ImageView(context)

        // set image in ImageView
        imageView.setImageResource(images[p0])

        // set ImageView param
        imageView.layoutParams = Gallery.LayoutParams(200, 200)
        return imageView
    }

    // returns an ImageView view
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view = super.getDropDownView(position, convertView, parent)
        val imageView = ImageView(context)
        imageView.setImageResource(images[position])

        // set ImageView param
        imageView.layoutParams = Gallery.LayoutParams(200, 200)
        return imageView
       // view?.let {view.find<TextView>(android.R.id.text1).text = getItem(position).name }
       // return view
    }
//    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
//
//        // position argument will indicate the location of image
//        // create a ImageView programmatically
//        val imageView = ImageView(context)
//
//        // set image in ImageView
//        imageView.setImageResource(images[position])
//
//        // set ImageView param
//        imageView.layoutParams = Gallery.LayoutParams(200, 200)
//        return imageView
//    }
}
