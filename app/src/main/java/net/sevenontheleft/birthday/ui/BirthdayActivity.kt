package net.sevenontheleft.birthday.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_birthday.*
import net.sevenontheleft.birthday.R
import net.sevenontheleft.birthday.model.Birthday
import java.text.SimpleDateFormat

class BirthdayActivity : AppCompatActivity() {

    companion object {
        val BIRTHDAY = "BIRTHDAY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)

        val birthday = intent.getSerializableExtra(BIRTHDAY) as Birthday

        name.text = birthday.name?.first
        date.text = SimpleDateFormat("dd-MM-yyyy").format(birthday.dob?.date).toString()
    }
}