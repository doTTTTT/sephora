package fr.dot.sephora

import android.app.Application
import fr.dot.sephora.feature.main.mainDi
import fr.dot.sephora.library.core.coreDi
import fr.dot.sephora.library.domain.domainDi
import fr.dot.sephora.library.local.localDi
import fr.dot.sephora.library.remote.remoteDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SephoraApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SephoraApplication)

            modules(mainDi)

            modules(domainDi)

            modules(coreDi)
            modules(remoteDi)
            modules(localDi)
        }
    }

}