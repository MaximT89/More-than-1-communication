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
import kotlin.text.StringBuilder

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

        viewModel.observe(this) {
            when (it) {
                is Users.Admin -> updateUi(it)
                is Users.ProductManager -> updateUi(it)
                is Users.Manager -> updateUi(it)
                is Users.Designer -> updateUi(it)
            }
        }
    }

    private fun updateUi(it: Users) {

        when (it) {
            is Users.Admin -> binding.listAdmin.text = updateSb(sbAdmin, it.name)
            is Users.ProductManager -> binding.listPm.text = updateSb(sbPm, it.name)
            is Users.Designer -> binding.listDesign.text = updateSb(sbDesigner, it.name)
            is Users.Manager -> binding.listManager.text = updateSb(sbManager, it.name)
        }
    }

    private fun updateSb(sb: StringBuilder, text: String): String {
        return sb.append(text).append("\n").toString()
    }
}