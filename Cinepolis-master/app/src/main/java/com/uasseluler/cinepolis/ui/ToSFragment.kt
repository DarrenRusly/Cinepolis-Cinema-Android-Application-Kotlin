package com.uasseluler.cinepolis.ui

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.uasseluler.cinepolis.R
import com.uasseluler.cinepolis.databinding.FragmentTosBinding
import java.util.*


class ToSFragment : Fragment() {

    private var _binding: FragmentTosBinding? = null

    private val binding get() = _binding!!
    private lateinit var loadingDialog: Dialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTosBinding.inflate(inflater, container, false)
        val root: View = binding.root
        loadingDialog = Dialog(binding.root.context)
        loadingDialog.setContentView(R.layout.loading_layout)
        loadingDialog.window!!.setLayout(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        loadingDialog.setCancelable(false)
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}