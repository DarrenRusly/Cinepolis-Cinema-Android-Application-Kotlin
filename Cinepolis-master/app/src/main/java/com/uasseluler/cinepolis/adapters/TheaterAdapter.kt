package com.uasseluler.cinepolis.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uasseluler.cinepolis.MainActivity
import com.uasseluler.cinepolis.R
import com.uasseluler.cinepolis.databinding.ViewCinemaLayoutBinding
import com.uasseluler.cinepolis.models.CinemaModel
import com.uasseluler.cinepolis.ui.CinemaFragment
import com.uasseluler.cinepolis.ui.HomeFragment

class TheaterAdapter (
    private val context: Context,
    private val movieList: List<CinemaModel>
) :
    RecyclerView.Adapter<TheaterAdapter.BindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        var rootView = ViewCinemaLayoutBinding.inflate(LayoutInflater.from(context), parent, false)

        return BindingViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {

        val movie = movieList[position]
        Glide.with(context)
            .load(movie.cinemaDrawable)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_image_24)
            .into(holder.itemBinding.ivGroupFirstImg)
        holder.itemBinding.txtCinemaName.text = movie.cinemaName
        holder.itemBinding.txtCinemaLocation.text = movie.cinemaLocation
        holder.itemView.setOnClickListener {

            val activity = (context as MainActivity)
            val navController = activity.findNavController(R.id.theaterRecyclerView)
            val id = navController.currentDestination?.id
            navController.popBackStack(id!!,true)
            navController.navigate(R.id.nav_home)
            activity.supportActionBar?.setTitle(movie.cinemaName)

        }
    }

    override fun getItemCount() = movieList.size
    class BindingViewHolder(val itemBinding: ViewCinemaLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}