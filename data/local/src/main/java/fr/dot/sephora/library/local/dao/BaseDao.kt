package fr.dot.sephora.library.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Upsert

internal interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entities: List<T>)

    @Upsert
    suspend fun upsert(entity: T)

    @Upsert
    suspend fun upsert(entities: List<T>)

    @Update
    suspend fun update(entity: T)

    @Update
    suspend fun update(entities: List<T>)

    @Delete
    suspend fun delete(entity: T)

    @Delete
    suspend fun delete(entities: List<T>)

}