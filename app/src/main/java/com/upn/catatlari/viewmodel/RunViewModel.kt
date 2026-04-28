package com.upn.catatlari.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.upn.catatlari.data.RunDatabase
import com.upn.catatlari.data.RunRepository
import com.upn.catatlari.model.Run
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RunViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RunRepository

    val runHistory: LiveData<List<Run>>

    init {
        val runDao = RunDatabase.getDatabase(application).runDao()
        repository = RunRepository(runDao)
        runHistory = repository.allRuns
    }

    // CREATE
    fun addRun(run: Run) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertRun(run)
        }
    }

    // UPDATE
    fun updateRun(run: Run) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateRun(run)
        }
    }

    // DELETE
    fun deleteRun(run: Run) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteRun(run)
        }
    }
}