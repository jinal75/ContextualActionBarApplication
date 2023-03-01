package com.example.contextualactionbarapplication



import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HorizontalScrollviewActivity: AppCompatActivity() {
    // Recycler View object
    var recyclerView: RecyclerView? = null

    // Array list for recycler view data source
    var source: ArrayList<String>? = null

    // Layout Manager
    var RecyclerViewLayoutManager: RecyclerView.LayoutManager? = null

    // adapter class object
    var adapter: Adapter? = null

    // Linear Layout Manager
    var HorizontalLayout: LinearLayoutManager? = null
    var ChildView: View? = null
    var RecyclerViewItemPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_scrollview)

        // initialisation with id's
        recyclerView = findViewById<View>(
            R.id.hrecycler) as RecyclerView
        RecyclerViewLayoutManager = LinearLayoutManager(
            applicationContext)

        // Set LayoutManager on Recycler View
        recyclerView!!.layoutManager = RecyclerViewLayoutManager

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList()

        // calling constructor of adapter
        // with source list as a parameter
        adapter = Adapter(source!!)

        // Set Horizontal Layout Manager
        // for Recycler view
        HorizontalLayout = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)
        recyclerView!!.layoutManager = HorizontalLayout

        // Set adapter on recycler view
        recyclerView!!.adapter = adapter
    }

    // Function to add items in RecyclerView.
    fun AddItemsToRecyclerViewArrayList() {
        // Adding items to ArrayList
        source = ArrayList()
        source!!.add(R.drawable.ic_baseline_delete_24.toString())
        source!!.add(R.layout.bottom_sheet_dialog.toString())
        source!!.add("best")
        source!!.add("site")
        source!!.add("for")
        source!!.add("interview")
        source!!.add("preparation")
    }
}
