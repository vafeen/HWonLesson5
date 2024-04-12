package ru.vafeen.hwonlesson5.ui.activities.name

import android.os.Bundle
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

    }
}