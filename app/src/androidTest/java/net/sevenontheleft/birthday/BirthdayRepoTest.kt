package net.sevenontheleft.birthday

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import net.sevenontheleft.birthday.engine.BirthdayRepo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BirthdayRepoTest {

    private lateinit var birthdayRepo: BirthdayRepo

    @Before
    fun start() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        birthdayRepo = BirthdayRepo(context)
    }

    @Test
    // this test does not yet work because I cannot invoke observeForever on a background thread
    fun downloadBirthdays() {
        val birthdayList = birthdayRepo.getBirthdays()
        birthdayRepo.getBirthdays().observeForever {
            val dd = 34
            val ee = 33
        }
    }
}