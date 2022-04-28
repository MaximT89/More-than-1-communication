package com.secondworld.communicationwithstate.ui

import com.secondworld.communicationwithstate.core.Communication
import com.secondworld.communicationwithstate.data.model.Users
import javax.inject.Inject

interface CommunicationUsers : Communication<Users> {
    class UiUpdateUser @Inject constructor() : Communication.UiUpdate<Users>(), CommunicationUsers
}