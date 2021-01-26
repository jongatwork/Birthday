package net.sevenontheleft.birthday.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.sevenontheleft.birthday.R
import net.sevenontheleft.birthday.engine.BirthdayRepo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val birthdayRepo = BirthdayRepo(this)
        birthdayRepo.getBirthdays()
    }
}