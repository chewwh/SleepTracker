package com.example.sleeptracker

import androidx.lifecycle.LiveData

class SleepRepository (private val sleepDao: SleepDAO) {
    val sleepList : LiveData<List<Sleep>> = sleepDao.getSleep()
    suspend fun insertSleep(sleep: Sleep){
        sleepDao.insertSleep(sleep)
    }
}