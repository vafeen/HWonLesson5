package ru.vafeen.hwonlesson5.ui.activities.lastname

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.vafeen.hwonlesson5.databinding.ActivityLastnameBinding
import ru.vafeen.hwonlesson5.values.PutGet

class LastNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLastnameBinding

    private var firstNameData: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLastnameBinding.inflate(layoutInflater)

        intent.apply {
            firstNameData = getStringExtra(PutGet.FirstName.value)
        }

        content()
    }

    fun content() {
//        val intent = Intent(this,)

        binding.apply {

            if (firstNameData != null) {

                textData.text = "firstname = $firstNameData"

                textData.visibility = View.VISIBLE
            }

            editLastName.visibility = View.VISIBLE

            backButton.setOnClickListener {
                finish()
            }

            exitButton.setOnClickListener {
                this@LastNameActivity.finishAffinity()
            }

            forwardButton.setOnClickListener {

                intent.apply {
                    putExtra(PutGet.FirstName.value, firstNameData)
                    putExtra(PutGet.LastName.value, editLastName.text)
                }

                startActivity(intent)
            }
        }
    }
}