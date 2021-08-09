package com.example.shopping_assistant_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shopping_assistant_client.model.LoginRequest
import com.example.shopping_assistant_client.repository.Repository
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onStart() {
        super.onStart()
        loginButton.setOnClickListener {
            val name = nameText.text.toString()
            val passw = passwordReg.text.toString()
            val login = LoginRequest(name, passw)
            viewModel.getToken(login)
            (activity as MainActivity).navController.navigate(R.id.action_loginFragment_to_homeFragment)
        }
        setProduct.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }
}



