package ir.taghizadeh.deezer.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.taghizadeh.deezer.data.db.entity.Track


@Dao
interface TrackListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(trackListEntry: List<Track>)

    @Query("select * from track_list")
    fun getTrackList(): LiveData<List<Track>>

}