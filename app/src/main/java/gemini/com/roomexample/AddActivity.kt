package gemini.com.roomexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        add.setOnClickListener {
            val text = word_et.text.toString()
            if (!text.isNullOrEmpty()) {
                val replyIntent = Intent()
                replyIntent.putExtra("data", text)
                setResult(Activity.RESULT_OK, replyIntent)

                finish()
            } else
                Snackbar.make(coordinator, "Name can't be empty!!!", Snackbar.LENGTH_SHORT).show()
        }
    }
}