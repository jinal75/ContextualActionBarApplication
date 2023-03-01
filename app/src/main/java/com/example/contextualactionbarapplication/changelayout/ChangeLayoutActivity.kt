package com.example.contextualactionbarapplication.changelayout


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.contextualactionbarapplication.R
import com.example.contextualactionbarapplication.changelayout.ItemAdapter.Companion.SPAN_COUNT_ONE
import com.example.contextualactionbarapplication.changelayout.ItemAdapter.Companion.SPAN_COUNT_TWO
import java.util.*


class ChangeLayoutActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var itemAdapter: ItemAdapter? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var stag:StaggeredGridLayoutManager?=null
    private var items: MutableList<Item>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_layout)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        initItemsData()
        stag= StaggeredGridLayoutManager(2, SPAN_COUNT_ONE)
      //  gridLayoutManager = GridLayoutManager(this, SPAN_COUNT_ONE)
        itemAdapter = ItemAdapter(items!!,stag!!)
        recyclerView = findViewById<View>(R.id.rv) as RecyclerView
        recyclerView!!.adapter = itemAdapter
        recyclerView!!.layoutManager = stag
    }

    private fun initItemsData() {
        items = ArrayList(4)
        items!!.add(Item(R.drawable.img, "Image 1", 20, 33))
        items!!.add(Item(R.drawable.one, "Image 2", 10, 54))
        items!!.add(Item(R.drawable.img_2, "Image 3", 27, 20))
        items!!.add(Item(R.drawable.two, "Image 4", 45, 67))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.meun_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_switch_layout) {
            switchLayout()
            switchIcon(item)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun switchLayout() {
        if (stag!!.spanCount == SPAN_COUNT_ONE) {
            stag!!.spanCount = SPAN_COUNT_TWO
        } else {
            stag!!.spanCount = SPAN_COUNT_ONE
        }
        itemAdapter!!.notifyItemRangeChanged(0, itemAdapter!!.itemCount)
    }

    private fun switchIcon(item: MenuItem) {
        if (stag!!.spanCount == SPAN_COUNT_TWO) {
            item.icon = resources.getDrawable(R.drawable.ic_span_3)
        } else {
            item.icon = resources.getDrawable(R.drawable.ic_span_1)
        }
    }
}