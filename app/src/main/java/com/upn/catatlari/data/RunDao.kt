package com.upn.catatlari.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.upn.catatlari.model.Run

@Dao
interface RunDao {

    @Insert
    suspend fun insertRun(run: Run)

    @Update
    suspend fun updateRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM run_table ORDER BY id DESC")
    fun getAllRuns(): LiveData<List<Run>>
}