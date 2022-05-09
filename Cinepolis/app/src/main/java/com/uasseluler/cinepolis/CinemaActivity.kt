package com.uasseluler.cinepolis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.uasseluler.cinepolis.adapters.CinemaAdapter
import com.uasseluler.cinepolis.databinding.ActivityCinemaBinding
import com.uasseluler.cinepolis.models.CinemaModel
import org.json.JSONException
import org.json.JSONObject

class CinemaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCinemaBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_cinema)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val cinemaList: ArrayList<CinemaModel> = ArrayList()

        val movie_name = intent.getStringExtra("movie_name")
        val banner_image_url = intent.getStringExtra("banner_image_url")
        val movieId = intent.getStringExtra("movieId")
        val sharedPreferences = getSharedPreferences(
            getString(R.string.app_name),
            MODE_PRIVATE
        )
        val selectedCityList:ArrayList<CinemaModel> = ArrayList()
        val locationStr = sharedPreferences.getString("location_str", null)
        val queue = Volley.newRequestQueue(this)
        val url = "http://10.252.240.130:5000/select-theater"
        val options = JSONObject()
        options.put("movieId", intent.getStringExtra("movieId")!!)
        val request = JsonObjectRequest(Request.Method.POST, url, options, {
                response ->try {
            val jsonArray = response.getJSONArray("theaters")
            for (i in 0 until jsonArray.length()) {
                val theater = jsonArray.getJSONObject(i)
                cinemaList.add(
                    CinemaModel(
                        theater.getString("cinemaName"),
                        theater.getString("cinemaLocation"),
                        theater.getString("cinemaDrawable"),
                    )
                )
                if (locationStr != null) {
                    if (locationStr.isNotEmpty()) {
                        val lstValues: List<String> = locationStr.split(",").map { it.trim() }
                        lstValues.forEach {
                            cinemaList.forEachIndexed { i, element ->
                                if (element.cinemaLocation == it) {
                                    selectedCityList.add(
                                        CinemaModel(element.cinemaName,
                                            element.cinemaLocation,element.cinemaDrawable)
                                    )
                                }
                            }
                        }
                    }
                }
                if (selectedCityList.isNotEmpty()){
                    val cinemaAdapter = CinemaAdapter(
                        this, selectedCityList,movie_name!!,banner_image_url!!,movieId!!
                    )
                    binding.movieRecyclerView.adapter = cinemaAdapter
                } else{
                    val cinemaAdapter = CinemaAdapter(
                        this, cinemaList,movie_name!!,banner_image_url!!,movieId!!
                    )
                    binding.movieRecyclerView.adapter = cinemaAdapter
                }
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
}
