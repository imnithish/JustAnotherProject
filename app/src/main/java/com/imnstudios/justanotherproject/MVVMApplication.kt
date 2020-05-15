package com.imnstudios.justanotherproject

import android.app.Application
import com.imnstudios.justanotherproject.data.db.AppDatabase
import com.imnstudios.justanotherproject.data.network.MyApi
import com.imnstudios.justanotherproject.data.network.NetworkConnectionInterceptor
import com.imnstudios.justanotherproject.data.preferences.PreferenceProvider
import com.imnstudios.justanotherproject.data.repositories.QuotesRepository
import com.imnstudios.justanotherproject.data.repositories.UserRepository
import com.imnstudios.justanotherproject.ui.auth.AuthViewModelFactory
import com.imnstudios.justanotherproject.ui.home.profile.ProfileViewModel
import com.imnstudios.justanotherproject.ui.home.profile.ProfileViewModelFactory
import com.imnstudios.justanotherproject.ui.home.profile.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {


    override val kodein = Kodein.lazy {

        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider{ QuotesViewModelFactory(instance())}



    }


}