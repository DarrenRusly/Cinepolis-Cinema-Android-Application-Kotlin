package com.uasseluler.cinepolis.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.uasseluler.cinepolis.adapters.TheaterAdapter
import com.uasseluler.cinepolis.databinding.FragmentCinemaBinding

import com.uasseluler.cinepolis.models.CinemaModel
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class CinemaFragment : Fragment() {

    private var _binding: FragmentCinemaBinding? = null
    private val binding get() = _binding!!
    private lateinit var cinemaList: ArrayList<CinemaModel>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCinemaBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        cinemaList = ArrayList()

        val selectedCityList:ArrayList<CinemaModel> = ArrayList()
        val queue = Volley.newRequestQueue(getActivity()?.getApplicationContext())
        val url = "http://10.252.240.130:5000/get-theaters"
        val request = JsonObjectRequest(Request.Method.GET, url, null, {
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

                if (selectedCityList.isNotEmpty()){
                    val theaterAdapter = TheaterAdapter(
                        binding.root.context, selectedCityList,
                    )
                    binding.theaterRecyclerView.adapter = theaterAdapter
                } else{
                    val theaterAdapter = TheaterAdapter(
                        binding.root.context, cinemaList
                    )
                    binding.theaterRecyclerView.adapter = theaterAdapter
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, { error -> error.printStackTrace() })
        queue.add(request)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}