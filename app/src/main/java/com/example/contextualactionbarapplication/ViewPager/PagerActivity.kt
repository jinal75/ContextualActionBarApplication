package com.example.contextualactionbarapplication.ViewPager


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.contextualactionbarapplication.R


class PagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val adapter = ImageAdpter(this)
        viewPager.adapter = adapter
    }
}