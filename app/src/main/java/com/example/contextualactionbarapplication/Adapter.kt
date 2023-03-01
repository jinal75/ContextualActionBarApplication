package com.example.contextualactionbarapplication



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// The adapter class which
// extends RecyclerView Adapter
class Adapter     // Constructor for adapter class
// which takes a list of String type
    (
    // List with String type
    private val list: List<String>,
) :
    RecyclerView.Adapter<Adapter.MyView>() {
    // View Holder class which
    // extends RecyclerView.ViewHolder
    inner class MyView(view: View) : RecyclerView.ViewHolder(view) {
        // Text View
        var textView: TextView

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        init {

            // initialise TextView with id
            textView = view
                .findViewById<View>(R.id.textview) as TextView
        }
    }

    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyView {

        // Inflate item.xml using LayoutInflator
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item,
                parent,
                false)

        // return itemView
        return MyView(itemView)
    }

    // Override onBindViewHolder which deals
    // with the setting of different data
    // and methods related to clicks on
    // particular items of the RecyclerView.
    override fun onBindViewHolder(
        holder: MyView,
        position: Int,
    ) {

        // Set the text of each item of
        // Recycler view with the list items
        holder.textView.text = list[position]
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    override fun getItemCount(): Int {
        return list.size
    }
}
