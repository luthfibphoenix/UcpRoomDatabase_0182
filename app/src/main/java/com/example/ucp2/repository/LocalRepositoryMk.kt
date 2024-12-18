package com.example.ucp2.repository

import com.example.ucp2.data.dao.MataKuliahDao
import com.example.ucp2.data.entity.MataKuliah
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMk(
    private val mataKuliahDao: MataKuliahDao
): RepositoryMk {
    override suspend fun insertMk(mataKuliah: MataKuliah) {
        mataKuliahDao.insertMk(mataKuliah)
    }

    override fun getAllMk(): Flow<List<MataKuliah>> {
        return mataKuliahDao.getAllMk()
    }

    override fun getMk(kode: String): Flow<MataKuliah> {
        return mataKuliahDao.getMk(kode)
    }

    override suspend fun deleteMk(mataKuliah: MataKuliah) {
        return mataKuliahDao.deleteMk(mataKuliah)
    }

    override suspend fun updateMk(mataKuliah: MataKuliah) {
        mataKuliahDao.updateMk(mataKuliah)
    }
}