package net.sevenontheleft.birthday.engine

import net.sevenontheleft.birthday.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BirthdayService {
    // this should be changed at some point to make more general and specify the query parameters rather than hardcoding them
    // this is just left here to show how to hardcode everything in the request
//    @GET("?results=1000&seed=chalkboard&inc=name,dob")
//    fun listBirthdays() : Call<Results>

    @GET("?")
    fun listBirthdays(@Query("results") results: Int, @Query("seed") seed: String, @Query("inc") inc: String) : Call<Results>
}