package com.aadil.assingment

import android.app.Application
import com.aadil.assingment.db.AppDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class AssingmentApplication : Application(),KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@AssingmentApplication))

        bind() from singleton { AppDatabase(instance()) }



    }

}