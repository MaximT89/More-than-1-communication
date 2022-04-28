package com.secondworld.communicationwithstate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.secondworld.communicationwithstate.R
import com.secondworld.communicationwithstate.data.model.Users
import com.secondworld.communicationwithstate.databinding.ActivityMainBinding
import com.secondworld.communicationwithstate.domain.interactor.Interactor
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private val sbAdmin = StringBuilder()
    private val sbManager = StringBuilder()
    private val sbPm = StringBuilder()
    private val sbDesigner = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObservers()
    }

    private fun initView() {
        binding.addAdmin.setOnClickListener { viewModel.mapAdmin() }
        binding.addManager.setOnClickListener { viewModel.mapManager() }
        binding.addDesigner.setOnClickListener { viewModel.mapDesigner() }
        binding.addPm.setOnClickListener { viewModel.mapProductManager() }
    }

    private fun initObservers() {

        viewModel.observe(this){

            when(it){
                is Users.Admin -> updateUi(it)
                is Users.ProductManager -> updateUi(it)
                is Users.Manager -> updateUi(it)
                is Users.Designer -> updateUi(it)
            }
        }
    }

    private fun updateUi(it: Users) {

        when(it){
            is Users.Admin -> {
                sbAdmin.append(it.name).append("\n")
                binding.listAdmin.text = sbAdmin.toString()
            }
            is Users.ProductManager -> {
                sbPm.append(it.name).append("\n")
                binding.listPm.text = sbPm.toString()
            }
            is Users.Designer -> {
                sbDesigner.append(it.name).append("\n")
                binding.listDesign.text = sbDesigner.toString()
            }
            is Users.Manager -> {
                sbManager.append(it.name).append("\n")
                binding.listManager.text = sbManager.toString()
            }
        }
    }
}