package com.example.shopping_assistant_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shopping_assistant_client.model.LoginRequest
import com.example.shopping_assistant_client.repository.Repository
import kotlinx.android.synthetic.main.fragment_login.passwordReg
import kotlinx.android.synthetic.main.fragment_login.setProduct
import kotlinx.android.synthetic.main.fragment_registration.*


class RegistrationFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onStart() {
        super.onStart()
        setProduct.setOnClickListener {
            val name = nameReg.text.toString()
            val passw = passwordReg.text.toString()
            val passw1 = passwordReg1.text.toString()
            if (passw.equals(passw1)) {
                val login = LoginRequest(name, passw)
                viewModel.getTokenReg(login)
                (activity as MainActivity).navController.navigate(R.id.action_registrationFragment_to_homeFragment)
            }else{
                Toast.makeText(context, "Введенные пароли не совпадают", Toast.LENGTH_LONG).show()
            }
        }

        }
    }




