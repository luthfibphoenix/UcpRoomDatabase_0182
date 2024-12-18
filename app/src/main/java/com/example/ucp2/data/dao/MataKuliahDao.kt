package com.example.ucp2.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2.data.entity.MataKuliah
import kotlinx.coroutines.flow.Flow


@Dao
interface MataKuliahDao {
    @Insert
    suspend fun insertMk(mataKuliah: MataKuliah)

    @Query("SELECT * FROM matakuliah ORDER BY namaMK ASC")
    fun getAllMk(): Flow<List<MataKuliah>>

    @Query("SELECT * FROM matakuliah WHERE kodeMk = :kode")
    fun getMk(kode: String): Flow<MataKuliah>

    @Delete
    suspend fun deleteMk(mataKuliah: MataKuliah)

    @Update
    suspend fun updateMk(mataKuliah: MataKuliah)
}