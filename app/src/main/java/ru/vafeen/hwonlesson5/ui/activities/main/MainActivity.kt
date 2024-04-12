package ru.vafeen.hwonlesson5.ui.activities.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.vafeen.hwonlesson5.databinding.ActivityMainBinding
import ru.vafeen.hwonlesson5.ui.activities.name.NameActivity
import ru.vafeen.hwonlesson5.values.PutGet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isRegistered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState.apply {
            if (this != null) {
                isRegistered = getBoolean(PutGet.IsRegistered.value)
            }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        content()
    }

    private fun content() {
        if (!isRegistered) {
            binding.greeting.visibility = View.GONE

            binding.beginSigningUp.visibility = View.VISIBLE
        } else {
            binding.greeting.text = "Вы успешно зарегистрированы!"

            binding.beginSigningUp.visibility = View.GONE
        }

        binding.beginSigningUp.setOnClickListener {
            val intent = Intent(this, NameActivity::class.java)

            startActivity(intent)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.apply {
            putBoolean(PutGet.IsRegistered.value, isRegistered)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.apply {
            isRegistered = getBoolean(PutGet.IsRegistered.value)
        }
    }
}
