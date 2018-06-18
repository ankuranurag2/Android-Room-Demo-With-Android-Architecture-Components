package gemini.com.roomexample.ViewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import gemini.com.roomexample.Database.Word
import gemini.com.roomexample.Database.WordDao
import gemini.com.roomexample.Database.WordRepository

class WordViewModel(private val wordDao: WordDao) : ViewModel() {

    private val mAllWords by lazy {
        WordRepository.getInstance(wordDao).getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> {
        return mAllWords
    }

    fun insert(word:Word){
        WordRepository.getInstance(wordDao).insertWord(word)
    }
}