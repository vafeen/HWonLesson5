package ru.vafeen.hwonlesson5.ui.activities.firstname

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.vafeen.hwonlesson5.databinding.ActivityFirstnameBinding


class FirstName : AppCompatActivity() {

    private lateinit var binding: ActivityFirstnameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState.apply {
            if (this != null) {

            }
        }

        binding = ActivityFirstnameBinding.inflate(layoutInflater)

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
                this@FirstName.finishAffinity()
            }

            forwardButton.setOnClickListener {
//                val intent = Intent(this, )
            }
        }
    }
}