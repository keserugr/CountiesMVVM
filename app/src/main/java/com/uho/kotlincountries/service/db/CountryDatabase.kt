package com.uho.kotlincountries.service.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.uho.kotlincountries.model.Country

@Database(entities = [Country::class], version = 2)
abstract class CountryDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao

    //Singleton
    companion object {

        @Volatile
        private var instance: CountryDatabase? = null

        private val lock = Any()

        val migration_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE country RENAME COLUMN id TO uId")
            }

        }

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, CountryDatabase::class.java, "country_database"
        ).addMigrations(migration_1_2)
            .build()
    }
}