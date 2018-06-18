package gemini.com.roomexample.Database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "word_table")
data class Word(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "word")
        val word: String
) {
    override fun toString(): String {
        return word
    }

    override fun equals(other: Any?): Boolean {
        return word.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}