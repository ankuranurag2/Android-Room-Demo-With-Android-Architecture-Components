package gemini.com.roomexample

import android.content.Context
import gemini.com.roomexample.Database.AppDatabase
import gemini.com.roomexample.ViewModels.WordViewModelFactory

object InjectorUtils{

    fun getWordViewModelFactory(context: Context):WordViewModelFactory{
        return WordViewModelFactory(AppDatabase.getInstance(context).wordDao())
    }
}