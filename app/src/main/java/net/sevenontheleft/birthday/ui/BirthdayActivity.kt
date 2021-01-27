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

        val initials = StringBuilder()
        if(birthday.name?.first != null && birthday.name?.first?.length != 0) {
            initials.append(birthday.name?.first!![0])
        }
        if(birthday.name?.last != null && birthday.name?.last?.length != 0) {
            initials.append(birthday.name?.last!![0])
        }
        person_picture_text.text = initials.toString().capitalize()

        name.text = birthday.name?.first
        // should probably change this to handle 1 year old (no s)
        date.text = "" + birthday.dob?.age + " " + resources.getString(R.string.years_old)
    }
}