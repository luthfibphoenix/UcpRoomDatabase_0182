package com.example.ucp2.dependenciesinjection

import android.content.Context
import com.example.ucp2.data.database.KRSDatabase
import com.example.ucp2.repository.LocalRepositoryDsn
import com.example.ucp2.repository.LocalRepositoryMk
import com.example.ucp2.repository.RepositoryDsn
import com.example.ucp2.repository.RepositoryMk

interface InterfaceContainerApp {
    val repositoryDsn: RepositoryDsn
    val ropositoryMk: RepositoryMk
}

class ContainerApp (private val context: Context) : InterfaceContainerApp {
    override val repositoryDsn: RepositoryDsn by lazy {
        LocalRepositoryDsn(KRSDatabase.getDatabase(context).DosenDao())
    }
}