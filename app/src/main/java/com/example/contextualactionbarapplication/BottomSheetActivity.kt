package com.example.contextualactionbarapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog



class BottomSheetActivity : AppCompatActivity() {


    lateinit var btnShowBottomSheet: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)
        val dialog = BottomSheetDialog(this)


        btnShowBottomSheet = findViewById(R.id.idBtnShowBottomSheet);


        btnShowBottomSheet.setOnClickListener {

            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
            val btnClose = view.findViewById<TextView>(R.id.txt_Drawing)
            btnClose.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }
    }
}
