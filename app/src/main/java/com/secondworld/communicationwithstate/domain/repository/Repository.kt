package com.secondworld.communicationwithstate.domain.repository

import com.secondworld.communicationwithstate.data.model.Users

interface Repository {

    fun fetchManager() : Users.Manager
    fun fetchProductManager() : Users.ProductManager
    fun fetchAdmin() : Users.Admin
    fun fetchDesigner() : Users.Designer
}