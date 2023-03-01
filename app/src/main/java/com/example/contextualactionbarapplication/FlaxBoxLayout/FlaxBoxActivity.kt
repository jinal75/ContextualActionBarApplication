package com.example.contextualactionbarapplication.FlaxBoxLayout


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.contextualactionbarapplication.R
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager


class FlaxBoxActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var adapter: CatAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flax_box)
      //  val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        // setSupportActionBar(toolbar);
         recyclerView = findViewById(R.id.recyclerview)
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexWrap = FlexWrap.WRAP
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.alignItems = AlignItems.STRETCH
        recyclerView.layoutManager = layoutManager
        val adapter: CatAdapter = CatAdapter(this)
        recyclerView.adapter = adapter


    }
}