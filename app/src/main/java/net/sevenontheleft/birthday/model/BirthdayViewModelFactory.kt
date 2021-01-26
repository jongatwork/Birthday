package net.sevenontheleft.birthday.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.sevenontheleft.birthday.engine.BirthdayRepo

class BirthdayViewModelFactory(val birthdayRepo: BirthdayRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(BirthdayRepo::class.java).newInstance(birthdayRepo)
}