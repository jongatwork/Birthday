package net.sevenontheleft.birthday.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.sevenontheleft.birthday.engine.BirthdayRepo

class BirthdayViewModel(birthdayRepo: BirthdayRepo) : ViewModel() {

    val birthdayList: MutableLiveData<List<Birthday>>

    init {
        birthdayList = birthdayRepo.getBirthdays()
    }
}