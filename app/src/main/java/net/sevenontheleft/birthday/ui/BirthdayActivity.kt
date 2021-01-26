package net.sevenontheleft.birthday.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_birthday.*
import net.sevenontheleft.birthday.R
import net.sevenontheleft.birthday.model.Birthday

class BirthdayActivity : AppCompatActivity() {

    companion object {
        val BIRTHDAY = "BIRTHDAY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)

        val birthday = intent.getSerializableExtra(BIRTHDAY) as Birthday

        name.text = birthday.name?.first
        // should probably change this to handle 1 year old (no s)
        date.text = "" + birthday.dob?.age + " " + resources.getString(R.string.years_old)
    }
}