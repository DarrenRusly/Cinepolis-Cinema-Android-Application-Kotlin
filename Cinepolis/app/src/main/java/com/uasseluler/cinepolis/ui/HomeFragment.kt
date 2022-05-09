package com.uasseluler.cinepolis.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.uasseluler.cinepolis.R
import com.uasseluler.cinepolis.adapters.MovieAdapter
import com.uasseluler.cinepolis.databinding.FragmentHomeBinding
import com.uasseluler.cinepolis.models.MoviesItem
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.uasseluler.cinepolis.MainActivity
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieList: ArrayList<MoviesItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        movieList = ArrayList()
        retrieveMovie(binding)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun retrieveMovie(binding: FragmentHomeBinding) {
        val loadingDialog = Dialog(binding.root.context)
        loadingDialog.setContentView(R.layout.loading_layout)
        loadingDialog.window!!.setLayout(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        loadingDialog.setCancelable(false)
        loadingDialog.show()
        var count = 0
        val queue = Volley.newRequestQueue(getActivity()?.getApplicationContext())

        val actionTitle = (activity as MainActivity).supportActionBar?.title
        if (actionTitle == null || actionTitle.toString() == "Movies") {
            val url = "http://10.252.240.130:5000/get-movies"
            val method = Request.Method.GET
            val request = JsonObjectRequest(method, url, null, {
                    response ->try {
                val jsonArray = response.getJSONArray("movies")
                for (i in 0 until jsonArray.length()) {
                    count += 1
                    val movie = jsonArray.getJSONObject(i)
                    movieList.add(
                        MoviesItem(
                            count.toString(),
                            movie.getString("about_movie"),
                            movie.getString("banner_image_url"),
                            movie.getString("cover_image_url"),
                            movie.getString("languages"),
                            movie.getString("movie_duration"),
                            movie.getString("movie_name"),
                            movie.getString("rating"),
                            movie.getString("release_date"),
                            false

                        )
                    )

                }
                movieAdapter = MovieAdapter(binding.root.context, movieList)
                binding.movieRecyclerView.adapter = movieAdapter
                movieAdapter.notifyDataSetChanged()
                loadingDialog.dismiss()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            }, { error -> error.printStackTrace() })
            queue.add(request)
        }
        else {
            val url = "http://10.252.240.130:5000/get-theater-movies"
            val options = JSONObject()
            options.put("movie_name", actionTitle)
            val method = Request.Method.POST
            val request = JsonObjectRequest(method, url, options, {
                    response ->try {
                val jsonArray = response.getJSONArray("movies")
                for (i in 0 until jsonArray.length()) {
                    count += 1
                    val movie = jsonArray.getJSONObject(i)
                    movieList.add(
                        MoviesItem(
                            count.toString(),
                            movie.getString("about_movie"),
                            movie.getString("banner_image_url"),
                            movie.getString("cover_image_url"),
                            movie.getString("languages"),
                            movie.getString("movie_duration"),
                            movie.getString("movie_name"),
                            movie.getString("rating"),
                            movie.getString("release_date"),
                            false

                        )
                    )

                }
                movieAdapter = MovieAdapter(binding.root.context, movieList)
                binding.movieRecyclerView.adapter = movieAdapter
                movieAdapter.notifyDataSetChanged()
                loadingDialog.dismiss()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            }, { error -> error.printStackTrace() })
            queue.add(request)
        }



    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.search_menu, menu)
        val search = menu.findItem(R.id.app_bar_search)

        val searchView = search.actionView as SearchView
        searchView.maxWidth = android.R.attr.width
        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {
                val checkItemModelArrayList = ArrayList<MoviesItem>()

                for (i in movieList) {
                    if (i.movie_name.lowercase(Locale.getDefault())
                            .contains(newText!!.lowercase(Locale.getDefault()))
                    ) {
                        checkItemModelArrayList.add(i)
                    }
                }
                movieAdapter = MovieAdapter(
                    binding.root.context, checkItemModelArrayList
                )
                binding.movieRecyclerView.adapter = movieAdapter
                movieAdapter.notifyDataSetChanged()
                return true
            }
        })
        super.onCreateOptionsMenu(menu, menuInflater)
    }

}