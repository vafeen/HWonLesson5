package ru.vafeen.hwonlesson5

import android.opengl.Visibility
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.vafeen.hwonlesson5.databinding.ActivityMainBinding
import ru.vafeen.hwonlesson5.values.PutGet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isRegistered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState.apply {
            if (this != null) {
                isRegistered = getBoolean(PutGet.isRegistered.value)
            }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.greeting.text = "Hello Android!"
        binding.greeting.visibility = View.GONE
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.apply {
            putBoolean(PutGet.isRegistered.value, isRegistered)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.apply {
            isRegistered = getBoolean(PutGet.isRegistered.value)
        }
    }
}
