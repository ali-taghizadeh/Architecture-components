package ir.taghizadeh.deezer.data.db.typeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.taghizadeh.deezer.data.network.responses.general.Artist


object ArtistTypeTypeConverter {
    @TypeConverter
    fun stringToArtist(json: String): List<Artist> {
        val gson = Gson()
        val type = object : TypeToken<List<Artist>>() {

        }.type
        return gson.fromJson<List<Artist>>(json, type)
    }

    @TypeConverter
    fun artistToString(list: List<Artist>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Artist>>() {

        }.type
        return gson.toJson(list, type)
    }
}