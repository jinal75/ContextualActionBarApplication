package com.example.contextualactionbarapplication.Multiple

import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.Gallery
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.contextualactionbarapplication.R


class MultiPhotoSelectActivity : AppCompatActivity() {
    var simpleGallery: Gallery? = null

    // CustomizedGalleryAdapter is a java class which extends BaseAdapter
    // and implement the override methods.
    var customGalleryAdapter: CustomizedGalleryAdapter? = null
    var selectedImageView: ImageView? = null

    // To show the selected language, we need this
    // array of images, here taken 10 different kind of most popular programming languages
    var images = intArrayOf(R.drawable.cat_6,
        R.drawable.cat_2,
        R.drawable.cat_10,
        R.drawable.cat_14,
        R.drawable.cat_16,
        R.drawable.cat_4,
        R.drawable.cat_19,
        R.drawable.cat_3,
        R.drawable.cat_17,
        R.drawable.cat_7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_photo_select)

        // Our layout is activity_main
        // get the reference of Gallery. As we are showing languages it is named as languagesGallery
        // meaningful names will be good for easier understanding
        simpleGallery = findViewById<View>(R.id.languagesGallery) as Gallery

        // get the reference of ImageView
        selectedImageView = findViewById<View>(R.id.imageView) as ImageView

        // initialize the adapter
        customGalleryAdapter = CustomizedGalleryAdapter(applicationContext, images)

        // set the adapter for gallery
        simpleGallery!!.adapter = customGalleryAdapter

        // Let us do item click of gallery and image can be identified by its position
        simpleGallery!!.onItemClickListener =
            OnItemClickListener { parent, view, position, id -> // Whichever image is clicked, that is set in the selectedImageView
                // position will indicate the location of image
                selectedImageView!!.setImageResource(images[position])
            }
    }
}
