package com.example.sleeptracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Sleep::class), version = 1)
abstract class SleepDB: RoomDatabase() {
    //create an instance of the DAO
    abstract fun sleepDao() : SleepDAO

    companion object{
        // create an instance of the room db
        // singleton prevents multiple instances of the db
        @Volatile
        private var INSTANCE : SleepDB? = null

        fun getDatabase(context: Context): SleepDB{
            val tempDB = INSTANCE
            if(tempDB!= null){
                return tempDB
            }

            //create an instance of the db
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context, SleepDB::class.java,"sleep_db"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}