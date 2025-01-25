package fr.dot.sephora.library.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.dot.sephora.library.local.dao.ProductDao
import fr.dot.sephora.library.local.dao.ReviewDao
import fr.dot.sephora.library.local.dao.ReviewsDao
import fr.dot.sephora.library.local.entity.ProductEntity
import fr.dot.sephora.library.local.entity.ReviewEntity
import fr.dot.sephora.library.local.entity.ReviewsEntity

@Database(
    entities = [
        ProductEntity::class,
        ReviewEntity::class,
        ReviewsEntity::class
    ],
    version = 1,
    exportSchema = true
)
internal abstract class SephoraDB : RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun reviewDao(): ReviewDao
    abstract fun reviewsDao(): ReviewsDao

}