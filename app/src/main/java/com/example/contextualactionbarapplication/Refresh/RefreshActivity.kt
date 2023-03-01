package com.example.contextualactionbarapplication.Refresh

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.contextualactionbarapplication.R
import java.util.*


class RefreshActivity : AppCompatActivity() {
    var swipeRefreshLayout: SwipeRefreshLayout? = null
    var recyclerView: RecyclerView? = null

    // Using ArrayList to store images and text data
    var images: ArrayList<*> = ArrayList(Arrays.asList<Any>(R.drawable.cat_1, R.drawable.cat_10,
        R.drawable.image1, R.drawable.image2, R.drawable.image2, R.drawable.img))
    var
            text: ArrayList<*> = ArrayList(Arrays.asList("Facebook",
        "Twitter",
        "Instagram",
        "LinkedIn",
        "Youtube",
        "Whatsapp"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refresh)

        // Getting reference of swipeRefreshLayout and recyclerView
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout) as SwipeRefreshLayout
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        // Setting the layout as Linear for vertical orientation to have swipe behavior
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = linearLayoutManager

        // Sending reference and data to Adapter
        val adapter = Adapter(this, images, text)

        // Setting Adapter to RecyclerView
        recyclerView!!.adapter = adapter


        // SetOnRefreshListener on SwipeRefreshLayout
        swipeRefreshLayout!!.setOnRefreshListener {
            swipeRefreshLayout!!.isRefreshing = false
            RearrangeItems()
        }
    }

    fun RearrangeItems() {
        // Shuffling the data of ArrayList using system time
        Collections.shuffle(images, Random(System.currentTimeMillis()))
        Collections.shuffle(text, Random(System.currentTimeMillis()))
        val adapter = Adapter(this, images, text)
        recyclerView!!.adapter = adapter
    }
}
