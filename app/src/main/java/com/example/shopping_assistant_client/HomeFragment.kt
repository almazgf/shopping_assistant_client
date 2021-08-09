package com.example.shopping_assistant_client

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shopping_assistant_client.model.Barcode
import com.example.shopping_assistant_client.repository.Repository
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStart() {
        super.onStart()

        barcodeButton.setOnClickListener {
            val scanner = IntentIntegrator.forSupportFragment(this).initiateScan()
        }

        composition1.setOnClickListener {
            val barcode1 = barcode1.text.toString()
            val barcode: Barcode = Barcode(barcode1)
            val token:String = "Bearer ${viewModel.accessToken.value}"
           // textView.text = barcode.toString()
            //textView2.text = token
            viewModel.getProduct(token, barcode)
            (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_compositionFragment)

            }

        loginButton1.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_loginFragment)
        }

        unacceptButton.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_unacceptableFragment)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(activity, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                barcode1.setText(result.contents)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}


