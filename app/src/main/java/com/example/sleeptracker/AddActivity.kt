package com.example.sleeptracker

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    private var quality : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        imageViewVerySatisfied.setOnClickListener{
            quality = 5
            textViewQuality.text = "Very Happy"
        }

        imageViewSatisfied.setOnClickListener {
            quality = 4
            textViewQuality.text = "Happy"
        }

        imageViewNeutral.setOnClickListener{
            quality = 3
            textViewQuality.text = "Neutral"
        }

        imageViewDissatisfied.setOnClickListener {
            quality = 2
            textViewQuality.text = "Sad"
        }

        imageViewDissatisfied.setOnClickListener {
            quality = 1
            textViewQuality.text = "Very Sad"
        }

        buttonSave.setOnClickListener {
            if (quality == 0) {
                Toast.makeText(applicationContext, "Please indicate sleep quality value", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            val intent = Intent()
            intent.putExtra(EXTRA_QUALITY, quality)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        const val EXTRA_QUALITY = "com.example.sleeptracker.QUALITY"
    }
}
