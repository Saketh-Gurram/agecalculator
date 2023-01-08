package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate:TextView? = null
    private var tvageinminutes : TextView? = null
    private var tvageinhours : TextView? = null
    private var tvageindays : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePicker : Button = findViewById(R.id.datepicker)
        tvSelectedDate = findViewById(R.id.tvSelctedDate)
        tvageinminutes = findViewById(R.id.tvageinminutes)
        tvageinhours = findViewById(R.id.tvageinhours)
        tvageindays = findViewById(R.id.tvageindays)
        datePicker.setOnClickListener {
            datepicker()
        }

    }
    private fun datepicker(){
        val myCalender = Calendar.getInstance()
        val Year =myCalender.get(Calendar.YEAR)
        val Month =myCalender.get(Calendar.MONTH)
        val Day =myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd=DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, selectedyear, selectedmonth, selectedDayOfMonth ->
            Toast.makeText(this,"date btn has been clicked " , Toast.LENGTH_LONG).show()
                             val selecteddate="$selectedDayOfMonth/${selectedmonth+1}/$selectedyear"
            tvSelectedDate?.setText(selecteddate)
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val date = sdf.parse(selecteddate)
            date?.let { val dateinmin=date.time/60000
                val currentdate=sdf.parse(sdf.format(System.currentTimeMillis()))
                currentdate?.let { val currentdateinmin = currentdate.time/60000
                    val diffinmin = currentdateinmin - dateinmin
                    val timeinhours = diffinmin/60
                    val timeindays = timeinhours/24
                    tvageindays?.text = timeindays.toString()
                    tvageinhours?.text = timeinhours.toString()
                    tvageinminutes?.text = diffinmin.toString() } }
                                                                 },
            Year,
            Month,
            Day

        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }
}