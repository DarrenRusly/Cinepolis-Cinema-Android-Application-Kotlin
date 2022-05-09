package com.uasseluler.cinepolis

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.uasseluler.cinepolis.databinding.ActivitySeatingBinding
import android.widget.Toast
import org.json.JSONException
import org.json.JSONObject
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class SeatingActivity : AppCompatActivity() {
    lateinit var row_view_1: View
    lateinit var row_view_3: View
    lateinit var row_view_2: View
    lateinit var row_view_4: View
    lateinit var row_view_5: View
    var textIdList = arrayOf(
        R.id.column_text_1,
        R.id.column_text_2,
        R.id.column_text_3,
        R.id.column_text_4,
        R.id.column_text_5,
        R.id.column_text_6,
        R.id.column_text_7,
        R.id.column_text_8,
    )
    var textViewCount = 8
    private var col_text_view_array_1: Array<TextView?>? = null
    private var col_text_view_array_2: Array<TextView?>? = null
    private var col_text_view_array_3: Array<TextView?>? = null
    private var col_text_view_array_4: Array<TextView?>? = null
    private var col_text_view_array_5: Array<TextView?>? = null
    private lateinit var binding: ActivitySeatingBinding
    var quantityCount = 0
    var price = 25000
    var rbString = "10:00 am to 12:00 am"
    private lateinit var dateString: String
    private lateinit var loadingDialog: Dialog

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_seating)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val moviename = intent.getStringExtra("movie_name")
        val cinema_name = intent.getStringExtra("cinema_name")
        price = intent.getIntExtra("price", 5000)
        binding.txtPrice.text = "Rp.$price"
        row_view_1 = findViewById(R.id.row_layout_A)
        row_view_2 = findViewById(R.id.row_layout_B)
        row_view_3 = findViewById(R.id.row_layout_C)
        row_view_4 = findViewById(R.id.row_layout_D)
        row_view_4 = findViewById(R.id.row_layout_D)
        row_view_5 = findViewById(R.id.row_layout_E)

        col_text_view_array_1 = arrayOfNulls(textViewCount)
        col_text_view_array_2 = arrayOfNulls(textViewCount)
        col_text_view_array_3 = arrayOfNulls(textViewCount)
        col_text_view_array_4 = arrayOfNulls(textViewCount)
        col_text_view_array_5 = arrayOfNulls(textViewCount)
        for (i in 0 until textViewCount) {
            col_text_view_array_1!![i] = row_view_1.findViewById<View>(textIdList[i]) as TextView
            col_text_view_array_1!![i]!!.setOnClickListener { v ->
                col_text_view_array_1!![i]!!.isSelected = !col_text_view_array_1!![i]!!.isSelected
                quantityCount = if (col_text_view_array_1!![i]!!.isSelected) {
                    quantityCount + 1
                } else {
                    if (quantityCount == 0) {
                        0
                    } else {
                        quantityCount - 1
                    }
                }
                setBackgroundTextView(col_text_view_array_1, i)
                quantityCheck()
            }
            col_text_view_array_2!![i] = row_view_2.findViewById<View>(textIdList[i]) as TextView
            col_text_view_array_2!![i]!!.setOnClickListener { v ->
                col_text_view_array_2!![i]!!.isSelected =
                    !col_text_view_array_2!![i]!!.isSelected
                quantityCount = if (col_text_view_array_2!![i]!!.isSelected) {
                    quantityCount + 1
                } else {
                    if (quantityCount == 0) {
                        0
                    } else {
                        quantityCount - 1
                    }
                }
                setBackgroundTextView(col_text_view_array_2, i)
                quantityCheck()
            }

            col_text_view_array_3!![i] = row_view_3.findViewById<View>(textIdList[i]) as TextView
            col_text_view_array_3!![i]!!.setOnClickListener { v ->
                col_text_view_array_3!![i]!!.isSelected =
                    !col_text_view_array_3!![i]!!.isSelected
                quantityCount = if (col_text_view_array_3!![i]!!.isSelected) {
                    quantityCount + 1
                } else {
                    if (quantityCount == 0) {
                        0
                    } else {
                        quantityCount - 1
                    }
                }
                setBackgroundTextView(col_text_view_array_3, i)
                quantityCheck()
            }

            col_text_view_array_4!![i] = row_view_4.findViewById<View>(textIdList[i]) as TextView
            col_text_view_array_4!![i]!!.setOnClickListener { v ->
                col_text_view_array_4!![i]!!.isSelected =
                    !col_text_view_array_4!![i]!!.isSelected
                quantityCount = if (col_text_view_array_4!![i]!!.isSelected) {
                    quantityCount + 1
                } else {
                    if (quantityCount == 0) {
                        0
                    } else {
                        quantityCount - 1
                    }
                }
                setBackgroundTextView(col_text_view_array_4, i)
                quantityCheck()
            }

            col_text_view_array_5!![i] = row_view_5.findViewById<View>(textIdList[i]) as TextView
            col_text_view_array_5!![i]!!.setOnClickListener { v ->
                col_text_view_array_5!![i]!!.isSelected =
                    !col_text_view_array_5!![i]!!.isSelected
                quantityCount = if (col_text_view_array_5!![i]!!.isSelected) {
                    quantityCount + 1
                } else {
                    if (quantityCount == 0) {
                        0
                    } else {
                        quantityCount - 1
                    }
                }
                setBackgroundTextView(col_text_view_array_5, i)
                quantityCheck()
            }

        }

        val pickDateBtn = findViewById<Button>(R.id.pickDateBtn)


        val calendar = Calendar.getInstance()
        loadingDialog = Dialog(this)
        loadingDialog.setContentView(R.layout.loading_layout)
        loadingDialog.window!!.setLayout(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        loadingDialog.setCancelable(false)
        val day = calendar.get(Calendar.DAY_OF_MONTH);
        val year = calendar.get(Calendar.YEAR);
        val month = calendar.get(Calendar.MONTH);
        var mdate = "" + day.toString()
        var mmonth = "" + month.toString()
        if (day<10){
            mdate = "0" + day.toString()
        }
        if (month<10){
            mmonth = "0" + (month+1)
        }
        dateString = mdate + "/" + mmonth + "/" + year
        pickDateBtn.text = dateString
        var datePicker: DatePickerDialog
        pickDateBtn.setOnClickListener {
            datePicker = DatePickerDialog(
                this,
                { view, year, month, dayOfMonth -> // adding the selected date in the edittext
                    pickDateBtn.setText(dayOfMonth.toString() + "/" + (month + 1) + "/" + year)
                    var mdate = "" + dayOfMonth.toString()
                    var mmonth = "" + month.toString()
                    if (dayOfMonth<10){
                        mdate = "0" + dayOfMonth.toString()
                    }
                    if (month<10){
                        mmonth = "0" + (month+1)
                    }
                    dateString = mdate + "/" + mmonth + "/" + year
                    for (i in 0 until textViewCount) {
                        col_text_view_array_1!![i]!!.isEnabled = true
                        col_text_view_array_2!![i]!!.isEnabled = true
                        col_text_view_array_3!![i]!!.isEnabled = true
                        col_text_view_array_4!![i]!!.isEnabled = true
                        col_text_view_array_5!![i]!!.isEnabled = true

                        col_text_view_array_1!![i]!!.background =
                            ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)
                        col_text_view_array_2!![i]!!.background =
                            ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)
                        col_text_view_array_3!![i]!!.background =
                            ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)
                        col_text_view_array_4!![i]!!.background =
                            ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)
                        col_text_view_array_5!![i]!!.background =
                            ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)
                    }
                    quantityCount = 0
                    binding.txtQuantity.text = "0"
                    binding.txtTotalPrice.text = "Rs.0"
                    check(moviename!!, loadingDialog, dateString, rbString, cinema_name!!)
                }, year, month, day
            )

            // set maximum date to be selected as today

            datePicker.datePicker.minDate = calendar.timeInMillis

            try {
                calendar.add(Calendar.MONTH, 1)
                datePicker.datePicker.maxDate = calendar.timeInMillis
                datePicker.show()
                calendar.add(Calendar.MONTH, -1)
            } catch (e: ParseException) {
                e.printStackTrace()
            }

        }
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        binding.buyBtn.setOnClickListener {

            if (pickDateBtn.text.toString() != "Pick date") {
                if (quantityCount > 0) {
                    onPaymentSuccess("")

                } else {
                    Toast.makeText(this, "Please Select atleast 1 seat", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please Select Date", Toast.LENGTH_LONG).show()
            }
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId -> // checkedId is the RadioButton selected
            val rb = findViewById<View>(checkedId) as RadioButton
            for (i in 0 until textViewCount) {
                col_text_view_array_1!![i]!!.isEnabled = true
                col_text_view_array_2!![i]!!.isEnabled = true
                col_text_view_array_3!![i]!!.isEnabled = true
                col_text_view_array_4!![i]!!.isEnabled = true
                col_text_view_array_5!![i]!!.isEnabled = true

                col_text_view_array_1!![i]!!.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)
                col_text_view_array_2!![i]!!.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)
                col_text_view_array_3!![i]!!.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)
                col_text_view_array_4!![i]!!.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)
                col_text_view_array_5!![i]!!.background =
                    ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)

            }
            rbString = rb.text.toString()
            check(moviename!!, loadingDialog, dateString, rb.text.toString(), cinema_name!!)

        }
        check(moviename!!, loadingDialog, dateString, "10:00 am to 12:00 am", cinema_name!!)

    }

    private fun quantityCheck() {
        binding.txtQuantity.text = quantityCount.toString()
        if (quantityCount > 0) {
            binding.txtTotalPrice.text = "Rp." + (price * quantityCount).toString()
        } else {
            Toast.makeText(this, "Please Select atleast 1 seat", Toast.LENGTH_LONG).show()
        }
    }

    private fun check(
        moviename: String,
        loadingDialog: Dialog,
        dateString: String,
        radioStr: String,
        cinema_name: String
    ) {
        loadingDialog.show()
        val queue = Volley.newRequestQueue(this)
        val url = "http://10.252.240.130:5000/check-seats"
        val options = JSONObject()
        options.put("movieId", intent.getStringExtra("movieId")!!)
        options.put("cinemaName", cinema_name)
        options.put("date", dateString)
        options.put("time", radioStr)
        val request = JsonObjectRequest(Request.Method.POST, url, options, { response ->
            try {
                try {
                    val jsonArray = response.getJSONArray("tickets")

                    for (i in 0 until jsonArray.length()) {
                        val ticket = jsonArray.getJSONArray(i)
                        val seatlist = ticket[11].toString().split(",").map { it.trim() }
                        seatlist.forEach {
                            when {
                                "A" == it[0].toString() -> {
                                    val result: Int = it[1].toString().toInt()
                                    col_text_view_array_1!![result]!!.isEnabled = false
                                    col_text_view_array_1!![result]!!.background =
                                        ResourcesCompat.getDrawable(
                                            resources,
                                            R.drawable.button_default_set_dialog_outline,
                                            null
                                        )
                                }
                                "B" == it[0].toString() -> {
                                    val result: Int = it[1].toString().toInt()
                                    col_text_view_array_2!![result]!!.isEnabled = false
                                    col_text_view_array_2!![result]!!.background =
                                        ResourcesCompat.getDrawable(
                                            resources,
                                            R.drawable.button_default_set_dialog_outline,
                                            null
                                        )
                                }
                                "C" == it[0].toString() -> {
                                    val result: Int = it[1].toString().toInt()
                                    col_text_view_array_3!![result]!!.isEnabled = false
                                    col_text_view_array_3!![result]!!.background =
                                        ResourcesCompat.getDrawable(
                                            resources,
                                            R.drawable.button_default_set_dialog_outline,
                                            null
                                        )
                                }
                                "D" == it[0].toString() -> {
                                    val result: Int = it[1].toString().toInt()
                                    col_text_view_array_4!![result]!!.isEnabled = false
                                    col_text_view_array_4!![result]!!.background =
                                        ResourcesCompat.getDrawable(
                                            resources,
                                            R.drawable.button_default_set_dialog_outline,
                                            null
                                        )
                                }
                                "E" == it[0].toString() -> {
                                    val result: Int = it[1].toString().toInt()
                                    col_text_view_array_5!![result]!!.isEnabled = false
                                    col_text_view_array_5!![result]!!.background =
                                        ResourcesCompat.getDrawable(
                                            resources,
                                            R.drawable.button_default_set_dialog_outline,
                                            null
                                        )
                                }
                            }
                        }
                    }

                    quantityCount = 0
                    binding.txtQuantity.text = "0"
                    binding.txtTotalPrice.text = "Rp.0"
                    loadingDialog.dismiss()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, { error -> error.printStackTrace() })
        queue.add(request)

    }

    private fun textResult(
        rowName: String,
        col_text_view_array: Array<TextView?>
    ): java.lang.StringBuilder {
        val row_result = StringBuilder()
        for (i in 0 until textViewCount) {
            if (col_text_view_array[i]!!.isSelected) {
                row_result.append("$rowName$i,")
            }
        }
        return row_result
    }

    fun onPaymentSuccess(p0: String?) {
        val selectedId = binding.radioGroup.checkedRadioButtonId

        val radioButton = findViewById<View>(selectedId) as RadioButton

        val SeatingStr = StringBuilder()
        SeatingStr.append(textResult("A", col_text_view_array_1!!))
        SeatingStr.append(textResult("B", col_text_view_array_2!!))
        SeatingStr.append(textResult("C", col_text_view_array_3!!))
        SeatingStr.append(textResult("D", col_text_view_array_4!!))
        SeatingStr.append(textResult("E", col_text_view_array_5!!))

        SeatingStr.deleteCharAt(SeatingStr.length - 1)
        loadingDialog.show()

        val totalPrice = price * quantityCount
        val options = JSONObject()

        options.put("movieId", intent.getStringExtra("movieId")!!)
        options.put("banner_image_url", intent.getStringExtra("banner_image_url")!!)
        options.put("movie_name", intent.getStringExtra("movie_name"))
        options.put("cinemaName", intent.getStringExtra("cinema_name"))
        options.put("cinemaLocation", intent.getStringExtra("cinema_location")!!)
        options.put("quantity", quantityCount)
        options.put("price", price)
        options.put("totalPrice", totalPrice)
        options.put("date", binding.pickDateBtn.text)
        options.put("time", radioButton.text)
        options.put("seat", SeatingStr.toString())
        val queue = Volley.newRequestQueue(this)
        val url = "http://10.252.240.130:5000/checkout"

        val request = JsonObjectRequest(Request.Method.POST, url, options, { response ->
            try {
                try {
                    loadingDialog.dismiss()
                    val intent = Intent(this, MainActivity::class.java)
                    Toast.makeText(
                        baseContext,
                        "Ticket Booked Successfully",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, { error -> error.printStackTrace() })
        queue.add(request)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun setBackgroundTextView(textViewArray: Array<TextView?>?, i: Int) {
        if (textViewArray!![i]!!.isSelected) {
            textViewArray[i]!!.background = ResourcesCompat.getDrawable(
                resources,
                R.drawable.button_light_set_dialog_outline,
                null
            )

        } else {
            textViewArray[i]!!.background =
                ResourcesCompat.getDrawable(resources, R.drawable.button_outline, null)

        }
    }

}