package com.uasseluler.cinepolis.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.uasseluler.cinepolis.R
import com.uasseluler.cinepolis.databinding.ViewOrderLayoutBinding
import com.uasseluler.cinepolis.models.OrderItem

class OrderAdapter(private val context: Context, private val orderList: ArrayList<OrderItem>) :
    RecyclerView.Adapter<OrderAdapter.BindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView = ViewOrderLayoutBinding.inflate(LayoutInflater.from(context), parent, false)

        return BindingViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val order = orderList[position]
        Glide.with(context)
            .load(order.banner_image_url)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_image_24)
            .into(holder.itemBinding.roundShapeImageview)
        holder.itemBinding.txtCinemaLocation.text = "Location: ${order.cinemaLocation}"
        holder.itemBinding.txtCinemaName.text = "Cinema Name: ${order.cinemaName}"
        holder.itemBinding.txtMovieName.text = "Movie Name: ${order.movie_name}"
        holder.itemBinding.txtDate.text = "Date: ${order.date}"
        holder.itemBinding.txtTime.text = "Time: ${order.time}"
        holder.itemBinding.txtseat.text = "Seat No: ${order.seat}"
        holder.itemBinding.txtPrice.text = "Price: Rp.${order.price}"
        holder.itemBinding.txtQuantity.text = "Quantity: ${order.quality}"
        holder.itemBinding.txtTotalPrice.text = "Total Price: Rp.${order.totalPrice}"

        holder.itemBinding.executePendingBindings()
    }

    override fun getItemCount() = orderList.size
    class BindingViewHolder(val itemBinding: ViewOrderLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root)


}