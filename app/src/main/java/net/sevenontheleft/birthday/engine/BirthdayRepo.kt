package net.sevenontheleft.birthday.engine

import android.content.Context
import com.google.gson.GsonBuilder
import net.sevenontheleft.birthday.model.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// this class is used to get hold of the birthday info;
// it either comes from networking or the Room database
class BirthdayRepo(context: Context) {
    val retrofit: Retrofit
    val birthdayService: BirthdayService

    init {
        // we want the dates to be parsed automatically by gson so pass in the format
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create()
        retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        birthdayService = retrofit.create(BirthdayService::class.java)
    }

    fun getBirthdays() {
        // just want to test getting the birthday info to start with to check what we're getting
        val request: Call<Results> = birthdayService.listBirthdays()
        request.enqueue(object : Callback<Results> {
            override fun onFailure(call: Call<Results>, t: Throwable) {
                val ee = 33
                val dd = 333
                // does nothing; that's ok for now although we could show an error message i guess
            }

            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val ee = 33
                val dd = 333
                if (response.body() != null) {
                }
            }
        })
    }
}