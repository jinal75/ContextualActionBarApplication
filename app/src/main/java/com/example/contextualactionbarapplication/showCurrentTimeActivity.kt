package com.example.contextualactionbarapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class showCurrentTimeActivity : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_current_time)

        var dateTime: String
        var calendar: Calendar
        var simpleDateFormat: SimpleDateFormat

        // register all the text view with appropriate IDs
        val dateTimeInLongTextView: TextView = findViewById(R.id.dateTimeLongValue)
        val format1: TextView = findViewById(R.id.format1)
        val format2: TextView = findViewById(R.id.format2)
        val format3: TextView = findViewById(R.id.format3)
        val format4: TextView = findViewById(R.id.format4)
        val format5: TextView = findViewById(R.id.format5)
        val format6: TextView = findViewById(R.id.format6)
        val format7: TextView = findViewById(R.id.format7)

        // get the Long type value of the current system date
        val dateValueInLong: Long = System.currentTimeMillis()
        dateTimeInLongTextView.text = dateValueInLong.toString()

        // different format type to format the
        // current date and time of the system
        // format type 1
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm:ss aaa z")
        dateTime = simpleDateFormat.format(calendar.time).toString()
        format1.text = dateTime

        // format type 2
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss aaa z")
        dateTime = simpleDateFormat.format(calendar.time).toString()
        format2.text = dateTime

        // format type 3
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss aaa z")
        dateTime = simpleDateFormat.format(calendar.time).toString()
        format3.text = dateTime

        // format type 4
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd.LLL.yyyy HH:mm:ss aaa z")
        dateTime = simpleDateFormat.format(calendar.time).toString()
        format4.text = dateTime

        // format type 5
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd.LLLL.yyyy HH:mm:ss aaa z")
        dateTime = simpleDateFormat.format(calendar.time).toString()
        format5.text = dateTime

        // format type 6
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("E.LLLL.yyyy HH:mm:ss aaa z")
        dateTime = simpleDateFormat.format(calendar.time).toString()
        format6.text = dateTime

        // format type 7
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("EEEE.LLLL.yyyy KK:mm:ss aaa z")
        dateTime = simpleDateFormat.format(calendar.time).toString()
        format7.text = dateTime
    }
}
