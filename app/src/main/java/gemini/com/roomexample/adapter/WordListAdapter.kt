package gemini.com.roomexample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gemini.com.roomexample.Database.Word
import gemini.com.roomexample.R
import kotlinx.android.synthetic.main.word_item.view.*

class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    var wordList: List<Word>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.word_item, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (wordList != null)
            return wordList!!.size
        else
            return 0
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordList)
    }

    class WordViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(list: List<Word>?) = with(itemView) {
            if (list != null)
                word_tv.text = list[adapterPosition].word
            else
                word_tv.text = "No data"
        }
    }

    fun setWords(words: List<Word>) {
        wordList = words
        notifyDataSetChanged()
    }
}