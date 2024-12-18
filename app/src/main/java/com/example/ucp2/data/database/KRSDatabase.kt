package com.example.ucp2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2.data.dao.DosenDao
import com.example.ucp2.data.dao.MataKuliahDao
import com.example.ucp2.data.entity.Dosen
import com.example.ucp2.data.entity.MataKuliah


@Database(entities = [Dosen::class, MataKuliah::class], version = 1, exportSchema = false)
abstract class KRSDatabase : RoomDatabase() {

    abstract fun DosenDao() : DosenDao
    abstract fun MataKuliahDao() : MataKuliahDao

    companion object{
        @Volatile
        private var Instance: KRSDatabase? = null

        fun getDatabase(context: Context): KRSDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KRSDatabase::class.java, //Class database
                    "KrsDatabase" //nama database
                )
                    .build().also { Instance = it }
            }
        }
    }
}