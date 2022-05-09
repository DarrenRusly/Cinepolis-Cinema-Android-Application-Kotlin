package com.uasseluler.cinepolis.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.uasseluler.cinepolis.BR
import com.uasseluler.cinepolis.MovieDetailsActivity
import com.uasseluler.cinepolis.databinding.ViewMovieLayoutBinding
import com.uasseluler.cinepolis.models.MoviesItem


class MovieAdapter(private val context: Context, private val movieList: List<MoviesItem>) :
    RecyclerView.Adapter<MovieAdapter.BindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView = ViewMovieLayoutBinding.inflate(LayoutInflater.from(context), parent, false)

        return BindingViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val movie = movieList[position]
        holder.itemBinding.setVariable(BR.movieItemClient, movie)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra("movieId", movie.movieId)
            intent.putExtra("about_movie", movie.about_movie)
            intent.putExtra("banner_image_url", movie.banner_image_url)
            intent.putExtra("cover_image_url", movie.cover_image_url)
            intent.putExtra("languages", movie.languages)
            intent.putExtra("movie_duration", movie.movie_duration)
            intent.putExtra("movie_name", movie.movie_name)
            intent.putExtra("rating", movie.rating)
            intent.putExtra("release_date", movie.release_date)
            context.startActivity(intent)
        }
        holder.itemBinding.executePendingBindings()
    }

    override fun getItemCount() = movieList.size
    class BindingViewHolder(val itemBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

}