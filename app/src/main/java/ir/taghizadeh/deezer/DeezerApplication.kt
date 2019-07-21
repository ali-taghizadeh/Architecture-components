package ir.taghizadeh.deezer

import android.app.Application
import ir.taghizadeh.deezer.data.db.DeezerDatabase
import ir.taghizadeh.deezer.data.network.config.NetworkDataSource
import ir.taghizadeh.deezer.data.network.config.NetworkDataSourceImpl
import ir.taghizadeh.deezer.data.repository.TrackListRepository
import ir.taghizadeh.deezer.data.repository.TrackListRepositoryImpl
import ir.taghizadeh.deezer.view.trackList.TrackListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class DeezerApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@DeezerApplication))
        bind() from singleton { DeezerDatabase(instance()) }
        bind() from singleton { instance<DeezerDatabase>().TrackListDao() }
        bind<NetworkDataSource>() with singleton { NetworkDataSourceImpl() }
        bind<TrackListRepository>() with singleton { TrackListRepositoryImpl(instance(), instance()) }
        bind() from provider { TrackListViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
    }
}