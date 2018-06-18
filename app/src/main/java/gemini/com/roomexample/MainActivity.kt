package gemini.com.roomexample

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import gemini.com.roomexample.Database.Word
import gemini.com.roomexample.ViewModels.WordViewModel
import gemini.com.roomexample.adapter.WordListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    lateinit var wordViewModel: WordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = WordListAdapter()
        val lManager = LinearLayoutManager(this)
        recyclerview.layoutManager = lManager
        recyclerview.adapter = adapter

        val factory = InjectorUtils.getWordViewModelFactory(applicationContext)
        wordViewModel = ViewModelProviders.of(this, factory).get(WordViewModel::class.java)
        wordViewModel.getAllWords().observe(this, Observer {
            adapter.setWords(it!!)
        })

        fab.setOnClickListener {
            startActivityForResult(Intent(this, AddActivity::class.java), ADD_WORD_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 101) {
            val name = data?.getStringExtra("data")

            if (name != null)
                doAsync {
                    wordViewModel.insert(Word(name))

                    uiThread {
                        Snackbar.make(coordinator_lay, "Added", Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
