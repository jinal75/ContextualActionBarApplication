package com.example.contextualactionbarapplication



import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class AlertDialogBoxActivity : AppCompatActivity() {
    var openDialog: Button? = null
    var infoTv: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog_box)
        openDialog = findViewById(R.id.open_dialog)
        infoTv = findViewById(R.id.info_tv)
        openDialog!!.setOnClickListener { showCustomDialog()
        }
    }

    //Function to display the custom dialog.
    fun showCustomDialog() {
        val dialog = Dialog(this)
        //We have added a title in the custom layout. So let's disable the default title.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //The user will be able to cancel the dialog bu clicking anywhere outside the dialog.
        dialog.setCancelable(true)
        //Mention the name of the layout of your custom dialog.
        dialog.setContentView(R.layout.custom_dialog)

        //Initializing the views of the dialog.
        val nameEt = dialog.findViewById<TextView>(R.id.txtgallary)
        nameEt.setOnClickListener {
            Toast.makeText(this, "gallary", Toast.LENGTH_SHORT).show()
          return@setOnClickListener

        }
        dialog.dismiss()

        val ageEt = dialog.findViewById<TextView>(R.id.txttake)
        ageEt.setOnClickListener {
            Toast.makeText(this, "take pic", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
        dialog.dismiss()

        dialog.show()
    }

    fun populateInfoTv(name: String?, age: String?, hasAcceptedTerms: Boolean?) {
        infoTv!!.visibility = View.VISIBLE
        var acceptedText = "have"
        if (!hasAcceptedTerms!!) {
            acceptedText = "have not"
        }
        infoTv!!.text = String.format(getString(R.string.d_desc), name, age, acceptedText)
    }
}