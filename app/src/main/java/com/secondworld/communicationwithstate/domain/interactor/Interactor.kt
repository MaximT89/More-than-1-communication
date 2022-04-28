package com.secondworld.communicationwithstate.domain.interactor

import com.secondworld.communicationwithstate.data.model.Users
import com.secondworld.communicationwithstate.data.repository.RepositoryImpl
import com.secondworld.communicationwithstate.domain.repository.Repository
import javax.inject.Inject

interface Interactor<T> {

    fun get() : T

    class InteractorProductManager @Inject constructor(private val repository: Repository) : Interactor<Users.ProductManager>{
        override fun get() = repository.fetchProductManager()
    }

    class InteractorManager @Inject constructor(private val repository: Repository) : Interactor<Users.Manager>{
        override fun get() = repository.fetchManager()
    }

    class InteractorDesigner @Inject constructor(private val repository: Repository) : Interactor<Users.Designer>{
        override fun get() = repository.fetchDesigner()
    }

    class InteractorAdmin @Inject constructor(private val repository: Repository) : Interactor<Users.Admin>{
        override fun get()= repository.fetchAdmin()
    }
}