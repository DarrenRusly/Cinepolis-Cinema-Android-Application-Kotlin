package com.uasseluler.cinepolis.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.uasseluler.cinepolis.R
import com.uasseluler.cinepolis.adapters.OrderAdapter
import com.uasseluler.cinepolis.databinding.FragmentOrderListBinding
import com.uasseluler.cinepolis.models.OrderItem
import org.json.JSONException

class OrderListFragment : Fragment() {
    private var _binding: FragmentOrderListBinding? = null

    private val binding get() = _binding!!
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var orderList: ArrayList<OrderItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOrderListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        orderList = java.util.ArrayList()
        val loadingDialog = Dialog(binding.root.context)
        loadingDialog.setContentView(R.layout.loading_layout)
        loadingDialog.window!!.setLayout(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        loadingDialog.setCancelable(false)
        loadingDialog.show()
        val queue = Volley.newRequestQueue(getActivity()?.getApplicationContext())
        val url = "http://10.252.240.130:5000/get-orders"

        val request = JsonObjectRequest(Request.Method.GET, url, null, {
                response ->try {
            val jsonArray = response.getJSONArray("orders")
            for (i in 0 until jsonArray.length()) {
                val order = jsonArray.getJSONArray(i)
                orderList.add(
                    OrderItem(
                        order[0].toString(),
                        order[2].toString(),
                        order[3].toString(),
                        order[4].toString(),
                        order[5].toString(),
                        order[6].toString(),
                        order[7].toString(),
                        order[8].toString(),
                        order[9].toString(),
                        order[10].toString(),
                        order[11].toString()

                    )
                )

            }
            orderAdapter = OrderAdapter(binding.root.context,orderList )
            binding.orderRecyclerView.adapter = orderAdapter
            orderAdapter.notifyDataSetChanged()
            loadingDialog.dismiss()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, { error -> error.printStackTrace() })
        queue.add(request)

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}