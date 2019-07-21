package ir.taghizadeh.deezer.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.taghizadeh.deezer.data.db.entity.Track


@Database(
    entities = [Track::class],
    version = 1
)

abstract class DeezerDatabase : RoomDatabase() {
    abstract fun TrackListDao(): TrackListDao

    companion object {
        @Volatile private var instance: DeezerDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                    DeezerDatabase::class.java, "DeezerEntries.db")
                    .build()
    }
}