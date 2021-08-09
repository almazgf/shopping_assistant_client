package com.example.shopping_assistant_client

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping_assistant_client.repository.Repository
import kotlinx.android.synthetic.main.fragment_composition.*


class CompositionFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)

        val linearLayoutManager = LinearLayoutManager(activity?.applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        list?.layoutManager = linearLayoutManager

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_composition, container, false)
    }

    override fun onStart() {
        super.onStart()
        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).setSupportActionBar(toolbarCompose)
            toolbarCompose.setNavigationOnClickListener{
                (activity as MainActivity).navController.navigate(R.id.action_compositionFragment_to_homeFragment)
            }
        }
        viewModel.product.observe(this, Observer { response ->
            Log.d("response11111", response.body().toString())
            val compos: List<String>? = response.body()?.composition?.toList()
            val unAccept: List<String>? = response.body()?.unacceptable_products?.toList()
            val acceptIngredients:ArrayList<String> = arrayListOf()
            val unAcceptIngredients:ArrayList<String> = arrayListOf()
            if(compos != null){
                for (i in compos){
                    acceptIngredients.add(i)
                }
            }
            if (unAccept != null){
                for (i in unAccept){
                    unAcceptIngredients.add(i)
                }
            }
            //val unAcceptIngredients: List<String>? = response.body()?.unacceptable_products?.toList()
            val adapter = ComposeAdapter(acceptIngredients, unAcceptIngredients)
            list.adapter = adapter
            Log.d("response11111", response.code().toString())
            Log.d("response11111", response.headers().toString())
        })
    }

}


