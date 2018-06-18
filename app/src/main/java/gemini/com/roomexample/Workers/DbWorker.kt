package gemini.com.roomexample.Workers

import androidx.work.Worker
import gemini.com.roomexample.Database.AppDatabase
import gemini.com.roomexample.Database.Word
import java.lang.Exception

class DbWorker : Worker() {

    override fun doWork(): WorkerResult {
        return try {
            val db = AppDatabase.getInstance(applicationContext)
            db.wordDao().deleteAll()
            for (i in 1..100) {
                db.wordDao().insert(Word("Word $i"))
                Thread.sleep(500)
            }
            WorkerResult.SUCCESS
        } catch (e: Exception) {
            WorkerResult.FAILURE
        }
    }
}