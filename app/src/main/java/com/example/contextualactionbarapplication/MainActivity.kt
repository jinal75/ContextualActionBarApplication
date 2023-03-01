package com.example.contextualactionbarapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.OnLongClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode


class MainActivity : AppCompatActivity() {
    private var myActMode: ActionMode? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.text_view)
        textView.setOnLongClickListener(OnLongClickListener {
            if (myActMode != null) {
                return@OnLongClickListener false
            }
            myActMode = startSupportActionMode(myActModeCallback)
            true
        })
    }

    private val myActModeCallback: ActionMode.Callback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            mode.menuInflater.inflate(R.menu.example_menu, menu)
            mode.title = "Select option here"
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.option_1 -> {
                    Toast.makeText(this@MainActivity, "Selected Option 1", Toast.LENGTH_SHORT)
                        .show()
                    mode.finish()
                    true
                }
                R.id.option_2 -> {
                    Toast.makeText(this@MainActivity, "Selected Option 2", Toast.LENGTH_SHORT)
                        .show()
                    mode.finish()
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            myActMode = null
        }
    }
}
