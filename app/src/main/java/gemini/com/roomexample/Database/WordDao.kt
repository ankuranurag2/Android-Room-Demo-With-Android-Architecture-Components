package gemini.com.roomexample.Database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table")
    fun getAllWords(): LiveData<List<Word>>

    @Insert()   //no conflict strategy needed as the Word is Primary key itself, so no conflict, default is abort
    fun insert(word: Word)

    @Delete
    fun delete(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Update
    fun update(word: Word)
}