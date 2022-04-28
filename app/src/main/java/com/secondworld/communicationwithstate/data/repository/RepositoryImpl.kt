package com.secondworld.communicationwithstate.data.repository

import com.secondworld.communicationwithstate.data.model.Users
import com.secondworld.communicationwithstate.data.storage.Storage
import com.secondworld.communicationwithstate.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val storage: Storage) : Repository {

    override fun fetchManager(): Users.Manager = Users.Manager(storage.name())

    override fun fetchProductManager(): Users.ProductManager = Users.ProductManager(storage.name())

    override fun fetchAdmin(): Users.Admin = Users.Admin(storage.name())

    override fun fetchDesigner(): Users.Designer = Users.Designer(storage.name())
}