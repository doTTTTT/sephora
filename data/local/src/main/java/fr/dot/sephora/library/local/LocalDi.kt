package fr.dot.sephora.library.local

import androidx.room.Room
import fr.dot.sephora.library.core.source.product.ProductLocalDataSource
import fr.dot.sephora.library.core.source.reviews.ReviewLocalDataSource
import fr.dot.sephora.library.local.db.SephoraDB
import fr.dot.sephora.library.local.source.ProductLocalDataSourceImpl
import fr.dot.sephora.library.local.source.ReviewLocalDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val localDi = module {
    single {
        Room.databaseBuilder(get(), SephoraDB::class.java, "sephora.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<SephoraDB>().reviewDao() }
    single { get<SephoraDB>().reviewsDao() }
    single { get<SephoraDB>().productDao() }

    singleOf(::ProductLocalDataSourceImpl) bind ProductLocalDataSource::class
    singleOf(::ReviewLocalDataSourceImpl) bind ReviewLocalDataSource::class
}