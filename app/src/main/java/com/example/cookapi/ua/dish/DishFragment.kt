package com.example.cookapi.ua.dish

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookapi.R
import com.example.cookapi.model.api.responses.Recept
import com.example.cookapi.ua.dish.adapter.DishAdapter

class DishFragment : Fragment() {

    companion object {
        fun newInstance() = DishFragment()
    }

    private val viewModel: DishViewModel by viewModels()
    private val productsAdapter = DishAdapter { dish ->
        //viewModel.onProductItemClick(product)
        //sendProductResultAndExit(product)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dish_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.dish_recyclerview)
        val search_button = view.findViewById<Button>(R.id.search_button)


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = productsAdapter

        search_button.setOnClickListener {

            val edit_text = view.findViewById<EditText>(R.id.dish_edit_text).getText().toString()

            viewModel.getListRecepts(edit_text)
        }

        viewModel.products.observe(viewLifecycleOwner) { dish ->
            productsAdapter.submitList(dish)
            productsAdapter.notifyDataSetChanged()
        }
    }



}