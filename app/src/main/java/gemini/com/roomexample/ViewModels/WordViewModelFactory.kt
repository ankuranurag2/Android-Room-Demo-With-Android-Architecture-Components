package gemini.com.roomexample.ViewModels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import gemini.com.roomexample.Database.WordDao

class WordViewModelFactory(private val wordDao:WordDao): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = WordViewModel(wordDao) as T
}
