package com.secondworld.communicationwithstate.di

import com.secondworld.communicationwithstate.data.repository.RepositoryImpl
import com.secondworld.communicationwithstate.domain.repository.Repository
import com.secondworld.communicationwithstate.ui.CommunicationUsers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindCommunicationUsers(communication: CommunicationUsers.UiUpdateUser) :
            CommunicationUsers

    @Binds
    abstract fun bindRepository(repository: RepositoryImpl) : Repository
}