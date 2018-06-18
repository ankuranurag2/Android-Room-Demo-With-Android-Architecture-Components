package gemini.com.roomexample.Database


class WordRepository private constructor(private val wordDao: WordDao) {

    fun getAllWords() = wordDao.getAllWords()

    fun insertWord(newWord: Word) = wordDao.insert(newWord)

    fun updateWord(newWord: Word) = wordDao.update(newWord)

    fun deleteWord(word: Word) = wordDao.delete(word)

    companion object {
        @Volatile
        private var mInstance: WordRepository? = null

        fun getInstance(wordDao: WordDao) = mInstance ?: synchronized(this) {
            mInstance ?: WordRepository(wordDao).also { mInstance = it }
        }
    }
}