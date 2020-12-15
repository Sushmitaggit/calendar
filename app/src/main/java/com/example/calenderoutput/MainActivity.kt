package com.example.calenderoutput

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var etDate : EditText
    private lateinit var etDOB : EditText

    private lateinit var tvOut : TextView

    private lateinit var tvYear : TextView
    private lateinit var tvAge : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etDate = findViewById(R.id.etDate)
        etDOB = findViewById(R.id.etDOB)

        tvOut = findViewById(R.id.tvOut)

        tvYear = findViewById(R.id.tvYear)
        tvAge = findViewById(R.id.tvAge)

        etDate.setOnClickListener(){
            loadCalendar()
        }

        etDOB.setOnClickListener(){
            loadCalender()
        }
    }

    private fun loadCalendar(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val date = DatePickerDialog( this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    etDate.setText("  $year-${monthOfYear + 1}-$dayOfMonth")

                    val dateJoined = LocalDateTime.of(year,monthOfYear+1,dayOfMonth,0,0)
                    val current =  LocalDateTime.now()
                    val diff = ChronoUnit.DAYS.between(dateJoined,current).toInt()

                    var y = diff / 365
                    val d = diff - 365 * y
                    var m = d/30

                    if(y == 0) { tvYear.text = " No. of years worked : $m month "  }
                    else if(m == 0) { tvYear.text = " No. of years worked :  $y year "  }
                    else { tvYear.text = " No. of years worked : $y year $m month "}
                },
        year,
        month,
        day)
        date.show()

    }

    private fun loadCalender(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val date = DatePickerDialog( this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    etDOB.setText("  $year-${monthOfYear + 1}-$dayOfMonth")

                    val dob = LocalDateTime.of(year,monthOfYear+1,dayOfMonth,0,0)
                    val current =  LocalDateTime.now()
                    val diff = ChronoUnit.DAYS.between(dob,current).toInt()

                    var y = diff / 365
                    val d = diff - 365 * y
                    var m = d/30

                    if(y == 0) { tvAge.text = " Your Age is : $m month "  }
                    else if(m == 0) { tvAge.text = " Your Age is :  $y year "  }
                    else { tvAge.text = " Your Age is : $y year $m month "}
                },
                year,
                month,
                day)
        date.show()
    }
}








//                    etDate.setText("Enter date of joining : $dayOfMonth-${ monthOfYear+1}- $year")
//                    etDOB.setText("Enter date of joining : $dayOfMonth-${ monthOfYear+1}- $year")