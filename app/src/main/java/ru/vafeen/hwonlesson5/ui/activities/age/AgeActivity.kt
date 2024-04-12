package ru.vafeen.hwonlesson5.ui.activities.age

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.vafeen.hwonlesson5.databinding.ActivityAgeBinding
import ru.vafeen.hwonlesson5.noui.logs.logExecutor
import ru.vafeen.hwonlesson5.ui.activities.main.MainActivity
import ru.vafeen.hwonlesson5.values.PutGet

class AgeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgeBinding

    private var firstNameData: String? = null

    private var lastNameData: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAgeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        intent.apply {
            firstNameData = getStringExtra(PutGet.FirstName.value)
            lastNameData = getStringExtra(PutGet.LastName.value)
        }

        logExecutor(mes = "{AGE}lastName data = ${lastNameData}")

        content()
    }

    private fun content() {

        val intent = Intent(this, MainActivity::class.java)

        binding.apply {
            if (firstNameData != null || lastNameData != null) {
                ageTextData.visibility = View.VISIBLE

                ageTextData.text =
                    buildString {
                        append("firstName = ${firstNameData.orEmpty()} ")

                        append(
                            if (lastNameData != null) {
                                "\n lastName = ${lastNameData.orEmpty()}"
                            } else {
                                ""
                            }
                        )
                    }
            }

            editYourAge.visibility = View.VISIBLE

            confirmButton.visibility = View.VISIBLE

            exitButton.setOnClickListener {
                this@AgeActivity.finishAffinity()
            }

            backButton.setOnClickListener {
                finish()
            }

            confirmButton.setOnClickListener {
                intent.apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    putExtra(PutGet.FirstName.value, firstNameData)

                    putExtra(PutGet.LastName.value, lastNameData)

                    putExtra(PutGet.IsRegistered.value, true)
                }

                startActivity(intent)
            }
        }


    }
}