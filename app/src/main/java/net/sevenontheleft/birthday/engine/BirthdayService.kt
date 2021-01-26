package net.sevenontheleft.birthday.engine

import net.sevenontheleft.birthday.model.Results
import retrofit2.Call
import retrofit2.http.GET

interface BirthdayService {
    // this should be changed at some point to make more general and specify the query parameters rather than hardcoding them
    @GET("?results=1000&seed=chalkboard&inc=name,dob")
    fun listBirthdays() : Call<Results>
}