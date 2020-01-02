package com.example.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.net.ContentHandler

class SleepViewModel (application: Application) : AndroidViewModel(application) {
    private val sleepRepository: SleepRepository
    val sleepList : LiveData<List<Sleep>>

    init {
        val sleepDAO : SleepDAO = SleepDB.getDatabase(application).sleepDao()
        sleepRepository = SleepRepository(sleepDAO)
        sleepList = sleepRepository.sleepList
    }

    //execute coroutine
    fun insertSleep(sleep: Sleep) = viewModelScope.launch {
        sleepRepository.insertSleep(sleep)
    }
}