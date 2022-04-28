package com.secondworld.communicationwithstate.ui

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.secondworld.communicationwithstate.core.BaseActivity
import com.secondworld.communicationwithstate.data.model.Users
import com.secondworld.communicationwithstate.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.text.StringBuilder

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    private val viewModel by viewModels<MainViewModel>()
    private val sbAdmin = StringBuilder()
    private val sbManager = StringBuilder()
    private val sbPm = StringBuilder()
    private val sbDesigner = StringBuilder()

    override fun initView() {
        binding.addAdmin.setOnClickListener { viewModel.mapAdmin() }
        binding.addManager.setOnClickListener { viewModel.mapManager() }
        binding.addDesigner.setOnClickListener { viewModel.mapDesigner() }
        binding.addPm.setOnClickListener { viewModel.mapProductManager() }
    }

    override fun initObservers() {
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

    private fun updateSb(sb: StringBuilder, text: String) = sb.append(text).append("\n").toString()
}