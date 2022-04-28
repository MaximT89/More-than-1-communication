package com.secondworld.communicationwithstate.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.secondworld.communicationwithstate.core.Observe
import com.secondworld.communicationwithstate.data.model.Users
import com.secondworld.communicationwithstate.domain.interactor.Interactor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactorAdmin: Interactor.InteractorAdmin,
    private val interactorDesigner: Interactor.InteractorDesigner,
    private val interactorManager: Interactor.InteractorManager,
    private val interactorProductManager: Interactor.InteractorProductManager,
    private val communicationUsers: CommunicationUsers
) : ViewModel(), Observe<Users> {

    override fun observe(owner: LifecycleOwner, observer: Observer<Users>) {
        communicationUsers.observe(owner, observer)
    }

    fun mapAdmin() = communicationUsers.map(interactorAdmin.get())
    fun mapManager() = communicationUsers.map(interactorManager.get())
    fun mapProductManager() = communicationUsers.map(interactorProductManager.get())
    fun mapDesigner() = communicationUsers.map(interactorDesigner.get())
}