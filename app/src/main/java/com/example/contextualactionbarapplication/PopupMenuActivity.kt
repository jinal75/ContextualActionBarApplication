package com.example.contextualactionbarapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class PopupMenuActivity : AppCompatActivity() {
    lateinit var pop:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_menu)
        pop=findViewById(R.id.txt_Menu)
        pop.setOnClickListener {
            val popMenu=PopupMenu(this,pop)
            popMenu.menuInflater.inflate(R.menu.popup_menu,popMenu.menu)
            popMenu.setOnMenuItemClickListener { item ->
                when (item!!.itemId) {
                    R.id.grabimagetext ->
                        Toast.makeText(this@PopupMenuActivity,
                            "Grab image text",
                            Toast.LENGTH_SHORT).show()

                    R.id.copy ->
                        Toast.makeText(this@PopupMenuActivity, "Copy text", Toast.LENGTH_SHORT)
                            .show()

                    R.id.Send ->
                        Toast.makeText(this@PopupMenuActivity, "Send image", Toast.LENGTH_SHORT)
                            .show()

                    R.id.Delete ->
                        Toast.makeText(this@PopupMenuActivity, "Delete image", Toast.LENGTH_SHORT)
                            .show()


                }
                true
            }
            popMenu.show()
        }

    }

}