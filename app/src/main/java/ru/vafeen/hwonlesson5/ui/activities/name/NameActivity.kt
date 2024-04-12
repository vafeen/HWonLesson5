package ru.vafeen.hwonlesson5.ui.activities.name

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.vafeen.hwonlesson5.databinding.ActivityNameBinding


class NameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState.apply {
            if (this != null) {

            }
        }

        binding = ActivityNameBinding.inflate(layoutInflater)

        setContentView(binding.root)

        content()
    }

    private fun content() {
        binding.apply {
            backButton.visibility = View.VISIBLE
            exitButton.visibility = View.VISIBLE
            forwardButton.visibility = View.VISIBLE

            backButton.setOnClickListener {
                finish()
            }

            exitButton.setOnClickListener {
                this@NameActivity.finishAffinity()
            }

            forwardButton.setOnClickListener {
//                val intent = Intent(this, )
            }
        }
    }
}