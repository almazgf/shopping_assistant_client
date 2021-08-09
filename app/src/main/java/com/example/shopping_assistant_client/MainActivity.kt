package com.example.shopping_assistant_client

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.shopping_assistant_client.repository.Repository

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private lateinit var viewModel: MainViewModel
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host)




        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)







/*
        button1.setOnClickListener {

            var barcode1 = edit.text.toString()
            var barcode: Barcode = Barcode(barcode1)

            var token:String = "Bearer ${viewModel.token.value}"
            viewModel.getProduct(token, barcode)

            viewModel.product.observe(this, Observer { response ->
                Log.d("response11111", response.body().toString())
                val compos: List<String>? = response.body()?.composition?.toList()
                if (compos != null) {
                    list1.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, compos)
                }
                Log.d("response11111", response.code().toString())
                Log.d("response11111", response.headers().toString())
            })
        }
*/

    }


}