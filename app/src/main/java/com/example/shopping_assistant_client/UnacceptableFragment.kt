package com.example.shopping_assistant_client

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shopping_assistant_client.model.UnacceptableProductRequest
import com.example.shopping_assistant_client.repository.Repository
import kotlinx.android.synthetic.main.fragment_unacceptable.*


class UnacceptableFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)

        return inflater.inflate(R.layout.fragment_unacceptable, container, false)
    }

    override fun onStart() {
        super.onStart()
        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).setSupportActionBar(toolbarUnaccept)
            toolbarUnaccept.setNavigationOnClickListener{
                (activity as MainActivity).navController.navigate(R.id.action_unacceptableFragment_to_homeFragment)
            }
        }
        setProduct.setOnClickListener {
            val temp = arrayListOf<String>(unproduct.text.toString())
            val  unacceptableProduct: UnacceptableProductRequest = UnacceptableProductRequest(temp)
            val token:String = "Bearer ${viewModel.accessToken.value}"
            viewModel.setUnacceptableProduct(token, unacceptableProduct)

            viewModel.unacceptable.observe(this, Observer { response ->
                val unaccept: List<String>? = response.body()?.unacceptable_products?.toList()
                if (unaccept != null) {
                    unacceptList.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_list_item_1, unaccept)
                }

            })

        }


        }


    }

