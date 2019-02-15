package com.slowhand.kt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        main()
    }

    private fun main() = runBlocking<Unit> { // this: CoroutineScope
        val job = launch {
            Log.d("Activity", "CoroutineScope.launch delay 1000L before")
            delay(1000L)
            Log.d("Activity", "CoroutineScope.launch delay 1000L after")
        }
        job.join()
        Log.d("Activity", "runBlocking delay 2000L before")
        delay(2000L)
        Log.d("Activity", "runBlocking delay 2000L after")
    }
}
